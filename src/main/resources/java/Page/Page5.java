//地点查询
package Page;

import simuNavi.SimuNaviInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Page5 {
    public void query_buildings() {
        JFrame frame = new JFrame("地点查询");
        frame.setSize(350, 230);
        frame.setLocation(170, 455);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        panel.setLayout(null);
        JLabel startLabel = new JLabel("查询点");
        startLabel.setBounds(10,20,80,50);
        panel.add(startLabel);
        JTextField startText = new JTextField(20);
        startText.setBounds(100,20,165,50);
        panel.add(startText);

        JButton confirm = new JButton("确定");
        confirm.setBounds(120,100, 120, 25);
        panel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                TODO: 需要一个查询函数，查找输入的地点是否存在，以及地点的坐标
                 */
                //if()
                new SimuNaviInit();
            }
        });

        //返回上级
        JButton button = new JButton();
        button.setBounds(120,150, 120, 25);
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