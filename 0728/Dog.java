class Dog {

	String name = "뽀미";
	
	//main()이라는 실행부가 dog이라는 자료형을 메모리에 올릴때 실행
	//클래스가 메모리에 올려질때 실행
	//static 초기화 블럭
	//클래스가 최초에 로드되어질때 수행
	static{
		System.out.println("static 초기화 블럭 수행!!");
	}
	
	
	/*인스턴스 초기화 블럭!!
		- 이 클래스로부터 생성되는 인스턴스가 있을때마다 이 영역이 수행됨.
	*/
	//클래스로부터 인스턴스가 생성될때마다 수행
	{
		System.out.println("인스턴스 초기화 블럭 수행!!");	
	}

	public static void main(String[] args) 
	{
		new Dog(); //이름이 없으면, 이후 라인에서 제어 불가능!!
		Dog d = new Dog();
	}
}
