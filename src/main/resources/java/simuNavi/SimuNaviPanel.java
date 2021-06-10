package simuNavi;

import DS.common.Graph;
import DS.function.FindLocation;
import DS.function.Navigator;
import readinFiles.readGraph;
import Page.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *游戏内容面板
 *@author DELL 
 */
@SuppressWarnings("deprecation")
public class SimuNaviPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// 构造方法,用于调用线程
	private int startx;
	private int starty;
	private int initLocal = 0;
	Navigator navi;
	static Man myMan;
	private int locat;
	boolean arriveFlag = false;
	boolean ifStop = true;
	boolean findLocal = false;
	private int timesFlag = 0;
	int time = 0;
	int changeBack = 0;
	Page7 page7;
	public SimuNaviPanel(ArrayList<Integer> go_by, int location, int strtege) {
		page7 = new Page7();
		locat = location;
		if(locat == 3) {
			if(readGraph.g.getNode(readGraph.g.getNameToNodeIndex(Page4.getStart())).getCampus() == 1) {	//起点在西土城
				Page4.setEnd("0003");
				initLocal = 1;
				locat = 1;
			}
			else {
				initLocal = 2;
				Page4.setEnd("1西门");
				locat = 2;
			}
			timesFlag = 3;
		}

		Navigator nav = new Navigator(readGraph.g);
		navi = nav;
		if(go_by != null) {
			nav.setWaytoPoint(go_by);
			nav.setBeginNumByPage();
			nav.setStrategy(strtege);
			nav.confirmedStart();
		}
		else {
			nav.setBeginNumByPage();
			nav.setStrategy(1);
			nav.go();
		}


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
				Page5 page5 = new Page5();
				page5.consequence_query(FindLocation.findlocation(myMan.getX(), myMan.getY()));
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
			}
		});
		this.add(stop);
		this.add(begin);
		this.add(inquire);
		this.add(change);

		startx = readGraph.g.getNode(readGraph.g.getNameToNodeIndex(Page4.getStart())).getPosX();
		starty = readGraph.g.getNode(readGraph.g.getNameToNodeIndex(Page4.getStart())).getPosY();
		// 创建人物对象及其位置
		myMan = new Man(startx,starty, navi, timesFlag);
		arriveFlag = myMan.getArriveFlag();
		SimuNaviThread my = new SimuNaviThread();
		my.start();
	}

	// 定义和加载地图背景图片
	static Image bjImgXi;
	static Image bjImgSha;
	static Image button;
	static Image backGround;
	
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
		backGround = tk.createImage(SimuNaviPanel.class.getClassLoader().getResource("Image/sign.png"));
	}
	
	@Override
	public void paint(Graphics g) {
		if(locat == 1) {
			g.drawImage(bjImgXi, 40, 20, 762, 876, this);
			g.drawImage(button, 50, 0, 740, 40, this);
		}
		else if(locat == 2){
			g.drawImage(bjImgSha, 20, 30, 1053, 666, this);
			g.drawImage(button, 100, 0, 740, 30, this);
		}
		else {
			g.drawImage(backGround, 0, 0, 1000, 1093, this);
			g.drawImage(bjImgSha, 10, 10, 105, 66, this);
			g.drawImage(bjImgXi, 764, 780, 76, 87, this);

//			}

		}
		myMan.paint(g);
		arriveFlag = myMan.getArriveFlag();
	}

	class SimuNaviThread extends Thread{
		int flag1 = 0;
		int flag2 = 0;
		public void run() {
			while(true){
				// 如果导航结束标志为真,停止线程
				if(myMan.getArriveFlag()) {
					return;
				}
				//todo
				if(!ifStop && !findLocal) {
					if(myMan.getTimesFlag() == 2 && flag1 == 0) {
						if(initLocal == 1) {
							myMan.setX(764);
							myMan.setY(780);
						}
						else if(initLocal == 2){
							myMan.setX(115);
							myMan.setY(76);
						}
						flag1 = 1;
						locat = 3;
					}
					else if(myMan.getTimesFlag() == 1) {
						if(initLocal == 1) {
							locat = 2;
						}
						else if(initLocal == 2) {
							locat = 1;
						}
						if(flag2 == 0) {
							if(initLocal == 1) {
								myMan.setX(readGraph.g.getNode(readGraph.g.getNameToNodeIndex("1西门")).getPosX());
								myMan.setY(readGraph.g.getNode(readGraph.g.getNameToNodeIndex("1西门")).getPosY());
								Page4.setStart("1西门");
								Page4.setEnd(Page4.getInitEnd());
							}
							else {
								myMan.setX(readGraph.g.getNode(readGraph.g.getNameToNodeIndex("0003")).getPosX());
								myMan.setY(readGraph.g.getNode(readGraph.g.getNameToNodeIndex("0003")).getPosY());
								Page4.setStart("0003");
								Page4.setEnd(Page4.getInitEnd());
							}
							navi.clearRoute();
							navi.setBeginNumByPage();
							navi.setStrategy(1);
							navi.go();
							myMan.setNav(navi);
							myMan.setNumOfNodes(navi.getNum());
							myMan.setI(0);
							flag2 = 1;
						}
					}
					SimuNaviPanel.this.repaint();
				}
				else if(findLocal){
					if(!ifStop) {
						Page5 findlocal = new Page5();
						findlocal.consequence_query(FindLocation.findlocation(myMan.getX(), myMan.getY()));
					}
					ifStop = true;
				}
				try {
					if(myMan.getTimesFlag() != 2) {
						if(Man.type == 1) {
							sleep(5*Page0.getTimeRate());
							if(!ifStop && !findLocal)
							time += 5*Page0.getTimeRate();
						}

						else if(Man.type == 2) {
							sleep(10*Page0.getTimeRate());
							if(!ifStop && !findLocal)
							time += 10*Page0.getTimeRate();
						}

						else {
							sleep(20*Page0.getTimeRate());
							if(!ifStop && !findLocal)
							time += 20*Page0.getTimeRate();
						}

					}
					else {
						sleep(5*Page0.getTimeRate());
						time += 5*Page0.getTimeRate();
					}
					if(time > 100*Page0.getTimeRate()) {
						time = 0;
						page7.refreshTime();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
		
	
}
