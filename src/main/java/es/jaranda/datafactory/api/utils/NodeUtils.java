
package es.jaranda.datafactory.api.utils;

import es.jaranda.datafactory.api.model.Node;

/**
 * Do operations using Node structure
 * @author Jorge
 */
public class NodeUtils {
    
    private NodeUtils() {
        // no instanciable
    }
    
    /**
     * Reverse the order of nodes structure into a new nodes structure
     * @param <T>   Type of node
     * @param node  First node
     * @return A new nodes strucutre reversed
     */
    public static<T> Node<T> reverseNodes(Node<T> node) {
        return reverseNodes(node, null);
    }
    
    private static<T> Node<T> reverseNodes(Node<T> node, Node<T> prevNode) {
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
