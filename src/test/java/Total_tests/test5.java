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
public class test5 {
	 @Test
	    public void testHappyDayScenarioForGetRegression() {
	        MainEngine yourInstance = new MainEngine(); 

	        String requestName = "testRequest";

	        ISingleMeasureRequest result = yourInstance.getRegression(requestName);


	        assertNotNull(result);

	    }

	    @Test
	    public void testRegressionResultStringForGetRegression() {
	    	MainEngine yourInstance = new MainEngine();


	        String requestName = "testRequest";

	        ISingleMeasureRequest result = yourInstance.getRegression(requestName);


	        assertNotNull(result);

	        assertEquals("Expected regression result string", "YourExpectedString", result.getRegressionResultString());
	    }
}
