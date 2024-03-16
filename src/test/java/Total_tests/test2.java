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

public class test2 {
	
	@Test
    public void testFindSingleCountryIndicatorHappyDay()throws FileNotFoundException, IOException {

        MainEngine ClassInstance = new MainEngine();
        String requestName = "TestRequest";
        String countryName = "TestCountry";
        String indicatorString = "TestIndicator";


        try {
            ISingleMeasureRequest result = ClassInstance.findSingleCountryIndicator(requestName, countryName, indicatorString);

            assertNotNull(result);
            assertEquals(requestName, result.getRequestName());

        } catch (IllegalArgumentException e) {
        	System.err.println("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testFindSingleCountryIndicatorRainyDay() throws FileNotFoundException, IOException{

    	MainEngine ClassInstance = new MainEngine();
        String requestName = "TestRequest";
        String countryName = "NonExistentCountry";
        String indicatorString = "NonExistentIndicator";


        try {
            ClassInstance.findSingleCountryIndicator(requestName, countryName, indicatorString);
            System.err.println("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No request found for the given parameters.", e.getMessage());
        }
    }
}

