class Bird{
   String name="��";
   boolean fly;
   public Bird(Boolean f){
       fly=f;
}
}
class Duck extends Bird{
    String sound="quack";
	public Duck(){  //������ ����
		super(true);
		int x=5;  //super���� ���������Ƿ� ����
		
	}
}
class  UseTest{
public static void main(String[] args){
        Bird b=new Bird(); //(��) 
        b.sound="JJack JJack"; //(��)
        Duck d=new Duck();// (��)
}
}
