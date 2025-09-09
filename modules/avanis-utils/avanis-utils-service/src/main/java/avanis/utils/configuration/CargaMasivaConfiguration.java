package avanis.utils.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import org.osgi.annotation.versioning.ProviderType;

@ExtendedObjectClassDefinition(category = "other", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "avanis.utils.configuration.CargaMasivaConfiguration", localization = "content/Language", name = "Carga Masiva Configuraciones")
@ProviderType
public interface CargaMasivaConfiguration {

    @Meta.AD(name = "Estructuras Carga Masiva", description = "ID Estructuras separadas por ;", deflt="123704", required = true)
    String estructurasCargaMasiva();

    @Meta.AD(name = "Templates Carga Masiva", description = "ID Estructuras separadas por ;", deflt="123722", required = true)
    String templatesCargaMasiva();

    @Meta.AD(name = "Cabecera Carga Masiva Ayudas", description = "Cabeceras separadas por ;", deflt="id;idSector;idTipoAyuda;idAmbito;Titulo;objetivo;Beneficiarios;Requisitos;Importe;Proceso Trámitación;Plazo Solicitud;Normativa;Fecha de Alta;Fecha de baja;Fecha de modificación;Fecha Inicio Solicitud;Fecha fin solicitud;Fecha inicio difusión;Fecha fin difusión;Situación", required = true)
    String cabeceraCargaMasivaAyudas();

    @Meta.AD(
        name = "Mapa de valores del CSV",
        description = "JSON con los mapeos de valores numéricos a texto",
        deflt = "{\"ambito\":{\"1\":\"Andalucía\",\"2\":\"Aragón\",\"3\":\"Asturias\",\"4\":\"Baleares, Islas\",\"5\":\"Canarias, Islas\",\"6\":\"Cantabria\",\"7\":\"Castilla La Mancha\",\"8\":\"Cataluña\",\"9\":\"Extremadura\",\"10\":\"Galicia\",\"11\":\"La Rioja\",\"12\":\"Madrid\",\"13\":\"Murcia\",\"14\":\"Navarra\",\"15\":\"Pais Vasco\",\"16\":\"Valencia\",\"17\":\"UE / Nacional\",\"19\":\"Castilla y León\"},\"sector\":{\"1\":\"Cultivos herbáceos\",\"2\":\"Olivar\",\"3\":\"Viñedo\",\"4\":\"Frutas y hortalizas\",\"5\":\"Plantas textiles\",\"6\":\"Cultivos industriales\",\"7\":\"Vacuno de carne\",\"8\":\"Porcino\",\"9\":\"Ovino/caprino\",\"10\":\"Leche y productos lácteos\",\"11\":\"Conejos\",\"12\":\"Otros\"},\"situacion\":{\"1\":\"En desarrollo\",\"2\":\"Terminado\"},\"tipoAyuda\":{\"1\":\"Modernización de estructuras\",\"2\":\"Desarrollo rural\",\"3\":\"Asociacionismo agrario\",\"4\":\"Seguros agrarios\",\"5\":\"Sanidad animal y vegetal\",\"6\":\"Industrialización y comercialización\",\"7\":\"Apoyo a los mercados\",\"8\":\"Ayudas por superficie\",\"9\":\"Primas ganaderas\"}}",
        required = true
    )
    String mapaValoresCSV();

    @Meta.AD(name = "Carpeta Ayudas y Subvenciones", deflt="123777", required = true)
    long getFolderAyudasId();
}

