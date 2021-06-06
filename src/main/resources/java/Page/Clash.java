package Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clash {
    static public void time_clash() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("智慧校园导览系统");
        frame.setSize(300, 100);
        frame.setLocation(390, 540);
        JPanel jpnel=new JPanel();
        ImageIcon image = new ImageIcon("src/main/resources/java/Image/down.jpg");
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        JLabel im = new JLabel(image);
        JLabel wrong = new JLabel("时间冲突啦！");
        wrong .setBounds(0, 10,50,40);
        im.setBounds(25, 45, 50, 50);
        jpnel.add(im);
        jpnel.add(wrong);
        //frame.add(im);
        //frame.add(wrong);
        jpnel.setBackground(Color.pink);
        frame.add(jpnel);
        frame.setVisible(true);
    }
    static public void IDPass_clash() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("智慧校园导览系统");
        frame.setSize(300, 100);
        frame.setLocation(390, 540);
        JPanel jpnel=new JPanel();
        ImageIcon image = new ImageIcon("src/main/resources/java/Image/down.jpg");
        image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        JLabel im = new JLabel(image);
        JLabel wrong = new JLabel("账号密码错误啦！");
        wrong .setBounds(0, 10,50,40);
        im.setBounds(25, 45, 50, 50);
        jpnel.add(im);
        jpnel.add(wrong);
        //frame.add(im);
        //frame.add(wrong);
        jpnel.setBackground(Color.pink);
        frame.add(jpnel);
        frame.setVisible(true);
    }
}
