/*
1.Cat이라는 이름의 고양이 클래스를 정의하되,
이름 나이 종류를 멤버로 보유하시오...

2.특히 종류의 경우엔 static으로 선언 하시오~~~
3.현재 클래스에 main실행부를 두되,
  고양이의 이름,나이,종류를 출력하시오.

*/
class  Cat
{
	String name = "나옹이";
	int age = 2; //인스턴스변수
	static String type ="고양이과"; //클래스변수
		
	}
	public static void main(String[] args) 
	{
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		Cat.type="파충류";//Cat이라는 
		System.out.println("이름은"+c.name+"나이는"+c.age);
	
	}//여기서 stact에 변수가 없어진다. heap에 객체는 신경쓰지마라..알아서 없어준다...
}
//cmd창 끄면..jvm은 살아있고..객체는 알아서..죽인다..