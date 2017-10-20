package workloads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Exponential extends Workload
{
	//rv = (((1/0.5)) * Math.log((double) 1-rand.uniform()))*-1;

	
	public Exponential(double mean)
	{
		super(mean);
	}
	
	/**
	 * To generate random numbers in an exponential 
	 * way, the formula x = -(1/lambda ) * ln(1-u) is used
	 * 
	 * where x is the result, lambda     is the mean, and u is a random
	 * number between 0 and 1 
	 * 
	 */
	
	public void getTimes(int amountOfTimes)
	{
		double service;
		this.allResults = new double[amountOfTimes];
		
		for(int i = 0; i < this.allResults.length; i++)
		{
			service = randomDouble.nextDouble();
			this.allResults[i] = getResult(service);
		}
	}		
	

	/**
	 * based on the formulat x = -(1/lambda ) * ln(1-u)
	 * in order to generate a random result in an
	 * exponential way
	 * 
	 */

	
	@Override
	protected double getResult(double randomNumber) 
	{
		return (((1/this.mean)) * Math.log((double) 1-randomNumber))*-1;
	}
	
	
	
}
