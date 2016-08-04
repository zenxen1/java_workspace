//java.exe실행시 연산을 수행할 두 데이터를 넘겨
//서 

//일반적으로 자바언어는 기본자료형()형
//간의 형변환과 객체간의 형변환은 지원하고 있다.
//하지만, 기본자료형과 객체자료형간의 형변환도 가능할까?
//가능하나..단, 기본자료형으로 변환될 수 있는 대상만 가능.

//"true" --> true (String --> boolean)
//"2" --> 2   (String --> int)
//Dog  -->2 (Dog은 기본자료형으로 변형될 수 가능성없음 불가)

//"3"  --> '3' (String --> char)

//자바언어에서는 모든 기본자료형 마다 1:1 로 대응하는
//Wrapper 클래스를 통해 객체자료형과 기본자료형간의 
//형변환을 지원하고 있다..

//정수
//byte		: Byte
//short		: Short
//int			: Integer
//long		: Long
//--------------------------------
//실수
//float		: Float
//double	: Double
//----------------------------------
//논리값
//boolean	: Boolean

package main;
class Cal{
	public static void main(String[] args){
		String n1 = args[0];
		String n2 = args[1];
		int result = Integer.parseInt(n1) + Integer.parseInt(n2);
		System.out.println(n1+" + "+n2+" = "+result);
	}
}
