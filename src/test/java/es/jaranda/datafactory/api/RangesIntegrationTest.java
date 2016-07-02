
package es.jaranda.datafactory.api;

import es.jaranda.datafactory.api.operator.RangeOperator;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test Ranges static class
 * @author Jorge
 */
public class RangesIntegrationTest {
    
    private static final int INITIAL_INTEGER = 5;
    private static final int FINAL_INTEGER = 50000000;
    
    private static final int SINGLE_VALUE = 1;
    
    private static final String INITIAL_STRING = "Hello ";
    private static final String FINAL_STRING = "Hello World!";
    
    private static final String[] EXPECTED_STRING = {"Hello ", "Hello W", 
        "Hello Wo", "Hello Wor", "Hello Worl", "Hello World", "Hello World!"};
    
    
    public void commonRangeTest() {
        
        final RangeOperator<Integer> incrementor = new RangeOperator<Integer>() {
            @Override
            public Integer next(Integer current) {
                return current++;
            }
        };
        
        int i = INITIAL_INTEGER;
        for (Integer current : 
                Ranges.range(INITIAL_INTEGER, FINAL_INTEGER, incrementor)) {
            assertEquals((int) i, (int) current);
        }
    }
    
    @Test
    public void singleValueRangeTest() {
        
        boolean hasValue = false;
        
        for (int current :
            Ranges.range(SINGLE_VALUE, SINGLE_VALUE, 
                    new RangeOperator<Integer>() {
                        @Override
                        public Integer next(Integer current) {
                            return current;
                        }
                    }
            )) {
            assertEquals(SINGLE_VALUE, current);
            assertEquals("The range returns more values and the " +
                         "expected is only one", false, hasValue);
            
            hasValue = true;
        }
    }
    
    @Test
    public void stringRangeTest() {
        
        int i = 0;
        for (String current : Ranges.range(INITIAL_STRING, FINAL_STRING, 
                new RangeOperator<String>() {
                    
                    private final Map<Character, Character> map = DataFactory
                            .entry(' ', 'W')
                            .entry('W', 'o')
                            .entry('o', 'r')
                            .entry('r', 'l')
                            .entry('l', 'd')
                            .entry('d', '!')
                            .toMap();
                    
                    @Override
                    public String next(String current) {
                        final char lastCharacter = 
                                current.toCharArray()[current.length() - 1];
                        
                        return current + map.get(lastCharacter);
                    }
                }
        )) {
            assertEquals(EXPECTED_STRING[i], current);
            i++;
        }
    }
}
