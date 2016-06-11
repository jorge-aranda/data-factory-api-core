
package es.jaranda.datafactory.api.model;

import java.io.Serializable;

/**
 * Provides a simplificated infrastructure to recover a simpled Linked List
 * 
 * @author Jorge
 * @param <T> Type contained in the node
 */
public class Node<T> implements Serializable {
    
    private static final long serialVersionUID = -4854576544039411941L;

    private final T value;
    private final Node<T> ancestor;

    public Node(T value, Node<T> ancestor) {
        this.value = value;
        this.ancestor = ancestor;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", ancestor=" + ancestor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node<?> other = (Node<?>) obj;
        if (this.value != other.value && (this.value == null || 
                !this.value.equals(other.value))) {
            return false;
        }
        if (this.ancestor != other.ancestor && (this.ancestor == null || 
                !this.ancestor.equals(other.ancestor))) {
            return false;
        }
        return true;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getAncestor() {
        return ancestor;
    }
    
    
    
    
}
