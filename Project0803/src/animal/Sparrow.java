package animal;
public class Sparrow extends Bird{
	boolean isBury = true;
	String name="참새";
	
	/*
	상속시 자식 클래스가 부모클래스의 메서드를 완전히 동일하게 재정의할 수 있는
	메서드 정의기법을 가리켜 override라 한다.
	오버로딩 - 한 클래스 내에서 메서드명을 동일하게 정의하는 기법
	오버라이딩 - 상속관계에서 부모 메서드를 재정의
	*/
	public void wing(){
		System.out.println("참새가 날갯짓하다.");
	}
}
