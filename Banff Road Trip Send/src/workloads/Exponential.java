package workloads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Exponential extends AWorkload
{
	private Random randomDouble;
	private Double arrivalRate;
	private Double serviceRate;
	
	public Exponential(Double arrivalRate)
	{
		this.arrivalRate = arrivalRate;
		randomDouble = new Random();
	}
	
	
	public void getTimes(int amountOfTimes, String fileName)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			
			
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
