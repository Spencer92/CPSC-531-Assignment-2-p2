package workloads;

public class Arrival extends Workload
{


	public Arrival(double arrivalRate, boolean service) 
	{
		super(arrivalRate, service);
		this.serviceRate = 1/this.serviceRate;
	}

	@Override
	protected double getResult(double service) {
		return (((1/this.serviceRate)) * Math.log((double) 1-service))*-1;
	}

	@Override
	public void getTimes(int amountOfTimes)
	{
		double service;
		this.allResults = new double[amountOfTimes];
		
		service = this.randomDouble.nextDouble();
		this.allResults[0] = getResult(service);
		
		for(int i = 1; i < this.allResults.length; i++)
		{
			service = this.randomDouble.nextDouble();
			this.allResults[i] = getResult(service);
			this.allResults[i] += this.allResults[i-1];
		}
	}

}
