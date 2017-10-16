package workloads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import equalikely.Equalikely;

public class Deterministic extends Workload
{
	public Deterministic(double arrivalRate, boolean service) {
		super(arrivalRate, service);
		// TODO Auto-generated constructor stub
	}

	
/*	public Deterministic(double lamda, String arrivalTimeFile, String serviceTimeFile)
	{
		arrival = 0;
		serviceTime = 1.5;
		this.lamda = lamda;
		rand = new Equalikely();
		try {
			this.arrivalTimeWriter = new BufferedWriter(new FileWriter(arrivalTimeFile));
			this.serviceTimeWriter = new BufferedWriter(new FileWriter(serviceTimeFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}*/
/*	
	public void generateRandomTimes(int amountCars) throws IOException
	{
		if(amountCars > 0)
		{
			for(int i = 0; i < amountCars; i++)
			{
				this.arrival += calcArrival();
				this.arrivalTimeWriter.write(Double.toString(this.arrival));
				this.serviceTimeWriter.write(Double.toString(this.serviceTime));
				
			}
		}
	}
	
	private double calcArrival()
	{
		double rawArrival = RVGen();
		rawArrival = round(rawArrival);
		
		
		return rawArrival;
	}
	
	private double calcServiceTime()
	{
		return serviceTime;
	}
	
	private double round(double number)
	{
		number *= 1000;
		Math.round(number);
		return number/1000;
	}
	
	private double RVGen()
	{
		double s = 0.0;
		double n = 0.0;
		double x;
		double rv = 0;// = ((1/this.lamda)*(-1)) * Math.log((double) rand.uniform());
		//rv *= -1;
		
		while(s < 1.0)
		{
			rv = ((1/this.lamda)*(-1)) * Math.log((double) rand.uniform());
			rv *= -1;
			s += rv;
			n++;
			
		}
		
		x = n-1;
		return rv;
	}*/


	@Override
	public void getTimes(int amountOfTimes) 
	{
		this.allResults = new double[amountOfTimes];
		
		for(int i = 0; i < this.allResults.length; i++)
		{
			this.allResults[i] = 1.5;
		}
	}


	@Override
	protected double getResult(double service) {
		return 1.5;
	}
	
}
