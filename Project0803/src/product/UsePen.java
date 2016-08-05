package product;
class UsePen{
	public static void main(String[] args){
		BallPen bp = new BallPen();
	
		//BallPen bp2 = new Pen();
		Pen p = new BallPen();

		//상위 자료형을 하위자료형으로 강제형변환하는것을 가리켜 downcasting
		bp = (BallPen)p;
	}
}
