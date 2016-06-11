
package es.jaranda.datafactory.api;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Functionality whole test
 * @author Jorge
 */
public class DataFactoryIntegrationTest {
    
    private static final String HELLO_WORLD_STRING = "Hello World!";
    
    private static final Integer[] KEYS  = {1, 2, 3};
    private static final String[] VALUES = {"One", "Two" , "Three"};
    
    @Test
    public void toListTest() {
        final List<String> helloWorldList = DataFactory
            .item("Hello")
            .item(" ")
            .item("World")
            .item("!")
        .toList();

        final String helloWorldStr = (
            StringUtils.join(helloWorldList, StringUtils.EMPTY)
        );
        
        assertEquals(HELLO_WORLD_STRING, helloWorldStr);
    }
    
    @Test
    public void toMapTest() {
        final Map<Integer, String> numbersMap = DataFactory
            .entry(KEYS[0], VALUES[0])
            .entry(KEYS[1], VALUES[1])
            .entry(KEYS[2], VALUES[2])
        .toMap();
        
        assertEquals(VALUES[0], numbersMap.get(KEYS[0]));
        assertEquals(VALUES[1], numbersMap.get(KEYS[1]));
        assertEquals(VALUES[2], numbersMap.get(KEYS[2]));
    }
}
