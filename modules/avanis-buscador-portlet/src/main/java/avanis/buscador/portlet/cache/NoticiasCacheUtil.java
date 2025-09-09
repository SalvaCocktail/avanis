package avanis.buscador.portlet.cache;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(immediate = true, service = NoticiasCacheUtil.class)
public class NoticiasCacheUtil {

    private static final Log _log = LogFactoryUtil.getLog(NoticiasCacheUtil.class);
    private static final String BLOGS_CACHE_KEY = "blogsTodas";
    private static Map<String, Object> cache = new HashMap<>();

    @Reference
    private BlogsEntryLocalService _blogsEntryLocalService;

    public List<BlogsEntry> getFromCache(String key) {
        return (List<BlogsEntry>) cache.get(key);
    }

    public void updateCache() {
        clearCache(BLOGS_CACHE_KEY);

        try {
            // Obtener todos los BlogsEntry y ordenarlos por la fecha de publicación
            List<BlogsEntry> blogsTodas = _blogsEntryLocalService.getBlogsEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
                    .stream()
                    .filter(blog -> blog.getStatus() == WorkflowConstants.STATUS_APPROVED) // Filtrar solo los aprobados
                    .sorted(Comparator.comparing(BlogsEntry::getDisplayDate).reversed()) // Ordenar por fecha descendente
                    .collect(Collectors.toList());

            List<BlogsEntry> blogsEntriesWithoutFirst = blogsTodas.subList(1, blogsTodas.size());

            addToCache(BLOGS_CACHE_KEY, blogsEntriesWithoutFirst);

            _log.debug("Caché de blogs actualizada correctamente y ordenada por fecha de publicación.");
        } catch (Exception e) {
            _log.error("Error al actualizar la caché de blogs: ", e);
        }
    }

    public void addToCache(String key, List<BlogsEntry> blogs) {
        _log.debug("Añadiendo blogs a la caché con clave: " + key);
        cache.put(key, blogs);
    }

    private void clearCache(String key) {
        _log.debug("Limpiando la caché con clave: " + key);
        cache.remove(key);
    }
}
