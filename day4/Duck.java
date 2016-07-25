class Duck{
	/*이름, 나이*/
	String name="도날드";
	static int age=3; //클래스 변스(인스턴스에 소속되지 안고, 글래스 원복에 소속된다고 하여...

	public void test(){
		System.out.println("오리의 나이는"+age);
	}

	public static void test2(){
		System.out.println("오리의 이름는"+name);
	}
	
	public static void main(String[] args)	{
		Duck d = new Duck();
		d.test();
		
	}
}
