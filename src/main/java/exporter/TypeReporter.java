package exporter;

import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.Pair;


public class TypeReporter {
	
	
	private String t;
	private String request;
	private ArrayList<String[]> list;
	private FileWriter wr;
	private String country;
	private ArrayList<String[]> measurements;
	private String indicator;
	private String stats;
	private String reg;
	
	public TypeReporter(String filename,String request,String t,String country,String indicator,ArrayList<String[]> measurements,String stats,String reg)
	{
		this.t=t;
		this.request=request;
		this.country=country;
		this.indicator=indicator;
		this.measurements=measurements;
		this.stats=stats;
		this.reg=reg;
				
		 try {
			wr = new FileWriter(filename);
		} catch (IOException t1) {
			
			System.out.println("the path is not valid");
		}
	}
	
	public int reportToFile() throws IOException
	{
		if(t== "text")
		{
			return textReport();
			
		}else if(t=="html")
		{
			return htmlReport();
		}else if(t=="md")
		{
			return mdReport();
		}
		return -1;
	}
	
	private int textReport() throws IOException 
	{
		int disasters=0;
		
		String temp="";
		
		temp+="NameRequest :"+ "\t"+"\t"+request+"\n"+"CountryAndDisaster :"+ "\t"+country + "\t" +indicator+"\n"+"ResultList :"+ "\t"+"\t";
		 

					for (String[] row : measurements) {	
						temp+="[";
				        for (String element : row) {
				        		temp+= element  +"\t";	
				        }
				        temp+="]";
					}
					
					temp+="\n";
					temp+="BasicStat :"+"\t"+"\t"+stats+"\n"+"RegressionResult :"+"\t"+reg+"\n";
		        
		 
			disasters++;
		
		
		
		wr.write(temp);
		wr.close();
		return disasters;
	}
	
	
	private int htmlReport() throws IOException 
	{

		int disasters=0;
		String temp="";
		temp+="<pre>";
		temp+="<table>";
		
		temp+="<tr>";
		    temp += "NameRequest :" + "\t" + "\t" + "<b>"+request +"</b>"+ "\n" + "CountryAndDisaster :" + "\t" + "<i>"+country + "\t" + indicator + "</i>"+ "\n" + "ResultList :" + "\t" + "\t";

		    for (String[] row : measurements) {    
		        temp += "[";
		        for (String element : row) {
		            temp += element + "\t";    
		        }
		        temp += "]";
		    }
		    
		    temp += "\n";
		    temp += "BasicStat :" + "\t" + "\t" + stats + "\n" + "RegressionResult :" + "\t" + reg + "\n";
		    
		    disasters++;
		
		temp+="</table>";
		temp+="<pre>";
		wr.write(temp);
		wr.close();
		return disasters;		
	}
	
	private int mdReport() throws IOException 
	{

		int disasters = 0;

	    String temp = "";
	    temp+="<pre>";
	    temp += "NameRequest :" + "\t" + "\t" + "<b>"+request +"</b>"+ "\n" + "CountryAndDisaster :" + "\t" + "<i>"+country + "\t" + indicator + "</i>"+ "\n" + "ResultList :" + "\t" + "\t";

	    for (String[] row : measurements) {
	        temp += "[";
	        for (String element : row) {
	            temp += element + "\t";
	        }
	        temp += "]";
	    }

	    temp += "\n";
	    temp += "BasicStat :" + "\t" + "\t" + stats + "\n" + "RegressionResult :" + "\t" + reg + "\n";

	    disasters++;
	    temp+="</pre>";
	    
	    wr.write(temp);
	    wr.close();
	    return disasters;
	}
	


}
