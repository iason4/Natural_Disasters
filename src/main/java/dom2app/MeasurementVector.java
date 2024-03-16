package dom2app;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.Pair;

public class MeasurementVector implements IMeasurementVector {
	private String countryName;
	private String disasterName;
	private String stats;
	private String regression;

	
	private List<Pair<Integer, Integer>> dis = new ArrayList<Pair<Integer,Integer>>();
	private List<String[]> disasters;
	
	public MeasurementVector(List<String[]> disasters) {
		this.disasters=disasters;
	}

	public String getCountryName() {
		return countryName;
	}
	
	public void setCounrtyName(String countryName) {
		this.countryName=countryName;
	}
	
	
	public String getIndicatorString() {
		return disasterName;
	}
	
	public void setIndicatorString(String disasterName) {
		this.disasterName=disasterName;
	}
	
	public List<Pair<Integer, Integer>> getMeasurements(){	
		return dis;
	}
	
	public void setMeasurements(List<Pair<Integer, Integer>> dis) {

		List<Pair<Integer, Integer>> resultList = new ArrayList<>();

		
		for (String[] row : disasters) {
        
			try {
		        String stringValue0 = row[0].trim();
		        String stringValue1 = row[1].trim();

		        if (!stringValue0.isEmpty() && !stringValue1.isEmpty()) {
		            System.out.println("Attempting to parse: result[0]=" + stringValue0 + ", result[1]=" + stringValue1);
		            int year = Integer.parseInt(stringValue0);
		            int value = Integer.parseInt(stringValue1);
		            resultList.add(new Pair<>(year, value));
		        } else {
		            System.err.println("Empty values found in the array.");
		        }
		    } catch (NumberFormatException e) {

		        System.err.println("Error parsing value: " + e.getMessage());
		    }
               
	        
		}
		this.dis=resultList;
    }
	
	public String getDescriptiveStatsAsString() {
		return stats;
	}
	
	public void setDescriptiveStatsAsString(String stats) {
		this.stats=stats;
	}
	
	public String getRegressionResultAsString() {
		return regression;
	}
	
	public void setRegressionResultAsString(String regression) {
		this.regression=regression;
	}
	
}
