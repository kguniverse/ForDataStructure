//地图查看
package Page;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page3 {
    public void page() {
        JFrame frame = new JFrame("智慧校园导览系统");
        frame.setSize(760, 896);
        frame.setLocation(635, 15);
        JPanel jpnel=new JPanel();
        jpnel.setLayout(null);
        JButton button1 = new JButton();
        button1.setBounds(350, 0, 60, 30);
        button1.setBackground(Color.CYAN);
        jpnel.add(button1);
        button1.setText("返回");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Page2 longin = new Page2();
                longin.page();
            }
        });

        ImageIcon image = new ImageIcon("src/main/resources/java/Image/map.png");
        image.setImage(image.getImage().getScaledInstance(669,771,Image.SCALE_DEFAULT));
        JLabel im = new JLabel(image);
        im.setBounds(0, 0, 760, 876);
        frame.add(im);

        jpnel.setBackground(new Color(0x99,0xCC, 0xFF));
        frame.add(jpnel);
        frame.setVisible(true);
    }
    public void page(int where) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("智慧校园导览系统");
        frame.setSize(858, 564);
        frame.setLocation(635, 15);
        JPanel jpnel=new JPanel();
        jpnel.setLayout(null);
        JButton button1 = new JButton();
        button1.setBounds(350, 0, 60, 30);
        button1.setBackground(Color.CYAN);
        jpnel.add(button1);
        button1.setText("返回");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Page2 longin = new Page2();
                longin.page();
            }
        });

        ImageIcon image = new ImageIcon("src/main/resources/java/Image/map2.png");
        image.setImage(image.getImage().getScaledInstance(842, 533,Image.SCALE_DEFAULT));
        JLabel im = new JLabel(image);
        im.setBounds(0, 0, 842, 533);
        frame.add(im);

        jpnel.setBackground(new Color(0x99,0xCC, 0xFF));
        frame.add(jpnel);
        frame.setVisible(true);
    }
}
