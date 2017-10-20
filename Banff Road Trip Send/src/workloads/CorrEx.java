package workloads;

import java.util.Random;

public class CorrEx extends Workload 
{
	private double correlation;
	public CorrEx(double mean) 
	{
		super(mean);
		this.correlation = 0.2;
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
		return (((1.0/this.mean)) * Math.log((double) 1.0-randomNumber))*-1;
	}
	
	public void getTimes(int amountOfTimes, double correlation)
	{
		this.correlation = correlation;
		getTimes(amountOfTimes);
	}

	
	/**
	 * To generate random numbers in a Correlated Exponential way
	 * is very similar to how a regular exponential is generated.
	 * 
	 * However, there is a random chance that the same number will
	 * show up twice in a row
	 * 
	 */
	
	@Override
	public void getTimes(int amountOfTimes) 
	{
		double serviceTime;
		Random correlationRand = new Random();
		this.allResults = new double[amountOfTimes];
		try
		{
			serviceTime = randomDouble.nextDouble();
			this.allResults[0] = getResult(serviceTime);
		}
		catch(NullPointerException e)
		{
			System.err.println("No arrival amount given");
			return;
		}
		for(int i = 1; i < this.allResults.length; i++)
		{

			if(correlationRand.nextDouble() <= this.correlation)
			{
				this.allResults[i] = getResult(serviceTime);
			}
			else
			{
				serviceTime = randomDouble.nextDouble();
				this.allResults[i] = getResult(serviceTime);
			}

		}
	}		
	
}
