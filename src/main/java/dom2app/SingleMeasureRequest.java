package dom2app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.util.Pair;


public class SingleMeasureRequest implements  ISingleMeasureRequest{
	private String requestName;
	private String filter;
	private String countryName;
	private String disasterName;
	private String total_stats;
	private String total_reg;
	private MeasurementVector ans ;
	private List<Pair<Integer, Integer>> measurements = new ArrayList<>();

	

	
	public SingleMeasureRequest(List<Pair<Integer, Integer>> measurements,String requestName) {
		this.requestName=requestName;
		this.measurements=measurements;

	}
	
	




	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName=requestName;
		
	}
	
	public String getRequestFilter() {
		return filter;
	}
	
	public void setRequestFilter(String filter) {
		this.filter=filter;
		filter = countryName + " " + disasterName;
	}
	
	public boolean isAnsweredFlag(){
		return true;
	}
	
	public MeasurementVector getAnswer() {	
		return ans;
	}
	
	public void setAnswer(MeasurementVector ans) {
		this.ans=ans;
		ans.setMeasurements(ans.getMeasurements());
	}
	

	
	public String getDescriptiveStatsString() {

		DescriptiveStatistics stats = new DescriptiveStatistics();
		for(Pair<Integer, Integer> xyPair: measurements) {
			int value = xyPair.getSecond();
			stats.addValue(value);
		}
		long count = stats.getN();
		double minD = stats.getMin();
		double gMean = stats.getGeometricMean();
		double mean = stats.getMean();
		double medianD = stats.getPercentile(50);
		double maxD = stats.getMax();
		double kurtosis = stats.getKurtosis();
		double stdev = stats.getStandardDeviation();
		double sumD = stats.getSum();
		
		String sta1 = String.valueOf(count);
		String sta2 = String.valueOf(minD);
		String sta3 = String.valueOf(gMean);
		String sta4 = String.valueOf(mean);
		String sta5 = String.valueOf(medianD);
		String sta6 = String.valueOf(maxD);
		String sta7 = String.valueOf(kurtosis);
		String sta8 = String.valueOf(stdev);
		String sta9 = String.valueOf(sumD);
		
		total_stats = "[count=" + sta1 + ", min=" + sta2 + ", gMean=" + sta3 + ", mean=" + sta4 + ", median=" + sta5 + ", max=" + sta6 + ", kurtosis=" + sta7 + ", stdev=" + sta8 + ", sum=" + sta9 + "]";
		return total_stats;
	}
	

	public String getRegressionResultString() {

		SimpleRegression regression = new SimpleRegression();
		for(Pair<Integer, Integer> xyPair: measurements) {
			int year = xyPair.getFirst();
			int value = xyPair.getSecond();
			regression.addData(year, value);
		}
		double intercept = regression.getIntercept();
		double slope = regression.getSlope();
		double slopeError = regression.getSlopeStdErr();

		String reg1 = String.valueOf(intercept);
		String reg2 = String.valueOf(slope);
		String reg3 = String.valueOf(slopeError);
		total_reg = "[ intercept="  + reg1 + ", slope=" + reg2 + ", slopeError=" + reg3 + "]";	
		return total_reg;
	}




	
}
