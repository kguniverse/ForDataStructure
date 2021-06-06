package simuNavi;

import DS.common.Graph;
import DS.function.FindLocation;
import DS.function.Navigator;
import Page.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *游戏内容面板
 *@author DELL 
 */
@SuppressWarnings("deprecation")
public class SimuNaviPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// 构造方法,用于调用线程
	private Graph g;
	private int startx;
	private int starty;
	static Man myMan;
	private int location;
	boolean arriveFlag = false;
	boolean ifStop = true;
	boolean findLocal = false;

	public SimuNaviPanel(Graph g1, Navigator navi, int location) {
		if(location == 1) {
			Campus campus = new Campus(1);
		}
		else {
			Campus campus = new Campus();
		}
		this.location = location;
		JButton stop = new JButton("停止");
		JButton begin = new JButton("开始");
		JButton inquire = new JButton("查询");
		JButton change = new JButton("更改路径");

		stop.setContentAreaFilled(false);
		begin.setContentAreaFilled(false);
		inquire.setContentAreaFilled(false);
		change.setContentAreaFilled(false);

		this.setLayout(null);
		stop.setBounds(0, 0, 190, 40);
		begin.setBounds(190, 0, 190, 40);
		inquire.setBounds(380, 0, 190, 40);
		change.setBounds(570, 0, 190, 40);
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ifStop = true;
			}
		});
		begin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				findLocal = false;
				ifStop = false;
			}
		});
		inquire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				findLocal = true;
			}
		});
		change.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				findLocal = true;
				Page4 change = new Page4();
				String tem = FindLocation.findlocation(myMan.getX(), myMan.getY()).get(0).getName();
				myMan.setI(0);
				change.change_way(tem);
				//new SimuNaviInit().dispose();
			}
		});
		this.add(stop);
		this.add(begin);
		this.add(inquire);
		this.add(change);

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
	static Image bjImgXi;
	static Image bjImgSha;
	static Image button;
	
	// 通过系统的工具包类,来完成图片的加载和创建
	static Toolkit tk = Toolkit.getDefaultToolkit();

	// 加载并播放背景音乐
	//static AudioClip ac;
	
	// 静态块
	static {
		// 加载背景图片
		bjImgXi = tk.createImage(SimuNaviPanel.class.getClassLoader().getResource("Image/map.png"));
		bjImgSha = tk.createImage(SimuNaviPanel.class.getClassLoader().getResource("Image/map2.png"));
		button = tk.createImage(SimuNaviPanel.class.getClassLoader().getResource("Image/simuButton.png"));
	}
	
	@Override
	public void paint(Graphics g) {
		if(location == 1) {
			g.drawImage(bjImgXi, 40, 20, 762, 876, this);
			g.drawImage(button, 50, 0, 740, 40, this);
		}
		else {
			g.drawImage(bjImgXi, 40, 20, 762, 876, this);
			g.drawImage(bjImgSha, 40, 20, 762, 876, this);
		}
		// 画出背景图

		// 画人像
		myMan.paint(g);
		arriveFlag = myMan.getArriveFlag();
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
					if(!ifStop && !findLocal)
						SimuNaviPanel.this.repaint();
					else if(findLocal){
						if(!ifStop) {
							Page5 findlocal = new Page5();
							findlocal.consequence_query(FindLocation.findlocation(myMan.getX(), myMan.getY()));
						}

						ifStop = true;
					}

					try {
						// 休眠10毫秒 然后继续画出所有元素
						if(Man.type == 1)
							sleep(5);
						else if(Man.type == 2)
							sleep(10);
						else
							sleep(20);
					} catch (InterruptedException e) {
						// 捕获异常并打印栈堆信息
						e.printStackTrace();
					}
					
				}
			}
		}
		
	
}
