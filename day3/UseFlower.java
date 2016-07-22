class UseFlower{
	public static void main(String[] args){
		
		for(int i=0;i<10;i++){
			Flower f1 = new Flower();
			f1.bloom();
			System.out.println(f1.name);
			System.out.println(f1.color);
			System.out.println(f1.thorn);

		}

	}
}
