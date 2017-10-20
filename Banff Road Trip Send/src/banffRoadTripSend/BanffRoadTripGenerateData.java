package banffRoadTripSend;

import java.io.IOException;
import workloads.*;

public class BanffRoadTripGenerateData {

	
	public BanffRoadTripGenerateData(String[] args) throws IOException
	{
		int amountOfTimes = 10000;
		Workload lowestLamb = new Arrival(0.5);
		Workload sLowestLamb = new Arrival(0.55);
		Workload sHighestLamb = new Arrival(0.6);
		Workload highestLamb = new Arrival(0.65);
		Workload deterministic = new Deterministic(1.5);
		Workload exponential = new Exponential(1.5);
		Workload hyperEx = new HyperEx(1.0,2.0);
		Workload corrEx = new CorrEx(1.5);
		
		lowestLamb.getTimes(amountOfTimes);
		sLowestLamb.getTimes(amountOfTimes);
		sHighestLamb.getTimes(amountOfTimes);
		highestLamb.getTimes(amountOfTimes);
		deterministic.getTimes(amountOfTimes);
		exponential.getTimes(amountOfTimes);
		hyperEx.getTimes(amountOfTimes);
		corrEx.getTimes(amountOfTimes);
		
		
		lowestLamb.printResults("0.5 Lambda");
		sLowestLamb.printResults("0.55 Lambda");
		sHighestLamb.printResults("0.6 Lambda");
		highestLamb.printResults("0.65 Lambda");
		
		deterministic.printResults("Deterministic");
		exponential.printResults("Exponential");
		hyperEx.printResults("HyperEx");
		corrEx.printResults("CorrEx");		
	}
	
	public static void main(String[] args) throws IOException 
	{		
		new BanffRoadTripGenerateData(args);
	}
	


}
