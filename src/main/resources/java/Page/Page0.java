package Page;
import DS.function.Navigator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import readinFiles.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Page0 {
    private static int timeRate = 1;
    public void page() {
        //读入地图文件
        readGraph readgra = new readGraph();
        //读入用户文件
        read_user readUser = new read_user();
        // 创建 JFrame 实例
        JFrame frame = new JFrame("智慧校园导览系统");
        frame.setSize(600, 800);
        frame.setLocation(20, 15);
        JPanel jpnel=new JPanel();
        jpnel.setLayout(null);
        JButton button1 = new JButton();
        button1.setBounds(210, 30, 80, 30);
        button1.setBackground(Color.CYAN);
        jpnel.add(button1);
        button1.setText("登录");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Page1 longin = new Page1();
                longin.page();
            }
        });

        JButton button2 = new JButton();
        jpnel.add(button2);
        button2.setBounds(310, 30, 80, 30);
        button2.setText("注册");
        button2.setBackground(Color.CYAN);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JCheckBox rate10 = new JCheckBox("时钟比例10");
        JCheckBox rate20 = new JCheckBox("时钟比例20");
        rate10.setBounds(195, 80, 100, 25);
        rate20.setBounds(305, 80, 100, 25);
        jpnel.add(rate10);
        jpnel.add(rate20);
        JCheckBox rate30 = new JCheckBox("时钟比例30");
        JCheckBox rate40 = new JCheckBox("时钟比例40");
        rate30.setBounds(195, 110, 100, 25);
        rate40.setBounds(305, 110, 100, 25);
        rate10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRate = 1;
            }
        });
        rate20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRate = 2;
            }
        });
        rate30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRate = 3;
            }
        });
        rate40.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRate = 4;
            }
        });
        jpnel.add(rate30);
        jpnel.add(rate40);
        ImageIcon image = new ImageIcon("src/main/resources/java/Image/buptBadge.jpeg");
        image.setImage(image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
        JLabel im = new JLabel(image);
        im.setBounds(0, 200, 600, 600);
        frame.add(im);
        jpnel.setBackground(Color.pink);
        frame.add(jpnel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static int getTimeRate() { return timeRate; }
}
