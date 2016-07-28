public class Desk {
	int x; 
	static int y;
	
	{
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
	
	static { 
		for(int i=0;i<20;i++){
			y++;
		}
	}
	
	public static void main(String[] args){
//System.out.println(x); 
int a=new Desk().x; 
		System.out.println(a); 
		System.out.println(y);
		
	}
}
