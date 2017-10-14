package workloads;

import java.util.Random;

public class HyperEx extends Workload 
{
	private Random randBool;
	private double arrivalRateSecondHalf;
	private Random randDoubleSecond;
	public HyperEx(double arrivalRateFirstHalf, double arrivalRateSecondHalf, boolean service) 
	{
		super(arrivalRateFirstHalf, service);
		this.arrivalRateSecondHalf = arrivalRateSecondHalf;
		randBool = new Random();
		randDoubleSecond = new Random();
	}

	@Override
	public void getTimes(int amountOfTimes) 
	{
		double serviceTime;
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
				
			
			this.allResults[i] += this.allResults[i-1];
			}

	}

	@Override
	protected double getResult(double service) 
	{
//		if(randBool.nextBoolean() || !this.service)
//		{
			return (((1/this.arrivalRate)) * Math.log((double) 1-service))*-1;
//		}
//		else
//		{
//			return (((1/this.arrivalRateSecondHalf)) * Math.log((double) 1-service))*-1;
//		}
	}
	
	private double getResultSecond(double service)
	{
		return (((1/this.arrivalRateSecondHalf)) * Math.log((double) 1-service))*-1;
	}

}
