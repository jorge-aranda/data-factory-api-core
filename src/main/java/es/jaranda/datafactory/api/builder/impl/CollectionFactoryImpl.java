
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
        final List<T> list = new LinkedList<T>();
        
        final Node<T> nodes = reverseNodes(lastNode, null);
        
        for (T value : nodes) {
            list.add(value);
        }
        
        return list;
    }
    
    private Node<T> reverseNodes(Node<T> node, Node<T> prevNode) {
        final Node<T> reversedNode;
        
        if (node.getAncestor() == null) {
            reversedNode = new Node<T>(node.getValue(), prevNode);
        } else {
            reversedNode = reverseNodes(
                    node.getAncestor(), 
                    new Node<T>(
                        node.getValue(),
                        prevNode
                    )
            );
        }
        
        return reversedNode;
    }
}
