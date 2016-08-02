package use;

import com.iot.main.Bike;
class UseBike{
	public static void main(String[] args) 
	{
		Bike b = new Bike();
		b.cc=1000;
		b.run();
		System.out.println(b.price);
	}
}
