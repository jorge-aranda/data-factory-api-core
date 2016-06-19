
package es.jaranda.datafactory.api.operator;

/**
 * Increase the next value of the range
 * @author Jorge
 * @param <T> Type of range
 */
public interface RangeOperator<T> {
    
    /**
     * Get next value in the range from current
     * @param current Current favlue
     * @return Next value in the range
     */
    T next(T current);
}
