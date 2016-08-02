package com.iot.main;

class UseString2{
	public static void main(String[] args){
		String s1 = new String("apple");
		String s2 = "apple";
		String s3 = "apple";
		String s4 = new String("apple");
	
		
		//string은 객체이므로, s2,s3는 레퍼런스 변수이다
		/* 따라서 아래의 코드는 내용 비교가 아닌 주소비교이다
		아래의 코드가 true가 나오는 이유는 상수풒ㄹ 이라는 영역에 생성되기 때문이다.*/
		System.out.println(s2==s3);
		System.out.println(s1==s2);
		System.out.println(s1==s4);

		//스트링 객체의 불변의 특징으로 인하여 , 자바의 string에는 누적이라는 개녕은 존재하지 않는다
		StringBuffer b = new StringBuffer();
		b.append("");
		b.append("fight");

		String str="korea java";
		System.out.println(str.charAt(3));
		System.out.println(str.indexOf('a'));
		System.out.println(str.lastIndexOf('a'));
		System.out.println(str.length());
		System.out.println(str.replace("korea","코리아"));
		System.out.println(str.substring(3,8));
		System.out.println(str.toUpperCase());
		String str1 = "photo .jpg";
		System.out.println(str1.substring(0,str1.indexOf('.')));
		System.out.println(str1.substring(str1.indexOf('.')+1,str1.length()));
		String[] result = str1.split("\\.");
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result.length);
	}
}
