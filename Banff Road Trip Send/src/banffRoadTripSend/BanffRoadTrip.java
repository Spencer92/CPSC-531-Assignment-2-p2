package banffRoadTripSend;

import equalikely.Equalikely;

public class BanffRoadTrip {

	public static void main(String[] args) 
	{
		double rv = 0;
		double s = 0;
		double n = 0;
		Equalikely rand = new Equalikely();
		for(int i = 0; i < 10000; i++)
		{
				rv = (((1/0.5)) * Math.log((double) 1-rand.uniform()))*-1;
				
				System.out.println(rv);
		}

	}

}
