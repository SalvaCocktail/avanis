package avanis.lonjas.cache;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Victor Antunez
 */
@Component(
    immediate = true,
    service = LonjasCacheUtil.class
)
public class LonjasCacheUtil {

    private static final Log _log = LogFactoryUtil.getLog(LonjasCacheUtil.class);
    private static final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();
    private static final long CACHE_EXPIRATION_TIME = TimeUnit.MINUTES.toMillis(60);

    public static Object getFromCache(String key) {
        CacheEntry entry = (CacheEntry) cache.get(key);
        if (entry == null || isExpired(entry)) {
            return null;
        }
        return entry.getValue();
    }

    public static void addToCache(String key, Object value) {
        cache.put(key, new CacheEntry(value));
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

    public void removeFromCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            _log.info("Eliminada la clave de cache: " + key);
        } else {
            _log.warn("Intento de eliminar clave inexistente en cache: " + key);
        }
    }
}