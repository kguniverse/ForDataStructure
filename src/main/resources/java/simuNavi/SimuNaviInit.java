package simuNavi;

import DS.common.Edge;
import DS.common.Graph;
import DS.common.Node;
import DS.function.Navigator;
import Page.Page0;
import Page.Page4;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SimuNaviInit extends JFrame {
	/**
	 * 我们导航的主界面
	 * @author DELL
	 */
	private static final long serialVersionUID = 1L;
	//构造方法,当创建类的对象的时候，也就是new的时候自动调用
	public SimuNaviInit() {

		//Todo:程序入口：先读入地点信息后建图。
		ArrayList<Edge> edges = new ArrayList<>();
		ArrayList<Node> nodes = new ArrayList<>();
		try {
			Scanner scEdge = new Scanner(Paths.get("src/main/resources/java/readinFiles/edges.txt"));
			while(scEdge.hasNextLine()){
				String infoEdge = scEdge.nextLine();
				String[] detailedInfoEdge = infoEdge.split(" ");
				//TODO:错误处理
				edges.add(new Edge(detailedInfoEdge));
				edges.add((new Edge(detailedInfoEdge)).getReverseEdge());
//                Mylog.lDprintf("successfully add Edge:" + infoEdge);
			}
			scEdge.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Scanner scNode = new Scanner(Paths.get("src/main/resources/java/readinFiles/nodes.txt"));
			while(scNode.hasNextLine()){
				String infoNode = scNode.nextLine();
				String[] detailedInfoNode = infoNode.split(" ");
				nodes.add(new Node(detailedInfoNode));
//                Mylog.lDprintf("successfully add node:" + infoNode);

			}
			scNode.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Graph g = new Graph(edges, nodes);
		Navigator nav = new Navigator(g);
		nav.setStrategy(1);
		nav.go();

		// 设置显示的位置,设置窗口的坐标: x y
		this.setLocation(0,0);

		// 设置窗口的大小: 宽 高
		this.setSize(850,1315);

		// 设置窗口关闭程序
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 设置窗口的标题
		this.setTitle("智慧校园导览系统");

		// 设置模拟导航窗口不允许调整大小
		this.setResizable(true);

		// 设模拟导航窗口内部为十字光标
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

		// 将Panel放在主界面中
		this.setContentPane(new SimuNaviPanel(g, nav));

		// 设置窗口的可见性,默认为不可见的（一定要在主界面类的构造函数的末尾再设置！！！！！！！！）
		this.setVisible(true);
	}


}
