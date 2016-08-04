/*
PM입장에서 사원들을 구속하기 위한 클래스의 정의
추상클래스란?
- 미완성 클래스를 의미한다
- 미완성이란? 몸체없는 추상메서드를 단 1개라도 보유하고 있다면 그 클래스는 완전하지 못하므로
  인스턴스화 될 수 없다. 따라서 추상클래스를 상속받은 자식에게 구현의 의무를 부여하고, 자식이 구현을 완료 했을때
  비로소 부모클래스도 인스턴스화 될 수 있다!!
*/
package music;

abstract public class MusicDevice{
	abstract public void setVolume();
	abstract public void playMP3(); //미완성으로 남겨 놓아야 자식클래스에게 구현 강제를 가할 수 있다!!
}
