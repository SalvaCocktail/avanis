package avanis.buscador.portlet.vo;

import java.util.Date;
import java.util.List;

public class Noticia {

    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private int tiempoLectura;
    private String imagen;
    private String url;
    private List<String> categorias;
    private List<String> categoryUrls ;
    private String videoDuration;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getTiempoLectura() {
        return tiempoLectura;
    }

    public void setTiempoLectura(int tiempoLectura) {
        this.tiempoLectura = tiempoLectura;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public List<String> getCategoryUrls() {
        return categoryUrls;
    }

    public void setCategoryUrls(List<String> categoryUrls) {
        this.categoryUrls = categoryUrls;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", tiempoLectura=" + tiempoLectura +
                ", imagen='" + imagen + '\'' +
                ", url='" + url + '\'' +
                ", categorias=" + categorias +
                ", categoryUrls=" + categoryUrls +
                ", videoDuration='" + videoDuration + '\'' +
                '}';
    }
}
