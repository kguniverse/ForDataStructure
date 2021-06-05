package simuNavi;

import DS.common.Edge;
import DS.common.Graph;
import DS.common.Node;
import DS.function.Navigator;
import readinFiles.readGraph;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class SimuNaviInit extends JFrame {
	//1为西土城小区，2为沙河校区，3为校区间
	int location = 1;

	//TODO:判断起始终点在哪个校区
	/**
	 * 我们导航的主界面
	 * @author DELL
	 */
	private static final long serialVersionUID = 1L;
	//构造方法,当创建类的对象的时候，也就是new的时候自动调用
	public SimuNaviInit() {
		if(location == 1) {
			Campus campus = new Campus(1);
			// 设置窗口的大小: 宽 高
			this.setSize(campus.getWidthFrame(),campus.getHeightFrame());
		}
		else{
			Campus campus = new Campus();
			// 设置窗口的大小: 宽 高
			this.setSize(campus.getWidthFrame(),campus.getHeightFrame());
		}

		Graph g = new Graph(readGraph.edges, readGraph.nodes);
		Navigator nav = new Navigator(g);

		//TODO:导航模块初始化
		nav.setBeginNumByPage();
		nav.setStrategy(1);
		nav.go();

		//窗口设置
		this.setLocation(0,0);
		this.setTitle("智慧校园导览系统");
		this.setResizable(true);
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		this.setContentPane(new SimuNaviPanel(g, nav, location));
		this.setVisible(true);
	}

}
