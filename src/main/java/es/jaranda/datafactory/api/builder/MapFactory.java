
package es.jaranda.datafactory.api.builder;

import java.util.Map;

/**
 * Makes maps using DSL language
 * @author Jorge
 * @param <K> Type to use as key in your final Map
 * @param <V> Type to use as value in your final Map
 */
public interface MapFactory<K,V> {
    
    /**
     * Add new entry into your final collection
     * 
     * @param key    Key of entry to be included in your final map
     * @param value  Value of entry to be included in your final map
     * 
     * @return MapFactory to still building your final map
     */
    MapFactory<K,V> entry(K key, V value);
    
    /**
     * Generate a map with all entries sorted by declaration order
     * @return A map with all entries
     */
    Map<K,V> toMap();
}
