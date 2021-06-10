package Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page2 {
    public void page() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("智慧校园导览系统");
        frame.setSize(600, 800);
        frame.setLocation(20, 15);
        JPanel jpnel=new JPanel();
        jpnel.setLayout(null);

        JButton button1 = new JButton();
        button1.setBounds(120, 30, 170, 40);
        button1.setBackground(new Color(0x66, 0xCC, 0xCC));
        jpnel.add(button1);
        button1.setText("查看沙河校区地图");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page3 graph = new Page3();
                graph.page(1);
            }
        });
        JButton button6 = new JButton();
        button6.setBounds(310, 30, 170, 40);
        button6.setBackground(new Color(0x66, 0xCC, 0xCC));
        jpnel.add(button6);
        button6.setText("查看西土城校区地图");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page3 graph = new Page3();
                graph.page();
            }
        });

        JButton button2 = new JButton();
        jpnel.add(button2);
        button2.setBounds(120, 90, 170, 40);
        button2.setText("定点导航");
        button2.setBackground(new Color(0x66, 0xCC, 0xCC));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page4 navi = new Page4();
                navi.navigate_single();
            }
        });

        JButton button3 = new JButton();
        jpnel.add(button3);
        button3.setBounds(310, 90, 170, 40);
        button3.setText("途经点定点导航");
        button3.setBackground(new Color(0x66, 0xCC, 0xCC));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page4 goBy = new Page4();
                goBy.navigate_goby();
            }
        });

        JButton button7 = new JButton();
        jpnel.add(button7);
        button7.setBounds(120, 210, 360, 40);
        button7.setText("智慧小邮");
        button7.setBackground(new Color(0x66, 0xCC, 0xCC));
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page6 goBy = new Page6();
                goBy.inteligent_you();
            }
        });

        JButton button4 = new JButton();
        jpnel.add(button4);
        button4.setBounds(120, 150, 170, 40);
        button4.setText("地点查询");
        button4.setBackground(new Color(0x66, 0xCC, 0xCC));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page5 findLocation = new Page5();
                findLocation.query_buildings();
            }
        });

        JButton button8 = new JButton();
        jpnel.add(button8);
        button8.setBounds(310, 150, 170, 40);
        button8.setText("日程管理");
        button8.setBackground(new Color(0x66, 0xCC, 0xCC));
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page6 schedule = new Page6();
                schedule.schedule();
            }
        });

        JButton button5 = new JButton();
        jpnel.add(button5);
        button5.setBounds(120, 270, 360, 40);
        button5.setText("退出登录");
        button5.setBackground(new Color(0x66, 0xCC, 0xCC));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Page0 Page = new Page0();
                Page.page();
            }
        });

        ImageIcon image = new ImageIcon("src/main/resources/java/Image/buptBadge.jpeg");
        image.setImage(image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        JLabel im = new JLabel(image);
        im.setBounds(0, 200, 600, 600);
        frame.add(im);

        jpnel.setBackground(new Color(0x99,0xCC, 0xFF));
        frame.add(jpnel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
