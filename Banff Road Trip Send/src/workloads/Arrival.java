package workloads;

public class Arrival extends Workload
{

	private double lambda;
	public Arrival(double lambda) 
	{
		super(lambda);
		this.lambda = 1/this.mean;
	}

	
	/**
	 * based on the formulat x = -(1/lambda ) * ln(1-u)
	 * in order to generate a random result in an
	 * exponential way
	 * 
	 */

	
	@Override
	protected double getResult(double randomNumber) {
		return (((1.0/this.lambda)) * Math.log((double) 1-randomNumber))*-1;
	}

	
	/**
	 * This is for the arrival times, it is similar
	 * to how all the other times are generated, but
	 * each time the number adds up, instead of
	 * every number being (relatively) independent 
	 * of each other
	 */
	
	@Override
	public void getTimes(int amountOfTimes)
	{
		double randomNumber;
		this.allResults = new double[amountOfTimes];
		
		randomNumber = this.randomDouble.nextDouble();
		this.allResults[0] = getResult(randomNumber);
		
		for(int i = 1; i < this.allResults.length; i++)
		{
			randomNumber = this.randomDouble.nextDouble();
			this.allResults[i] = getResult(randomNumber);
			this.allResults[i] += this.allResults[i-1];
		}
	}

}
