package workloads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import equalikely.Equalikely;

public class Deterministic extends AWorkload
{
	private double arrival;
	private double serviceTime;
	private double lamda;
	private Equalikely rand;
	private BufferedWriter arrivalTimeWriter;
	private BufferedWriter serviceTimeWriter;
	
	public Deterministic(double lamda, String arrivalTimeFile, String serviceTimeFile)
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
		
	}
	
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
	}
	
}
