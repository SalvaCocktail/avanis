package avanis.comunidad.portlet.cache;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component(
        immediate = true,
        service = ComunidadCacheUtil.class
)
public class ComunidadCacheUtil {
    private static final Log _log = LogFactoryUtil.getLog(ComunidadCacheUtil.class);
    private static final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    public static Object getFromCache(String key) {
        CacheEntry entry = (CacheEntry) cache.get(key);
        if (entry == null) {
            _log.info("Clave no encontrada en caché: " + key);
            return null;
        }
        _log.info("Clave encontrada en caché: " + key);
        return entry.getValue();
    }

    public static void addToCache(String key, Object value) {
        cache.put(key, new CacheEntry(value));
        _log.info("Clave añadida a la caché: " + key);
    }

    public static void removeFromCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            _log.info("Clave eliminada de la caché: " + key);
        } else {
            _log.warn("Intento de eliminar una clave inexistente en caché: " + key);
        }
    }

    private static class CacheEntry {
        private final Object value;
        private final long timestamp;

        public CacheEntry(Object value) {
            this.value = value;
            this.timestamp = System.currentTimeMillis();
        }

        public Object getValue() {
            return value;
        }

    }
}
