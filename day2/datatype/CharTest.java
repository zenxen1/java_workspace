/*문자 자료형에 대한 학습*/
class CharTest{
	public static void main(String[] args){
		//문자 자료형이란 사실상 존재하지 않는다
		//왜?? 어차피 문자는 곧 숫자 바뀐다
		//단, 이숫자의 목적은 연산 수행이 아닌 키코드값과 매핑 목적으로 사용해야 한다..

		/*숫자 - 정수:소수점 표현 불가...
					실수 :소수점까지 표현 가능한수
					float<double
		*/

		char x='a';
		char y=3; //아스키 키코드3으로 인식함..가능은 하지만 안된다..
		char k=9;
		char z=-1;//키코드 매핑이 목적이므로, 음수는 지원하지 않는다.

		System.out.println(y+k);
	}

}