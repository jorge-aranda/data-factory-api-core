
package es.jaranda.datafactory.api.operator;

/**
 * Increase the next value of the range
 * @author Jorge
 */
public interface RangeOperator<T> {
    T operate(T ancestor);
}
