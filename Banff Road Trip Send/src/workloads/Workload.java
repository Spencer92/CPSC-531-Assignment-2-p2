package workloads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public abstract class Workload 
{
	protected Random randomDouble;
	protected double mean;
	protected double allResults[];
	
	public Workload(double mean)
	{
		randomDouble = new Random();
		this.mean = 1/mean;
	}
	
	protected abstract double getResult(double randomNumber);
	
	/**
	 * This function generates a random amount of numbers
	 * based on the formula x = -(1/lambda ) * ln(1-u)
	 * 
	 * where x is the result, lambda is the mean, and u is a random
	 * number between 0 and 1 
	 * 
	 * @param numbersToGenerate how many numbers are being generated
	 */
	
	public abstract void getTimes(int numbersToGenerate);
	
	
	
	public void printResults(String fileName) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter("..\\" + fileName + ".txt"));
		
		for(int i = 0; i < this.allResults.length; i++)
		{
			writer.write(Double.toString(allResults[i]) + "\r\n");
		}
		
		
		writer.close();
	}
	
	
}
