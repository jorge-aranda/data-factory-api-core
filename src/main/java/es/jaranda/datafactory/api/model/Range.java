
package es.jaranda.datafactory.api.model;

import es.jaranda.datafactory.api.operator.RangeOperator;

// TODO pending implement Iterable<T>
/**
 * Defines a range of items
 * @author Jorge
 * @param <T> Type of the range
 */
public class Range<T> {
    
    private final T firstValue;
    private final T lastValue;
    private final RangeOperator<T> rangeOperator;

    public Range(T firstValue, T lastValue, RangeOperator<T> rangeOperator) {
        this.firstValue = firstValue;
        this.lastValue = lastValue;
        this.rangeOperator = rangeOperator;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + 
                (this.firstValue != null ? this.firstValue.hashCode() : 0);
        hash = 43 * hash + 
                (this.lastValue != null ? this.lastValue.hashCode() : 0);
        hash = 43 * hash + 
                (this.rangeOperator != null ? 
                 this.rangeOperator.hashCode() : 0);
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
        final Range<?> other = (Range<?>) obj;
        if (this.firstValue != other.firstValue && (this.firstValue == null || 
                !this.firstValue.equals(other.firstValue))) {
            return false;
        }
        if (this.rangeOperator != other.rangeOperator && (
                this.rangeOperator == null || 
                !this.rangeOperator.equals(other.rangeOperator))) {
            return false;
        }
        return true;
    }
    
    

}
