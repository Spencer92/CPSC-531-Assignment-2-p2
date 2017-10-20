package workloads;

import java.util.Random;

public class HyperEx extends Workload 
{
	private Random randBool;
	private double serviceRateSecondHalf;
	private Random randDoubleSecond;
	public HyperEx(double serviceRateFirstHalf, double serviceRateSecondHalf, boolean service) 
	{
		super(serviceRateFirstHalf, service);
		this.serviceRateSecondHalf = 1/serviceRateSecondHalf;
		randBool = new Random();
		randDoubleSecond = new Random();
	}

	@Override
	public void getTimes(int amountOfTimes) 
	{
		double serviceTime;
		this.allResults = new double[amountOfTimes];
		
		try
		{
			if(randBool.nextBoolean())
			{
				serviceTime = randomDouble.nextDouble();
				this.allResults[0] = getResult(serviceTime);
			}
			else
			{
				serviceTime = randDoubleSecond.nextDouble();
				this.allResults[0] = getResultSecond(serviceTime);
			}	
			
		}
		catch(NullPointerException e)
		{
			System.err.println("No value given");
			return;
		}
		for(int i = 1; i < this.allResults.length; i++)
		{
			if(randBool.nextBoolean())
			{
				serviceTime = randomDouble.nextDouble();
				this.allResults[i] = getResult(serviceTime);
			}
			else
			{
				serviceTime = randDoubleSecond.nextDouble();
				this.allResults[i] = getResultSecond(serviceTime);
			}
				
			
//			this.allResults[i] += this.allResults[i-1];
			}

	}

	@Override
	protected double getResult(double randomNumber) 
	{
//		if(randBool.nextBoolean() || !this.service)
//		{
		return (((1/this.serviceRate)) * Math.log((double) 1-randomNumber))*-1;
//		}
//		else
//		{
//			return (((1/this.arrivalRateSecondHalf)) * Math.log((double) 1-service))*-1;
//		}
	}
	
	private double getResultSecond(double randomNumber)
	{
		return (((1/this.serviceRateSecondHalf)) * Math.log((double) 1-randomNumber))*-1;
	}

}
