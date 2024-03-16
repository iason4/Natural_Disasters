package compute;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.util.Pair;

public class bob_com {
	
	private ArrayList<String[]> disasters;

	
	
	
	public bob_com(ArrayList<String[]> disasters)
	{
		this.disasters=disasters;
		
	}
	
	public ArrayList<String[]> find_1(String countryName, String disasterName) {
	    		ArrayList<String[]> disasterSearch = new ArrayList<>();

	    			int yearA=1980;
	    			int count = 0;
	    			

	    			ArrayList<String[]> searchResults = searchArrayListColumns(disasters, countryName,disasterName);
	    			    for (String[] row : searchResults) {
	    			        for (String element : row) {
	    			        	if(count>=5 && count<48 ) {
	    			        		
		    	                		String Value = element;
		    	                		if (Value.isEmpty()==true) {
		    			        			Value="0";
		    			        		}
		    	                		String Year = String.valueOf(yearA);
		    	                	    disasterSearch.add(new String[]{Year, Value});
		    	                	    //System.out.println(Year);
		    	                	    //System.out.println(element);
		    	                		yearA++;
	    			        		
	    			        		
	    			        	}
	    			        	count++;	    	                		    			            
	    			        }
	    			    }
	    		return disasterSearch;
	}
	
	




	
	public  ArrayList<String[]> find_2( String countryName, String disasterID,int startingYear, int endingYear) {
		ArrayList<String[]> disasterSearch=new ArrayList<String[]>();
		int count = 0;
		int start = 1980;
		int offset = startingYear - start;
		ArrayList<String[]> searchResults = searchArrayListColumns(disasters, countryName,disasterID);
		    for (String[] row : searchResults) {
		        for (String element : row) {
		        	if(startingYear!=endingYear+1) {

			        	if(count>=5+offset && count<48 ) {
	
		                		String Value = element;
		                		if (Value.isEmpty()==true) {
    			        			Value="0";
    			        		}
		                		String Year = String.valueOf(startingYear);
		                		disasterSearch.add(new String[]{Year, Value});
		                	    //System.out.println(Year);
		                	    //System.out.println(element);
		                	    startingYear++;
			        		
			        	}
			        	count++;
		        	}
		        }
		    }
		    

	return disasterSearch;
		
	}
	

	
	public  ArrayList<String[]> searchArrayListColumns(ArrayList<String[]> disasters, String countryName,String disasterName) {
	    ArrayList<String[]> searchResults = new ArrayList<>();
	
	    // Determine the index of the specified column
	    int columnIndex = getColumnIndex(disasters.get(0));
	
	    // Iterate over the rows and check the specified column
	    for (String[] row : disasters) {
	        if (row.length > columnIndex && row[columnIndex].equals(countryName) && row[columnIndex+3].equals(disasterName)) {
	            searchResults.add(row);
	        }
	    }
	
	    return searchResults;
	}
	
	public   int getColumnIndex( String[] header  ) {
	    for (int i = 0; i < header.length; i++) {
	        if (header[i].equals("Country") && header[i+3].equals("Indicator")) {
	            return i;
	        }
	    }
	    return 0; // Column not found
	}

	
}
