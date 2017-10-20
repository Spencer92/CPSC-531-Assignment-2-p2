package workloads;

public class Deterministic extends Workload
{
	public Deterministic(double mean) {
		super(mean);
	}


	/**
	 * There is no variation for a deterministic
	 * method of generation
	 * 
	 */
	
	@Override
	public void getTimes(int numbersToGenerate) 
	{
		this.allResults = new double[numbersToGenerate];
		
		for(int i = 0; i < this.allResults.length; i++)
		{
			this.allResults[i] = 1.5;
		}
	}

	
	/**
	 * this isn't actually used.
	 * 
	 */
	@Override
	protected double getResult(double randomNumber) {
		return 1.5;
	}
	
}
