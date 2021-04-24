package simuNavi;
import DS.common.Graph;
import DS.function.Navigator;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;

@SuppressWarnings("deprecation")
public class Man {
	// 人物初始位置
	private int x;
	private int y;

	private boolean arriveFlag = false;
	public boolean getArriveFlag() {
		return this.arriveFlag;
	}
	// 人像宽度和高度,是一个常量
	public static final int MAN_WIDTH = 50;
	public static final int MAN_HEIGHT = 50;
	
	// 构造方法
	public Man(int x,int y) {
		this.x = x;
		this.y = y;
	}

	
	// 人物图片
	static Image manImgLeft;
	static Image manImgRight;
	static Image manImgUp;
	static Image manImgDown;
	
	// 工具包类
	static Toolkit tk =Toolkit.getDefaultToolkit();
	
	static {
		manImgLeft = tk.createImage(Man.class.getClassLoader().getResource("Image/left.jpg"));
		manImgRight = tk.createImage(Man.class.getClassLoader().getResource("Image/right.jpg"));
		manImgUp = tk.createImage(Man.class.getClassLoader().getResource("Image/up.png"));
		manImgDown = tk.createImage(Man.class.getClassLoader().getResource("Image/down.jpg"));
	}
	// 画出人物

	Navigator navi = new Navigator();
	int numOfNodes = navi.getNum();
	Graph gra = new Graph();

	public void paint(Graphics g) {
		//TODO:从navigator推送
		for(int i = 0; i < numOfNodes; i++) {
			if(gra.getNode(navi.getRoute(i)).getPosY() > y) {
				y++;
				g.drawImage(manImgDown, x, y, MAN_WIDTH, MAN_HEIGHT, null);
			}
			else if(gra.getNode(navi.getRoute(i)).getPosY() < y) {
				y--;
				g.drawImage(manImgDown, x, y, MAN_WIDTH, MAN_HEIGHT, null);
			}
			else if(gra.getNode(navi.getRoute(i)).getPosX() < x) {
				x--;
				g.drawImage(manImgDown, x, y, MAN_WIDTH, MAN_HEIGHT, null);
			}
			else if(gra.getNode(navi.getRoute(i)).getPosX() > x) {
				x++;
				g.drawImage(manImgDown, x, y, MAN_WIDTH, MAN_HEIGHT, null);
			}
		}
			arriveFlag = true;
			g.setFont(new Font("宋体", Font.BOLD , 60));
			g.drawString("恭喜你到达目的地！", 200, 300);
	}

	//TODO：两个校区之间，美化
	//TODO：暂时不做账号管理
	//TODO：引索算法
	//TODO：数据交互输入




}
