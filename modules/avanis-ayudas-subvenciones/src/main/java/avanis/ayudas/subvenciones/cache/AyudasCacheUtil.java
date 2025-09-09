package avanis.ayudas.subvenciones.cache;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component(
        immediate = true,
        service = AyudasCacheUtil.class
)
public class AyudasCacheUtil {
    private static final Log _log = LogFactoryUtil.getLog(AyudasCacheUtil.class);
    private static final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();
    private static final long CACHE_EXPIRATION_TIME = TimeUnit.MINUTES.toMillis(60);

    public static Object getFromCache(String key) {
        CacheEntry entry = (CacheEntry) cache.get(key);
        if (entry == null) {
            _log.info("Clave no encontrada en caché: " + key);
            return null;
        }
        if (isExpired(entry)) {
            _log.info("Clave expirada en caché: " + key);
            cache.remove(key);
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

    private static boolean isExpired(CacheEntry entry) {
        return System.currentTimeMillis() - entry.getTimestamp() > CACHE_EXPIRATION_TIME;
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

        public long getTimestamp() {
            return timestamp;
        }
    }
}
