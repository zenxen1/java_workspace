class Duck{
	/*�̸�, ����*/
	String name="������";
	static int age=3; //Ŭ���� ����(�ν��Ͻ��� �Ҽӵ��� �Ȱ�, �۷��� ������ �Ҽӵȴٰ� �Ͽ�...

	public void test(){
		System.out.println("������ ���̴�"+age);
	}

	public static void test2(){
		System.out.println("������ �̸���"+name);
	}
	
	public static void main(String[] args)	{
		Duck d = new Duck();
		d.test();
		
	}
}
