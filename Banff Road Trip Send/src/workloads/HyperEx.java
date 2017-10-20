package workloads;

import java.util.Random;

public class HyperEx extends Workload 
{
	private Random randBool;
	private double meanTwo;
	private Random randDoubleSecond;
	
	/**
	 * Because the mean isn't consistant, two service rates are needed
	 * 
	 * 
	 * @param meanOne
	 * @param meanTwo
	 */
	public HyperEx(double meanOne, double meanTwo) 
	{
		super(meanOne);
		this.meanTwo = 1/meanTwo;
		randBool = new Random();
		randDoubleSecond = new Random();
	}
	
	
	/**
	 * To generate random numbers in an Hyper Exponential way
	 * 
	 * There's two separate means that are used, with two
	 * different seeds. Each time there's a 50 percent
	 * chance that one number will be generated assuming
	 * the mean is 1.0, and another assuming the mean
	 * is 2.0
	 * 
	 */

	@Override
	public void getTimes(int numbersToGenerate) 
	{
		double serviceTime;
		this.allResults = new double[numbersToGenerate];

		for(int i = 0; i < this.allResults.length; i++)
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
		//mean is the first mean
		return (((1/this.mean)) * Math.log((double) 1-randomNumber))*-1;
	}

	/**
	 * based on the formulat x = -(1/lambda ) * ln(1-u)
	 * in order to generate a random result in an
	 * exponential way
	 * 
	 */

	
	private double getResultSecond(double randomNumber)
	{
		return (((1/this.meanTwo)) * Math.log((double) 1-randomNumber))*-1;
	}

}
