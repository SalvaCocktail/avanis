package avanis.utils.api.util;

import com.liferay.portal.kernel.json.JSONArray;

public interface CategoriasUtils {

    JSONArray getCategoriasAvanis(boolean separator);

    JSONArray getCategoriasUserDedications(boolean separator);

    JSONArray getCategoriasHijaPorNombre(String nombreCategoriaPadre);

    JSONArray getCategoriasBlogs(boolean separator);

    long getVocabularioAvanis();

    boolean mostrarTitulosBuscador();

    JSONArray getUrlsCategoriaByArticleId(long articleId);

    JSONArray getCategoriasBlogsMasFiltros(boolean separator);
}
