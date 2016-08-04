package car;
class UseCar{
	public static void main(String[] args){
		Truck t = new Truck();
		Bus b = new Bus();

		Car c = t;
		c.go();
		Car c2 = b;
		c2.go();
	}
}
