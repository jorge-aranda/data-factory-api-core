
package es.jaranda.datafactory.api;

import es.jaranda.datafactory.api.builder.CollectionFactory;
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
}
