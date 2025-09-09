package avanis.lonjas.vo;

import java.util.Date;

public class InfoProducto {

    private long entityId;
    private String nombreLonja;
    private long idLonja;
    private String nombreProducto;
    private long productoId;
    private String fechaProducto;
    private String precioUltimo;
    private String precioAnterior;
    private String unidadMedida;
    private Double variacionPorcentaje;
    private String fechaLonja;
    private String fechaLonjaFilter;
    private String nombreGrupo;
    private String idGrupo;
    private boolean favorito;
    private Date dateProducto;

    public long getEntityId() { return entityId; }

    public void setEntityId(long entityId) { this.entityId = entityId; }

    public String getNombreLonja() {
        return nombreLonja;
    }

    public void setNombreLonja(String nombreLonja) {
        this.nombreLonja = nombreLonja;
    }

    public long getIdLonja() {
        return idLonja;
    }

    public void setIdLonja(long idLonja) {
        this.idLonja = idLonja;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public String getPrecioUltimo() {
        return precioUltimo;
    }

    public void setPrecioUltimo(String precioUltimo) {
        this.precioUltimo = precioUltimo;
    }

    public String getPrecioAnterior() {
        return precioAnterior;
    }

    public void setPrecioAnterior(String precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getVariacionPorcentaje() {
        return variacionPorcentaje;
    }

    public void setVariacionPorcentaje(Double variacionPorcentaje) {
        this.variacionPorcentaje = variacionPorcentaje;
    }

    public String getFechaLonja() {
        return fechaLonja;
    }

    public void setFechaLonja(String fechaLonja) {
        this.fechaLonja = fechaLonja;
    }

    public String getFechaLonjaFilter() {
        return fechaLonjaFilter;
    }

    public void setFechaLonjaFilter(String fechaLonjaFilter) {
        this.fechaLonjaFilter = fechaLonjaFilter;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getFechaProducto() {
        return fechaProducto;
    }

    public void setFechaProducto(String fechaProducto) {
        this.fechaProducto = fechaProducto;
    }

    public boolean isFavorito() { return favorito; }

    public void setFavorito(boolean favorito) { this.favorito = favorito; }

    public Date getDateProducto() {
        return dateProducto;
    }

    public void setDateProducto(Date dateProducto) {
        this.dateProducto = dateProducto;
    }

    @Override
    public String toString() {
        return "InfoProducto{" +
                "entityId=" + entityId +
                ", nombreLonja='" + nombreLonja + '\'' +
                ", idLonja=" + idLonja +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", productoId=" + productoId +
                ", fechaProducto='" + fechaProducto + '\'' +
                ", precioUltimo='" + precioUltimo + '\'' +
                ", precioAnterior='" + precioAnterior + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", variacionPorcentaje=" + variacionPorcentaje +
                ", fechaLonja='" + fechaLonja + '\'' +
                ", fechaLonjaFilter='" + fechaLonjaFilter + '\'' +
                ", nombreGrupo='" + nombreGrupo + '\'' +
                ", idGrupo='" + idGrupo + '\'' +
                ", favorito=" + favorito +
                ", dateProducto=" + dateProducto +
                '}';
    }
}

