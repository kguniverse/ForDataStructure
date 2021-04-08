//定点导航
package Page;

import simuNavi.SimuNaviInit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page4 {
    private String start;
    private String end;

    public String getStart() { return start; }
    public String getEnd() { return end; }

    public void navigate() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("校园导览系统");
        // 设定面板大小
        frame.setSize(350, 200);
        frame.setLocation(200, 150);
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */

        // 设置界面可见
        frame.setVisible(true);

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel startLabel = new JLabel("起点名");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        startLabel.setBounds(10,20,80,25);
        panel.add(startLabel);
        JTextField satrtText = new JTextField(20);
        satrtText.setBounds(100,20,165,25);
        panel.add(satrtText);

        // 输入的文本域用于目的地
        JLabel endLabel = new JLabel("终点名");
        endLabel.setBounds(10,50,80,25);
        panel.add(endLabel);
        JTextField endText = new JTextField(20);
        endText.setBounds(100,50,165,25);
        panel.add(endText);

        JButton confirm = new JButton("确定");
        confirm.setBounds(100,100, 120, 25);
        panel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start = satrtText.getText();
                end = endText.getText();
                /*
                TODO: 需要一个查询函数，查找输入的地点是否存在，以及地点的坐标
                 */
                new SimuNaviInit();
            }
        });
        //返回上级
        JButton button = new JButton();
        button.setBounds(100,150, 120, 25);
        panel.add(button);
        button.setText("返回上级");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Page2 Page = new Page2();
                Page.page();
            }
        });
    }
}
