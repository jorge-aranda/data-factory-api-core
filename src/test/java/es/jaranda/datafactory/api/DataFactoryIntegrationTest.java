
package es.jaranda.datafactory.api;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Functionality whole test
 * @author Jorge
 */
public class DataFactoryIntegrationTest {
    
    private static final String HELLO_WORLD_STRING = "Hello World!";
    
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
}
