package Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page0 {
    public void page() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("校园导览系统");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setLocation(200, 150);
        JPanel cards=new JPanel(new CardLayout());    //卡片式布局的面板
        JPanel welcome = new JPanel();

        welcome.setBackground(Color.pink);
        JButton button1 = new JButton();
        button1.setBackground(Color.CYAN);
        welcome.add(button1);
        button1.setText("登录");
        button1.setPreferredSize(new Dimension(200, 30));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Page1 longin = new Page1();
                longin.page();
            }
        });

        JButton button2 = new JButton();
        welcome.add(button2);
        button2.setText("注册");
        button2.setBackground(Color.CYAN);
        button2.setPreferredSize(new Dimension(200, 30));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        /*
        JButton button3 = new JButton();
        button3.setBackground(Color.CYAN);
        welcome.add(button3);
        button3.setText("功能菜单");
        button3.setPreferredSize(new Dimension(200, 30));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Page2 func = new Page2();
                func.page();
            }
        });

         */
        ImageIcon image = new ImageIcon("src/background.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
        image.setImage(image.getImage().getScaledInstance(600,840,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JLabel im = new JLabel(image);
        im.setBounds(0, 0, 600, 840);
        frame.add(im);

        cards.add(welcome, "welcome");
        CardLayout c = (CardLayout)(cards.getLayout());
        c.show(cards, "welcome");
        frame.add(cards);
        frame.setBounds(300, 300, 400, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
