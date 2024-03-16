
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


public class test1 {

    @Test
    public void testHappyDayScenario() throws FileNotFoundException, IOException{
        MainEngine yourInstance = new MainEngine(); 

        String fileName = "_ClimateRelatedDisastersFull.tsv";
        String delimiter = ",";

        try {
            List<IMeasurementVector> result = yourInstance.load(fileName, delimiter);


            assertNotNull(result);
            assertEquals(1, result.size());
 
        } catch (Exception e) {
        	System.err.println("Exception not expected in happy day scenario: " + e.getMessage());
        }
    }

    @Test
    public void testRainyDayScenario() throws FileNotFoundException, IOException{
    	MainEngine yourInstance = new MainEngine(); 

        String fileName = "austr.tsv";
        String delimiter = ",";

        try {
            List<IMeasurementVector> result = yourInstance.load(fileName, delimiter);

            assertNotNull(result);
            assertEquals(-1, result.size());
            System.err.println("Expected FileNotFoundException or IOException");
        } catch (IOException e) {

            assertNotNull(e.getMessage());
        }
    }
}