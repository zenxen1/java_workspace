package product;
public class BallPen extends Pen{
	public void write(){
		System.out.println("잉크를 사용하여 글씨를 적습니다.");
	}
	public void write(String color){
		System.out.println("색잉크를 사용하여 글씨를 적습니다.");
	}
}
