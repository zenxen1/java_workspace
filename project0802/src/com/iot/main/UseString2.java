package com.iot.main;

class UseString2{
	public static void main(String[] args){
		String s1 = new String("apple");
		String s2 = "apple";
		String s3 = "apple";
		String s4 = new String("apple");
	
		
		//string�� ��ü�̹Ƿ�, s2,s3�� ���۷��� �����̴�
		/* ���� �Ʒ��� �ڵ�� ���� �񱳰� �ƴ� �ּҺ��̴�
		�Ʒ��� �ڵ尡 true�� ������ ������ ������� �̶�� ������ �����Ǳ� �����̴�.*/
		System.out.println(s2==s3);
		System.out.println(s1==s2);
		System.out.println(s1==s4);

		//��Ʈ�� ��ü�� �Һ��� Ư¡���� ���Ͽ� , �ڹ��� string���� �����̶�� ������ �������� �ʴ´�
		StringBuffer b = new StringBuffer();
		b.append("");
		b.append("fight");

		String str="korea java";
		System.out.println(str.charAt(3));
		System.out.println(str.indexOf('a'));
		System.out.println(str.lastIndexOf('a'));
		System.out.println(str.length());
		System.out.println(str.replace("korea","�ڸ���"));
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
