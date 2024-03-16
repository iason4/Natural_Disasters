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
public class test3 {
	 @Test
	    public void testHappyDayScenario() throws FileNotFoundException, IOException{
	        MainEngine yourInstance = new MainEngine(); 


	        String requestName = "testRequest", countryName = "TestCountry", indicatorString = "TestIndicator";
	        int startYear = 2000, endYear = 2020;

	        try {
	            ISingleMeasureRequest result = yourInstance.findSingleCountryIndicatorYearRange(requestName, countryName, indicatorString, startYear, endYear);


	            assertNotNull(result);


	        } catch (IllegalArgumentException e) {
	        	System.err.println("Unexpected exception in happy day scenario: " + e.getMessage());
	        }
	    }

	    @Test
	    public void testRainyDayScenario() throws FileNotFoundException, IOException{
	    	MainEngine yourInstance = new MainEngine();


	        String requestName = "testRequest", countryName = "NonExistentCountry", indicatorString = "NonExistentIndicator";
	        int startYear = 2000, endYear = 2020;

	        try {
	            ISingleMeasureRequest result = yourInstance.findSingleCountryIndicatorYearRange(requestName, countryName, indicatorString, startYear, endYear);


	            System.err.println("Expected IllegalArgumentException, but no exception was thrown");

	        } catch (IllegalArgumentException e) {

	            assertEquals("No request found for the given parameters.", e.getMessage());

	        }
	    }
}

