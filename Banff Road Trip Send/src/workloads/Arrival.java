package workloads;

public class Arrival extends Workload
{


	public Arrival(double arrivalRate, boolean service) 
	{
		super(arrivalRate, service);
	}

	@Override
	protected double getResult(double service) {
		return (((1/this.arrivalRate)) * Math.log((double) 1-service))*-1;
	}

	@Override
	public void getTimes(int amountOfTimes)
	{
		double service;
		this.allResults = new double[amountOfTimes];
		for(int i = 0; i < this.allResults.length; i++)
		{
			service = this.randomDouble.nextDouble();
			this.allResults[i] = getResult(service);
		}
	}

}