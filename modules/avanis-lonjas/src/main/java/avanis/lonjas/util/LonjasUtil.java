package avanis.lonjas.util;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.lonjas.configuration.AvanisLonjasWidgetConfig;
import avanis.lonjas.model.Grupo;
import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.model.ProductoExplot;
import avanis.lonjas.model.ProductoUser;
import avanis.lonjas.model.Lonja;
import avanis.lonjas.model.FechaLonja;
import avanis.lonjas.service.FechaLonjaLocalServiceUtil;
import avanis.lonjas.service.GrupoLocalServiceUtil;
import avanis.lonjas.service.LonjaLocalServiceUtil;
import avanis.lonjas.service.PrecioLonjaLocalServiceUtil;
import avanis.lonjas.service.ProductoExplotLocalServiceUtil;
import avanis.lonjas.service.ProductoUserLocalServiceUtil;
import avanis.lonjas.vo.InfoProducto;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Victor Antunez
 */
@Component(
    immediate = true,
    configurationPid = "avanis.lonjas.configuration.AvanisLonjasWidgetConfig",
    service = LonjasUtil.class
)
public class LonjasUtil {

    private volatile AvanisLonjasWidgetConfig _config;
    
    private final Map<Long, Lonja> lonjaCache = new HashMap<>();
    private final Map<Long, FechaLonja> fechaLonjaCache = new HashMap<>();

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_config = Configurable.createConfigurable(AvanisLonjasWidgetConfig.class, properties);
	}

    public long plotValidoUser(long plotId, long userId){
        long plotValido = 0;
        List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(userId);
        if (!explotaciones.isEmpty()) {
            if(Validator.isNotNull(plotId)){
                for (Explotacion explotacion : explotaciones) {
                    if (plotId == explotacion.getExplotacionId()){
                        plotValido = plotId;
                    }
                }
            } else {
                plotValido = explotaciones.get(0).getExplotacionId();
            }
        }
        return plotValido;
    }

    public List productosParcela(long plotId, long userId){
        List<InfoProducto> listaProductos = new ArrayList<>();

        List<ProductoExplot> productoExplotSearch = ProductoExplotLocalServiceUtil.getProductoExplotByExplotacionId(plotId);
        
        Set<Long> lonjaIds = productoExplotSearch.stream()
                .map(ProductoExplot::getLonjaId)
                .collect(Collectors.toSet());

        Set<Long> productoIds = productoExplotSearch.stream()
                .map(ProductoExplot::getProductoId)
                .collect(Collectors.toSet());

        
        OrderByComparator<PrecioLonja> orderByComparator = OrderByComparatorFactoryUtil.create("AVANIS_LONJAS_PRECIOLONJA", "fecha", false);
        Map<String, PrecioLonja> precios = PrecioLonjaLocalServiceUtil
                .getLatestByLonjaIdsAndProductoIds(lonjaIds, productoIds, orderByComparator)
                .stream()
                .collect(Collectors.toMap(pl -> pl.getLonjaId() + "_" + pl.getProductoId(), pl -> pl));

        productoExplotSearch.forEach(pe -> {
            PrecioLonja precio = precios.get(pe.getLonjaId() + "_" + pe.getProductoId());
            if (precio != null) {
                listaProductos.add(completarInfoProducto(precio, null, userId));
            }
        });

        return listaProductos;
    }

    public List getFavoritosUser(long userId){
        List<InfoProducto> favoritosUser = new ArrayList<>();

        List<ProductoUser> favoritosUserSearch = ProductoUserLocalServiceUtil.getProductoUserByUserId(userId);
        Set<Long> lonjaIds = favoritosUserSearch.stream()
                .map(ProductoUser::getLonjaId)
                .collect(Collectors.toSet());

        Set<Long> productoIds = favoritosUserSearch.stream()
                .map(ProductoUser::getProductoId)
                .collect(Collectors.toSet());

        OrderByComparator<PrecioLonja> orderByComparator = OrderByComparatorFactoryUtil.create(
                "AVANIS_LONJAS_PRECIOLONJA", "fecha", false);

        Map<String, PrecioLonja> precios = PrecioLonjaLocalServiceUtil
                .getLatestByLonjaIdsAndProductoIds(lonjaIds, productoIds, orderByComparator)
                .stream()
                .collect(Collectors.toMap(pl -> pl.getLonjaId() + "_" + pl.getProductoId(), pl -> pl));

        Set<Long> grupoIds = precios.values().stream()
                .map(PrecioLonja::getGrupoId)
                .collect(Collectors.toSet());

        Map<Long, Grupo> grupos = GrupoLocalServiceUtil.getGrupos(grupoIds).stream()
                .collect(Collectors.toMap(Grupo::getGrupoId, g -> g));

        for (ProductoUser favoritoUser : favoritosUserSearch) {
            PrecioLonja precio = precios.get(favoritoUser.getLonjaId() + "_" + favoritoUser.getProductoId());
            if (precio != null) {
                Grupo grupo = grupos.get(precio.getGrupoId());
                favoritosUser.add(completarInfoProducto(precio, grupo, userId));
            }
        }
        return favoritosUser;
    }

    public InfoProducto completarInfoProducto(PrecioLonja producto, Grupo grupo, long userId) {
        InfoProducto infoProducto = new InfoProducto();

        infoProducto.setEntityId(producto.getEntityId());

        if (grupo != null) {
            infoProducto.setNombreGrupo(grupo.getNombre());
            infoProducto.setIdGrupo(String.valueOf(grupo.getGrupoId()));
        }

        Lonja lonja = lonjaCache.computeIfAbsent(producto.getLonjaId(),
                id -> LonjaLocalServiceUtil.getLonjaBylonjaId(id).stream().findFirst().orElse(null));
        if (lonja != null) {
            infoProducto.setNombreLonja(lonja.getNombre());
            infoProducto.setIdLonja(lonja.getLonjaId());
        }

        FechaLonja fechaLonja = fechaLonjaCache.computeIfAbsent(producto.getLonjaId(),
                id -> FechaLonjaLocalServiceUtil.getFechaLonjaByLonjaId(id).stream().findFirst().orElse(null));
        if (fechaLonja != null) {
            infoProducto.setFechaLonja(fechaFormato(fechaLonja.getFecha()));
        }

        infoProducto.setNombreProducto(producto.getNombreProducto());
        infoProducto.setProductoId(producto.getProductoId());
        infoProducto.setPrecioUltimo(producto.getPrecioUltimo());
        infoProducto.setPrecioAnterior(producto.getPrecioAnterior());
        infoProducto.setUnidadMedida(producto.getUnidadMedida());
        infoProducto.setFechaProducto(fechaFormato(producto.getFecha()));
        infoProducto.setFechaLonjaFilter(fechaFormatoFilter(producto.getFecha()));
        infoProducto.setDateProducto(producto.getFecha());

        try {
            double precioUltimo = obtenerPromedioSiEsRango(producto.getPrecioUltimo().replace(",", "."));
            double precioAnterior = obtenerPromedioSiEsRango(producto.getPrecioAnterior().replace(",", "."));

            double variacionPorcentaje = precioAnterior != 0 ? ((precioUltimo - precioAnterior) / precioAnterior) * 100 : 0.0;
            infoProducto.setVariacionPorcentaje(Math.round(variacionPorcentaje * 100.0) / 100.0);
        } catch (NumberFormatException e) {
            infoProducto.setVariacionPorcentaje(0.0);  // Manejo de errores de formato numérico
        }

        infoProducto.setFavorito(isFavorito(userId, infoProducto.getIdLonja(), infoProducto.getProductoId()));

        return infoProducto;
    }

    public Boolean isFavorito(long userId, long idLonja, long productoId){
        ProductoUser productoUser = ProductoUserLocalServiceUtil.getProductoUserByUserIdAndProductoId(userId, idLonja, productoId);
        return Validator.isNotNull(productoUser) ? true : false;
    }

    public double obtenerPromedioSiEsRango(String precioStr) throws NumberFormatException {
        if (precioStr.contains("/")) {
            String[] partes = precioStr.split("/");
            double valor1 = Double.parseDouble(partes[0]);
            double valor2 = Double.parseDouble(partes[1]);
            return (valor1 + valor2) / 2;
        } else {
            return Double.parseDouble(precioStr);
        }
    }

    public String fechaFormato(Date fechaLonja) {
        LocalDateTime fecha = fechaLonja.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        DateTimeFormatter salidaFormatter = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaFormateada = fecha.format(salidaFormatter);
        fechaFormateada = fechaFormateada.substring(0, 1).toUpperCase() + fechaFormateada.substring(1);
        return fechaFormateada;
    }

    public String fechaFormatoFilter(Date fechaLonja) {
        LocalDateTime fecha = fechaLonja.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
        DateTimeFormatter filterFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fecha.format(filterFormatter);
    }

    public String ctdaProductosMostrados() {
        return Validator.isNotNull(_config.ctdaProductosMostrados()) ? _config.ctdaProductosMostrados() : "10";
    }

    public String ctdaIncrementoProductos() {
        return Validator.isNotNull(_config.ctdaIncrementoProductos()) ? _config.ctdaIncrementoProductos() : "10";
    }

    public String ctdaProductosPorParcela() {
        return Validator.isNotNull(_config.ctdaProductosPorParcela()) ? _config.ctdaProductosPorParcela() : "5";
    }

    public String ctdaUltimasSubastasDetalleProducto() {
        return Validator.isNotNull(_config.ctdaUltimasSubastasDetalleProducto()) ? _config.ctdaUltimasSubastasDetalleProducto() : "20";
    }

    public String capitalizeWords(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.toLowerCase(Locale.ROOT).split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return capitalized.toString().trim();
    }
}
