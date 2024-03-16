package Total_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import dom2app.*;
import fileload.*;
import compute.*;
import exporter.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import engine.MainEngine;
public class test6 {
	@Test
    public void testHappyDayScenarioForReportToFile() {
        MainEngine yourInstance = new MainEngine(); 


        String filename = "testFile.txt", requestName = "testRequest", t = "testType";

        int result = yourInstance.reportToFile(filename, requestName, t);


        assertTrue(result >= 0); 



        File file = new File(filename);
        assertTrue(file.exists());
        assertTrue(file.delete());
    }

    @Test
    public void testIOExceptionForReportToFile() {
    	MainEngine yourInstance = new MainEngine(); 


        String filename = "invalid-directory/testFile.txt", requestName = "testRequest", t = "testType";

        int result = yourInstance.reportToFile(filename, requestName, t);


        assertEquals(-1, result); 

    }
}

