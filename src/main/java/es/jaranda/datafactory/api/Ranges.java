
package es.jaranda.datafactory.api;

import es.jaranda.datafactory.api.model.Range;
import es.jaranda.datafactory.api.operator.RangeOperator;

/**
 * Build immutables ranges which can be iterated or used in a lazy way
 */
public class Ranges {
    
    private Ranges() {
        // no instanciable
    }
    
    /**
     * Makes a range of items which can be iterated or can be used in a lazy
     * way
     * 
     * @param <T> Type of the range
     * 
     * @param firstValue     First value of range
     * @param lastValue      Last value of range
     * @param rangeOperator  Recives a function to calculate the rest or range
     *                       values.
     *                       <p> For example: range(1, 5, i -> i + 2) generates:
     *                          [1, 3, 5] values
     * 
     * @return Ranges definition
     */
    public static <T> Range<T> range(T firstValue, T lastValue, 
            RangeOperator<T> rangeOperator) {
        return new Range<T>(firstValue, lastValue, rangeOperator);
    }
    
}
