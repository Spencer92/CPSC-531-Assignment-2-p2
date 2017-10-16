package workloads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public abstract class Workload 
{
	protected Random randomDouble;
	protected double serviceRate;
	protected double allResults[];
	protected boolean service;
	
	public Workload(double serviceRate, boolean service)
	{
		randomDouble = new Random();
		this.serviceRate = 1/serviceRate;
		/*		if(!service)
		{
			this.arrivalRate = arrivalRate;
		}
		else
		{
			this.arrivalRate = 1/arrivalRate;
		}*/
		this.service = service;
	}
	
	protected abstract double getResult(double service);
	
/*	protected double getResult(double service)
	{
		return (((1/this.arrivalRate)) * Math.log((double) 1-service))*-1;
	}*/
	
	public abstract void getTimes(int amountOfTimes);
	
	public void printResults(String fileName) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter("..\\" + fileName + ".txt"));
		
		for(int i = 0; i < this.allResults.length; i++)
		{
			writer.write(Double.toString(allResults[i]) + "\r\n");
		}
		
		
		writer.close();
	}
	
	
}
