
package es.jaranda.datafactory.api.model;

import es.jaranda.datafactory.api.operator.RangeOperator;
import java.util.Iterator;
import java.util.Objects;

/**
 * Defines a range of items
 * @author Jorge
 * @param <T> Type of the range
 */
public class Range<T> implements Iterable<T> {
    
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private T item;
            private boolean hasValue;
            
            // Anonymous constructor
            {
                this.hasValue = false;
            }
            
            @Override
            public boolean hasNext() {
                return !hasValue || !isLastValue(item);
            }

            @Override
            public T next() {
                final T next;
                
                if (hasValue) {
                    next = rangeOperator.next(item);
                } else {
                    next = firstValue;
                    hasValue = true;
                }
                
                // Updates iterator reference
                item = next;
                // Returns final value
                return next;
            }
            
            private boolean isLastValue(T value) {
                return Objects.equals(value, lastValue);
            }
        };
    }
}
