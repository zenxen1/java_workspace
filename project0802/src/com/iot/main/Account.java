//클래스 작성시,변수는 private으로 접근을 제한하고 이 변수에 대한 조작은 메서드를 통해 제공하는 객체지향 언어의 개발 기법을 가리켜 
//은닉화(=encapusulation)라 한다.
package com.iot.main;

public class  Account{
	
	//실제적으로 클래스가 보유한 데이터는 보호
	//대상이다. 따라서 private 보안 처리...
	private String num="110-58789-232";
	private int total=3000;
	
	//고객의 계좌를 접근할 수 있는 메서드를 제공...
	public void setTotal(int total){
		this.total=total;
	}
	
	public int getTotal(){
		return total;
	}

	
	
	//멤버변수의 값을 변경할 용도로 정의되는 메서드를
	//가르켜 settet라한다. set메서드 정의시 규칙
	//set+멤버변수명, 주의 set뒤의 단어는 첫 철자를 대문자로 한다!!

}
 