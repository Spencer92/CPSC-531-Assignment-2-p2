package workloads;

import java.util.Random;

public class CorrEx extends Workload 
{
	private double correlation;
	public CorrEx(double arrivalRate, boolean service) 
	{
		super(arrivalRate, service);
		this.correlation = 0.2;
	}

	@Override
	protected double getResult(double service) 
	{
		return (((1/this.serviceRate)) * Math.log((double) 1-service))*-1;
	}
	
	public void getTimes(int amountOfTimes, double correlation)
	{
		this.correlation = correlation;
		getTimes(amountOfTimes);
	}

	@Override
	public void getTimes(int amountOfTimes) 
	{
		double serviceTime;
		Random correlationRand = new Random();
		int aboveOne = 0;
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
				this.allResults[i] += this.allResults[i-1];
			}
			else
			{
				serviceTime = randomDouble.nextDouble();
				this.allResults[i] = getResult(serviceTime);			
				this.allResults[i] += this.allResults[i-1];
			}

		}
		System.out.println(aboveOne + "total above one");
	}		
	
}
