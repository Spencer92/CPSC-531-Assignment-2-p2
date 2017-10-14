package workloads;

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
		// TODO Auto-generated method stub
		return 0;
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
			if(serviceTime <= this.correlation)
			{
				this.allResults[i] = this.allResults[i-1];
				this.allResults[i] += this.allResults[i-1];
			}
			else
			{
				serviceTime = randomDouble.nextDouble();
				this.allResults[i] = getResult(serviceTime);
				this.allResults[i] += this.allResults[i-1];
			}
		}
	}		
	
}
