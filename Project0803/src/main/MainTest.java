/*main()메서드의 인수인 args를 사용해본다*/
/*main- 개발자가 */
package main;
class MainTest{
	public static void main(String[] args){
		System.out.println("프로그램 실행시 넘겨받은 인수의 개수는 "+args.length);
		for(int i=0;i<args.length;i++){
			System.out.println("args["+i+"] = "+args[i]);
		}
	}
}
