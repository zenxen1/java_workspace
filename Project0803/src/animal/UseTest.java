class Bird{
   String name="새";
   boolean fly;
   public Bird(Boolean f){
       fly=f;
}
}
class Duck extends Bird{
    String sound="quack";
	public Duck(){  //없으면 에러
		super(true);
		int x=5;  //super보다 위에있으므로 에러
		
	}
}
class  UseTest{
public static void main(String[] args){
        Bird b=new Bird(); //(가) 
        b.sound="JJack JJack"; //(나)
        Duck d=new Duck();// (다)
}
}
