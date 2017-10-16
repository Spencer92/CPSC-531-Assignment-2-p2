package banffRoadTripSend;

import java.io.IOException;

import equalikely.Equalikely;
import workloads.*;

public class BanffRoadTrip {

	
	public BanffRoadTrip(String[] args) throws IOException
	{
		int amountOfTimes = 10000;
		Workload lowestLamb = new Arrival(0.5,true);
		Workload sLowestLamb = new Arrival(0.55,true);
		Workload sHighestLamb = new Arrival(0.6, true);
		Workload highestLamb = new Arrival(0.65, true);
		Workload deterministic = new Deterministic(1.5,true);
		Workload exponential = new Exponential(1.5,true);
		Workload hyperEx = new HyperEx(1.0,2.0,true);
		Workload corrEx = new CorrEx(1.5,true);
		
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
		double rv = 0;
		double s = 0;
		double n = 0;
		Equalikely rand = new Equalikely();
		
		new BanffRoadTrip(args);
		
/*		for(int i = 0; i < 10000; i++)
		{
				rv = (((1/0.5)) * Math.log((double) 1-rand.uniform()))*-1;
				
				System.out.println(rv);
		}*/
		
/*		Workload lowestLamb = new Arrival(0.5,true);
		Workload sLowestLamb = new Arrival(0.55,true);
		Workload sHighestLamb = new Arrival(0.6, true);
		Workload highestLamb = new Arrival(0.65, true);
		Workload deterministic = new Deterministic(1.5,true);
		Workload exponential = new Exponential(1.5,true);
		Workload hyperEx = new HyperEx(1.0,2.0,true);
		Workload corrEx = new CorrEx(1.5,true);
		
		lowestLamb.printResults("0.5 Lambda");
		sLowestLamb.printResults("0.55 Lambda");
		sHighestLamb.printResults("0.6 Lambda");
		highestLamb.printResults("0.65 Lambda");
		
		deterministic.printResults("Deterministic");
		exponential.printResults("Exponential");
		hyperEx.printResults("HyperEx");
		corrEx.printResults("CorrEx");*/
		

	}
	


}
