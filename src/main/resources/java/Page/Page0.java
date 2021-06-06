package Page;
import readinFiles.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Page0 {
    public void page() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        //读入地图文件
        readGraph readgra = new readGraph();
        //读入用户文件
        read_user readUser = new read_user();
        // 创建 JFrame 实例
        JFrame frame = new JFrame("智慧校园导览系统");
        frame.setSize(600, 800);
        frame.setLocation(20, 15);
        JPanel jpnel=new JPanel();

        JButton button1 = new JButton();
        button1.setBounds(80, 30, 360, 80);
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
        button2.setBounds(80, 140, 360, 80);
        button2.setText("注册");
        button2.setBackground(Color.CYAN);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
}
