
package es.jaranda.datafactory.api;

import es.jaranda.datafactory.api.builder.CollectionFactory;
import es.jaranda.datafactory.api.builder.MapFactory;
import es.jaranda.datafactory.api.builder.impl.CollectionFactoryImpl;

/**
 * Contains all methods to begin using API into static way
 * @author Jorge
 */
public class DataFactory {
    
    private DataFactory() {
        // no instanciable
    }
    
    /**
     * Add new item into your final collection
     * 
     * @param <T>   Generic type of your data
     * @param item  Item to be included in your final collection
     * 
     * @return CollectionFactory to still building your final collection
     */
    public static <T> CollectionFactory<T> item(T item) {
        final CollectionFactory<T> factory = new CollectionFactoryImpl<T>();
        return factory.item(item);
    }
    
    /**
     * Add new entry into your final collection
     * 
     * @param key    Key of entry to be included in your final map
     * @param value  Value of entry to be included in your final map
     * @param <K>    Type to use as key in your final Map
     * @param <V>    Type to use as value in your final Map
     * 
     * @return MapFactory to still building your final map
     */
    public static <K, V> MapFactory<K,V> entry(K key, V value) {
        // TODO stub, implement this method
        throw new UnsupportedOperationException("not supported yet");
    }
}
