/*같은 패키지에 클래스를 두고 사용해보자*/
package use;

/*나와는 다른 패키지에 있는 클래스는 그 경로를 반드시 알아야 사용할 수 있다*/
import animal.Duck;
class  UseDuck{
	public static void main(String[] args) 
	{
		Duck d = new Duck();
	}
}
