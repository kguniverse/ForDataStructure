package simuNavi;

import DS.common.Edge;
import DS.common.Graph;
import DS.common.Node;
import DS.function.Navigator;
import Page.Page4;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;

/**
 *游戏内容面板
 *@author DELL 
 */
@SuppressWarnings("deprecation")
public class SimuNaviPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// 构造方法,用于调用线程
	private static Graph g;
	static int startx;
	static int starty;
	static Man myMan;

	public int i = 0;

	boolean arriveFlag = false;
	public SimuNaviPanel(Graph g1, Navigator navi) {
		// 启动线程
		g = g1;
		startx = g.getNode(g.getNameToNodeIndex(Page4.getStart())).getPosX();
		starty = g.getNode(g.getNameToNodeIndex(Page4.getStart())).getPosY();
		// 创建人物对象及其位置
		myMan = new Man(startx,starty, g1, navi);
		arriveFlag = myMan.getArriveFlag();
		SimuNaviThread my = new SimuNaviThread();
		my.start();
	}

	
	// 定义和加载地图背景图片
	static Image bjImg;
	
	// 通过系统的工具包类,来完成图片的加载和创建
	static Toolkit tk = Toolkit.getDefaultToolkit();

	// 加载并播放背景音乐
	//static AudioClip ac;
	
	// 静态块
	static {
		// 加载背景图片
		bjImg = tk.createImage(SimuNaviPanel.class.getClassLoader().getResource("Image/map.png"));
	}

	
	@Override
	public void paint(Graphics g) {
		// 画出背景图 
		g.drawImage(bjImg, 50, 0, 762, 876, this);
		
		// 画人像
		myMan.paint(g);
		arriveFlag = myMan.getArriveFlag();
		if(myMan.geti() > i)
			i++;

		// 设置颜色
		g.setColor(Color.BLACK);
		// 设置字体
		g.setFont(new Font("宋体", Font.BOLD , 30));
}

		// 开发一个线程类,用来不断增加Y坐标的值，是一个内部类
		class SimuNaviThread extends Thread{
			public void run() {
				while(true){
					// 如果导航结束标志为真,停止线程
					if(myMan.getArriveFlag()) {
						return;
					}
					
					// 重新调用paint方法
					SimuNaviPanel.this.repaint();

					try {
						// 休眠30毫秒 然后继续画出所有元素
						sleep(10); // 30毫秒   1秒=1000毫秒
					} catch (InterruptedException e) {
						// 捕获异常并打印栈堆信息
						e.printStackTrace();
					}
					
				}
			}
		}
		
	
}
