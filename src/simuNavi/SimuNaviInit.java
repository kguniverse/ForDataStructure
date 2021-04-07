package simuNavi;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class SimuNaviInit extends JFrame {
	/**
	 * 我们导航的主界面
	 * @author DELL
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	//构造方法,当创建类的对象的时候，也就是new的时候自动调用
	public SimuNaviInit() {
		
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
		this.setContentPane(new SimuNaviPanel());
		
		// 设置窗口的可见性,默认为不可见的（一定要在主界面类的构造函数的末尾再设置！！！！！！！！）
		this.setVisible(true);
	}

		
}
