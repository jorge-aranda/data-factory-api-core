

package es.jaranda.datafactory.api.builder;

import java.util.List;

/**
 * Makes collections using DSL language
 * @author Jorge
 * @param <T> Type to use into your final Collection
 */
public interface CollectionFactory<T> {
    
    /**
     * Add new item into your final collection
     * 
     * @param item  Item to be included in your final collection
     * 
     * @return CollectionFactory to still building your final collection
     */
    CollectionFactory<T> item(T item);
    
    /**
     * Generate a list with all elements sorted by declaration order
     * @return A list with all elements
     */
    List<T> toList();
}
