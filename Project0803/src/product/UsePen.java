package product;
class UsePen{
	public static void main(String[] args){
		BallPen bp = new BallPen();
	
		//BallPen bp2 = new Pen();
		Pen p = new BallPen();

		//���� �ڷ����� �����ڷ������� ��������ȯ�ϴ°��� ������ downcasting
		bp = (BallPen)p;
	}
}
