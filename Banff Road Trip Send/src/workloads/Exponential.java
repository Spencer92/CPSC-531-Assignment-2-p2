package workloads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Exponential extends Workload
{
	//rv = (((1/0.5)) * Math.log((double) 1-rand.uniform()))*-1;

	
	public Exponential(double arrivalRate, boolean service)
	{
		super(arrivalRate, service);
	}
	
	public void getTimes(int amountOfTimes)
	{
		double service;
		this.allResults = new double[amountOfTimes];
		
		try
		{
			service = randomDouble.nextDouble();
			this.allResults[0] = getResult(service);
		}
		catch(NullPointerException e)
		{
			System.err.println("No arrival amount given");
			return;
		}
		for(int i = 1; i < this.allResults.length; i++)
		{
			service = randomDouble.nextDouble();
			this.allResults[i] = getResult(service);
//			this.allResults[i] += this.allResults[i-1];
		}
	}		
	

	@Override
	protected double getResult(double service) 
	{
		return (((1/this.serviceRate)) * Math.log((double) 1-service))*-1;
	}
	
	
	
}
