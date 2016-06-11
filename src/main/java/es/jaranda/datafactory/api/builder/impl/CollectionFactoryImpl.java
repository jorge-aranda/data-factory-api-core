
package es.jaranda.datafactory.api.builder.impl;

import es.jaranda.datafactory.api.builder.CollectionFactory;
import es.jaranda.datafactory.api.model.Node;
import java.util.Collections;
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
        
        final LinkedList<T> nodes = new LinkedList<T>();
        Node<T> currentNode = lastNode;
        
        while(currentNode != null) {
            nodes.add(currentNode.getValue());
            currentNode = currentNode.getAncestor();
        }
        
        Collections.reverse(nodes); // XXX this is a first version. It needs to improve algorithm
        
        return nodes;
    }
}
