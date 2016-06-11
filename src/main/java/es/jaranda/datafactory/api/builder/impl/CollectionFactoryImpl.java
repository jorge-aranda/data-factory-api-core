
package es.jaranda.datafactory.api.builder.impl;

import es.jaranda.datafactory.api.builder.CollectionFactory;
import java.util.List;

/**
 * Implementation of CollectionFactory
 * @author Jorge
 * @param <T> Type to use into your final Collection
 * 
 * @see es.jaranda.datafactory.api.builder.CollectionFactory
 */
public class CollectionFactoryImpl<T> implements CollectionFactory<T> {
    
    @Override
    public CollectionFactory<T> item(T item) {
        // TODO not implemented yet
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<T> toList() {
        // TODO not implemented yet
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
