package engine;

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

import org.apache.commons.math3.util.Pair;





public class MainEngine implements IMainController {
	
	private ArrayList<String[]> many_disasters= new ArrayList<String[]>();
	private ArrayList<String[]>  requests = new ArrayList<String[]>();
	private Set<String> requestNames = new HashSet<>();
	private List<Pair<Integer, Integer>> measurements = new ArrayList<>();
	private ArrayList<String[]> mini_disasters= new ArrayList<String[]>();
	private String country;
	private String indicator;
	private String fileName;
	

	
	
	public List<IMeasurementVector> load( String fileName, String delimiter)throws FileNotFoundException, IOException
	{
		this.fileName=fileName;
		ArrayList<String[]> disasters=new ArrayList<String[]>();
		FileLoader f= new  FileLoader(fileName,delimiter);
		
		try
		{
			disasters = f.load();
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		many_disasters=disasters;
		
		List<IMeasurementVector> dis = new ArrayList<>();
		IMeasurementVector m = new MeasurementVector(many_disasters);
		dis.add(m);
		return dis;
	}


	public ISingleMeasureRequest findSingleCountryIndicator(String requestName, String countryName,String indicatorString) throws IllegalArgumentException 
	{
		country=countryName;
		indicator=indicatorString;
		bob_com comp = new bob_com(many_disasters);
		ArrayList<String[]> find = comp.find_1(countryName,indicatorString);
		mini_disasters=find;
		MeasurementVector ans = new MeasurementVector(find);
		ans.setMeasurements(ans.getMeasurements());
		measurements = ans.getMeasurements();
		SingleMeasureRequest si = new SingleMeasureRequest(measurements,requestName);
		

	    
		
		si.setAnswer(ans);
		requests.add(new String[] {requestName});
		if (find.isEmpty()) {
	        throw new IllegalArgumentException("No request found for the given parameters.");
	    }
		requestNames.add(requestName);
		return si ;
	}
	


	public ISingleMeasureRequest findSingleCountryIndicatorYearRange(String requestName, String countryName,String indicatorString, int startYear, int endYear) throws IllegalArgumentException 
	{
		country=countryName;
		indicator=indicatorString;
		bob_com comp = new bob_com(many_disasters);
		ArrayList<String[]> find = comp.find_2(countryName,indicatorString,startYear,endYear);
		mini_disasters=find;
		MeasurementVector ans = new MeasurementVector(find);
		ans.setMeasurements(ans.getMeasurements());
		measurements = ans.getMeasurements();
		SingleMeasureRequest si = new SingleMeasureRequest(measurements,requestName);
		

	    
		si.setAnswer(ans);
		requests.add(new String[] {requestName});
		if (find.isEmpty()) {
	        throw new IllegalArgumentException("No request found for the given parameters.");
	    }
		requestNames.add(requestName);
		return si ;
	}


	public Set<String> getAllRequestNames() {
		Set<String> result = new  HashSet<>();
		if(this.requests == null)
			return result;
		int i =0;
		for(String[] s: this.requests) {
			result.add(s[i]);
			i++;
		}
		return result;
	}

    public ISingleMeasureRequest getRequestByName(String requestName) {
    	SingleMeasureRequest req = new SingleMeasureRequest(measurements,requestName);
    	for (String[] row : requests) {
	        for (String element : row) {
	        	req.setRequestName(element);
	        	return req;
	        }
    	}
    	return req;
    }
 
	
	public ISingleMeasureRequest getRegression(String requestName){
		
		SingleMeasureRequest s = new SingleMeasureRequest(measurements,requestName);
		s.getRegressionResultString();
		return s;
	}


	public ISingleMeasureRequest getDescriptiveStats(String requestName) {
		SingleMeasureRequest s = new SingleMeasureRequest(measurements,requestName);
		s.getDescriptiveStatsString();
		return s;
	}
	
	public int reportToFile(String filename,String requestName,String t ) {
		SingleMeasureRequest s = new SingleMeasureRequest(measurements,requestName);
		TypeReporter r = new TypeReporter(filename,requestName,t,country,indicator,mini_disasters,s.getDescriptiveStatsString(),s.getRegressionResultString());
		
		try
		{
			return r.reportToFile();
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		return -1;
	
	}
	
	
}
