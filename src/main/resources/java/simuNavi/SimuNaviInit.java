package simuNavi;

import DS.common.Edge;
import DS.common.Graph;
import DS.common.Node;
import DS.function.Navigator;
import Page.Page4;
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
	public void simuInit(ArrayList<Integer> go_by) {
		if(readGraph.g.getNode(readGraph.g.getNameToNodeIndex(Page4.getStart())).getCampus() == 1 && readGraph.g.getNode(readGraph.g.getNameToNodeIndex(Page4.getEnd())).getCampus() == 1) {
			location = 1;
		}
		else if(readGraph.g.getNode(readGraph.g.getNameToNodeIndex(Page4.getStart())).getCampus() == 2 && readGraph.g.getNode(readGraph.g.getNameToNodeIndex(Page4.getEnd())).getCampus() == 2) {
			location = 2;
		}
		else {
			location = 3;
		}

		if(location == 1) {
			Campus campus = new Campus(1);
			this.setSize(campus.getWidthFrame(),campus.getHeightFrame());
		}
		else if(location == 2){
			Campus campus = new Campus();
			this.setSize(campus.getWidthFrame(),campus.getHeightFrame());
		}
		else {
			Campus campus = new Campus(1);
			this.setSize(campus.getWidthFrame(),campus.getHeightFrame());
		}

		Navigator nav = new Navigator(readGraph.g);
		if(go_by != null)
			nav.setWaytoPoint(go_by);
		//TODO:导航模块初始化
		nav.setBeginNumByPage();
		nav.setStrategy(1);
		nav.go();

		//窗口设置
		this.setLocation(0,0);
		this.setTitle("智慧校园导览系统");
		this.setResizable(true);
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		this.setContentPane(new SimuNaviPanel(readGraph.g, nav, location));
		this.setVisible(true);
	}

	public void colse() {
		this.dispose();
	}
}
