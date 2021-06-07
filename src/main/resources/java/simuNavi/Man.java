package simuNavi;
import DS.common.Edge;
import DS.common.Graph;
import DS.common.Node;
import readinFiles.readGraph;
import DS.function.Navigator;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;

@SuppressWarnings("deprecation")
public class Man {
	// 人物初始位置
	private int x;
	private int y;
	static public Navigator nav;
	static public int type = 1;
	private boolean arriveFlag = false;
	private int timesFlag = 0;
	public boolean getArriveFlag() {
		return this.arriveFlag;
	}
	// 人像宽度和高度,是一个常量
	public static final int MAN_WIDTH = 50;
	public static final int MAN_HEIGHT = 50;
	private int numOfNodes;
	private int i = 0;
	public void setI(int newI) { i = newI; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public void setNav(Navigator n) { nav = n; }
	public int geti() { return i; }
	public void setNumOfNodes(int num) { numOfNodes = num; }
	public int getTimesFlag() { return timesFlag; }
	public int getX() { return x; }
	public int getY() { return y; }
	// 构造方法
	public Man(int x,int y, Navigator navi, int timesFlag) {
		this.timesFlag = timesFlag;
		nav = navi;
		numOfNodes = nav.getNum();
		this.x = x;
		this.y = y;
	}

	// 人物图片
	static Image manImgSign;
	static Image manImageCar;
	static Image manImageBike;
	static Image manImageMan;

	// 工具包类
	static Toolkit tk =Toolkit.getDefaultToolkit();
	static {
		manImgSign = tk.createImage(Man.class.getClassLoader().getResource("Image/sign.png"));
		manImageBike = tk.createImage(Man.class.getClassLoader().getResource("Image/bike.jpeg"));
		manImageCar = tk.createImage(Man.class.getClassLoader().getResource("Image/car.jpeg"));
		manImageMan = tk.createImage(Man.class.getClassLoader().getResource("Image/man.jpeg"));
	}

	public void paint(Graphics g) {
		if(timesFlag == 2) {
			g.drawImage(manImageCar, x, y, MAN_WIDTH, MAN_HEIGHT, null);
			if(readGraph.g.getNode(nav.getRoute(0)).getCampus() == 1) {	//如果从西土城出发
				if(76 < y) {
					y--;
				}
				else if(115 < x) {
					x--;
				}
				else if(y == 76 && x == 115){
					this.timesFlag--;
				}
			}
			else {	//从沙河出发
				if(780 > y) {
					y++;
				}
				else if(764 > x) {
					x--;
				}
				else if(y == 780 && x == 764){
					this.timesFlag--;
				}
			}
		}
		else {
			int preFuncX = 0;
			int preFuncY = 0;
			//画出路径
//			for(int j = 1; j < i; j++) {
//				int prex = readGraph.g.getNode(nav.getRoute(j)).getPosX();
//				int prey = readGraph.g.getNode(nav.getRoute(j)).getPosY();
//				int xx = readGraph.g.getNode(nav.getRoute(j-1)).getPosX();
//				int yy = readGraph.g.getNode(nav.getRoute(j-1)).getPosY();
//
//				while(xx != prex || yy != prey) {
//					g.drawImage(manImgSign, xx + preFuncX, yy+25+ preFuncY, 15, 15, null);
//					if(prex-xx < 50 && xx-prex < 50){
//						//preFuncX = prex - xx;
//						xx = prex;
//					}
//					if(prey-yy < 50 && yy-prey < 50) {
//						//preFuncY = prey - y;
//						yy = prey;
//					}
//
//					if(prey > yy)
//						yy += 50;
//					else if(prey < yy)
//						yy -= 50;
//					else if(prex > xx)
//						xx += 50;
//					else if(prex < xx)
//						xx -= 50;
//				}
//			}
			if(i < nav.getRouteEdge().size()) {
				type = nav.getRouteEdge().get(i).getType();
				if(type == 1)
					g.drawImage(manImageCar, x, y, MAN_WIDTH, MAN_HEIGHT, null);
				else if(type == 2)
					g.drawImage(manImageBike, x, y, MAN_WIDTH, MAN_HEIGHT, null);
				else
					g.drawImage(manImageMan, x, y, MAN_WIDTH, MAN_HEIGHT, null);

				if(readGraph.g.getNode(nav.getRoute(i)).getPosY() > y) {
					y++;
					if(readGraph.g.getNode(nav.getRoute(i)).getPosY() == y)
						i++;
					//g.drawImage(manImgDown, x, y, MAN_WIDTH, MAN_HEIGHT, null);
				}
				else if(readGraph.g.getNode(nav.getRoute(i)).getPosY() < y) {
					y--;
					int t = readGraph.g.getNode(nav.getRoute(i)).getPosY();
					if(readGraph.g.getNode(nav.getRoute(i)).getPosY() == y)
						i++;
					//g.drawImage(manImgUp, x, y, MAN_WIDTH, MAN_HEIGHT, null);
				}
				else if(readGraph.g.getNode(nav.getRoute(i)).getPosX() < x) {
					x--;
					if(readGraph.g.getNode(nav.getRoute(i)).getPosX() == x)
						i++;
					//g.drawImage(manImgLeft, x, y, MAN_WIDTH, MAN_HEIGHT, null);
				}
				else if(readGraph.g.getNode(nav.getRoute(i)).getPosX() > x) {
					x++;
					if(readGraph.g.getNode(nav.getRoute(i)).getPosX() == x)
						i++;
					//g.drawImage(manImgRight, x, y, MAN_WIDTH, MAN_HEIGHT, null);
				}
			}

			if(i == numOfNodes) {
				if(timesFlag == 0) {
					arriveFlag = true;
					g.setFont(new Font("宋体", Font.BOLD , 60));
					g.drawString("恭喜你到达目的地！", 200, 300);
				}
				else {
					timesFlag--;
				}
			}
		}
		}

	//TODO：两个校区之间，美化
	//TODO：引索算法
	//TODO：数据交互输入

}
