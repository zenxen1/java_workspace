class Duck{
	/*
	오리가 탄생할떄, 무언가 초기화 할 작업이 있다면, 생성자 메서드의 기회를 놓치지 말자!!
	*/
	String name;
	String color;
	
	/*this란 현재 디자인 타임의 클래스 기준이 아니라, 이 클래스 원본으로터 태어나는 인스턴스가 
	    자기자신을 가리킬 수 있는 대명사 
		*/
	public Duck(){
		this.name="도날드";
		this.color="흰색";
		System.out.println(color + name + "가 태어나요!!");
	}

	public void init(){
		this.name="도날드";
		this.color="흰색";
		System.out.println(color + name + "가 태어나요!!");
	}
}
