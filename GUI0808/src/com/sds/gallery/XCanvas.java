/*������Ʈ�� canvas�� ��ӹ޾� �����ڰ� �ֵ��Ͽ� �׸��� �׷������� �Ѵ�!!
 * paint �޼��带 ������ �غ���!!
 * */
package com.sds.gallery;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class XCanvas extends Canvas{
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image[] imgs;//�߻�Ŭ������!!
	String[] path={
			"C:/java_workspace/GUI0808/res/��1.png",
			"C:/java_workspace/GUI0808/res/��2.png",
			"C:/java_workspace/GUI0808/res/��3.png",
			"C:/java_workspace/GUI0808/res/��4.png",
			"C:/java_workspace/GUI0808/res/��5.png",
			"C:/java_workspace/GUI0808/res/��6.png",
			"C:/java_workspace/GUI0808/res/��7.png",
			"C:/java_workspace/GUI0808/res/��8.png",
			"C:/java_workspace/GUI0808/res/��9.png",
			"C:/java_workspace/GUI0808/res/��10.png",
	};
	
	int count = 0;
	
	public XCanvas() {
		imgs = new Image[path.length];
		for(int i=0; i<imgs.length;i++){
			imgs[i] = kit.getImage(path[i]);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(imgs[count], 0, 0, 700, 600, this);
	}
}
