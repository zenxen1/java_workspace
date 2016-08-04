/*
String 클래스의 특징
-불변이다. 따라서 String 

*/
/*
자바의 모든 클래스는 (개발자가 정의한 클래스이건
sun이 제공하는 api 이건 모두 Object

*/
package main;
class StringTest{
	public void test(){
		boolean b = this.equals("대한민국");
	}
	public static void main(String[] args){
		String a="대한민국";
		String b="대한민국";
		System.out.println(a.equals(b));
	}
}
