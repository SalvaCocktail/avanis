package avanis.lonjas.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "other", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id = "avanis.lonjas.configuration.AvanisLonjasWidgetConfig", localization = "content/Language", name = "Lonjas Widget Config")
public interface AvanisLonjasWidgetConfig {

    @Meta.AD(name = "Ctda Productos Mostrados", deflt="10")
    String ctdaProductosMostrados();

    @Meta.AD(name = "Ctda Incremento Productos", deflt="10")
    String ctdaIncrementoProductos();

    @Meta.AD(name = "Ctda Productos Por Parcela", deflt="5")
    String ctdaProductosPorParcela();

    @Meta.AD(name = "Ctda Últimas Subastas De Detalle Producto", deflt="20")
    String ctdaUltimasSubastasDetalleProducto();
}
