//功能菜单页

package Page;

import simuNavi.SimuNaviInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page2 {
    public static void page() {
        JFrame frame=new JFrame("智慧校园导览系统");    //创建Frame窗口
        JPanel cards=new JPanel(new CardLayout());    //卡片式布局的面板
        JPanel welcome = new JPanel();
        frame.setLocation(200, 150);

        //查看地图
        JButton button1 = new JButton();
        welcome.add(button1);
        button1.setText("查看地图");
        button1.setPreferredSize(new Dimension(200, 30));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                Page3 graph = new Page3();
                graph.graph();
            }
        });


        JButton button2 = new JButton();
        welcome.add(button2);
        button2.setText("定点导航");
        button2.setPreferredSize(new Dimension(200, 30));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                Page4 navi = new Page4();
                navi.navigate();
                /*
                new SimuNaviInit();

                 */
            }
        });

        //含有必经点的导航
        JButton button3 = new JButton();
        welcome.add(button3);
        button3.setText("设定途径点导航");
        button3.setPreferredSize(new Dimension(200, 30));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //地点查询
        JButton button4 = new JButton();
        welcome.add(button4);
        button4.setText("地点查询");
        button4.setPreferredSize(new Dimension(200, 30));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //返回上级
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(200,30));
        welcome.add(button);
        button.setText("退出登录");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Page0 Page = new Page0();
                Page.page();

            }
        });

        cards.add(welcome, "welcome");
        CardLayout c = (CardLayout)(cards.getLayout());
        c.show(cards, "welcome");
        frame.add(cards);
        frame.setBounds(300, 300, 400, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
