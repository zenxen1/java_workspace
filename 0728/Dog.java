class Dog {

	String name = "�ǹ�";
	
	//main()�̶�� ����ΰ� dog�̶�� �ڷ����� �޸𸮿� �ø��� ����
	//Ŭ������ �޸𸮿� �÷����� ����
	//static �ʱ�ȭ ����
	//Ŭ������ ���ʿ� �ε�Ǿ����� ����
	static{
		System.out.println("static �ʱ�ȭ ���� ����!!");
	}
	
	
	/*�ν��Ͻ� �ʱ�ȭ ����!!
		- �� Ŭ�����κ��� �����Ǵ� �ν��Ͻ��� ���������� �� ������ �����.
	*/
	//Ŭ�����κ��� �ν��Ͻ��� �����ɶ����� ����
	{
		System.out.println("�ν��Ͻ� �ʱ�ȭ ���� ����!!");	
	}

	public static void main(String[] args) 
	{
		new Dog(); //�̸��� ������, ���� ���ο��� ���� �Ұ���!!
		Dog d = new Dog();
	}
}