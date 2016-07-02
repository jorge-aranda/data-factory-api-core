
package es.jaranda.datafactory.api.builder.impl;

import es.jaranda.datafactory.api.builder.CollectionFactory;
import es.jaranda.datafactory.api.model.Node;
import es.jaranda.datafactory.api.utils.NodeUtils;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of CollectionFactory
 * @author Jorge
 * @param <T> Type to use into your final Collection
 * 
 * @see es.jaranda.datafactory.api.builder.CollectionFactory
 */
public class CollectionFactoryImpl<T> implements CollectionFactory<T> {
    
    private final Node<T> lastNode;
    
    public CollectionFactoryImpl() {
        this(null);
    }
    
    private CollectionFactoryImpl(Node<T> lastNode) {
        this.lastNode = lastNode;
    }
    
    @Override
    public CollectionFactory<T> item(T item) {
        final Node<T> newNode = new Node(item, lastNode);
        return new CollectionFactoryImpl<T>(newNode); 
    }

    @Override
    public List<T> toList() {
        // TODO in future this method calls to another which can passed any kind of list
        final List<T> list = new LinkedList<T>();
        
        final Node<T> nodes = NodeUtils.reverseNodes(lastNode);
        
        for (T value : nodes) {
            list.add(value);
        }
        
        return list;
    }
}
