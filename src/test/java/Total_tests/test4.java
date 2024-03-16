package Total_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import org.junit.Test;
import dom2app.*;
import fileload.*;
import compute.*;
import exporter.*;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import engine.MainEngine;
public class test4 {
	@Test
    public void testHappyDayScenario() {
        MainEngine yourInstance = new MainEngine(); 


        String requestName = "testRequest";

        ISingleMeasureRequest result = yourInstance.getDescriptiveStats(requestName);


        assertNotNull(result);

    }

    @Test
    public void testRainyDayScenario() {
    	MainEngine yourInstance = new MainEngine();


        String requestName = "NonExistentRequest";

        ISingleMeasureRequest result = yourInstance.getDescriptiveStats(requestName);
        

        assertNotNull(result);
        assertEquals("Expected DescriptiveStats result string", "YourExpectedString", result.getDescriptiveStatsString());

    }
}
