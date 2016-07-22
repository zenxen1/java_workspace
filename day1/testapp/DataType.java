/*
변수에 데이터를 담아서 선언할때는 반드시 변수가 담게될 데이터의 용량을 표시해야 하는데,
이용량 표시를 자료형이라 한다.
불편하기는 하지만, 개발자가 메모리 용량을 결정 지을 수 있다!!

1.문자 char (2byte)
2.숫자 byte(1byte)<short(2byte)<int(4byte)<long(8byte)
3.논리값 boolean (1byte)
*/
class DataType{
	public static void main(String[] args){
		//문자자료형
		char c='대'; //문자는 홑따옴표
		//2byte 짜리 데이터가 총 4개 확보 = 8byte
		char[] arr=new char[4];
		arr[0] = '대';
		arr[1] = '한';
		arr[2] = '민';
		arr[3] = '국';
		
		char[] arr2={'아','메','리','카'};

		for(int i=0;i<arr.length;i++){
			System.out.println("c의 값은"+arr[i]);
			System.out.println("c의 값은"+arr2[i]);
		}

		boolean m=true;


		
	}


}