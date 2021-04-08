//地图查询

package Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page3 {
    public void graph() {
        JFrame frame=new JFrame("智慧校园导览系统");    //创建Frame窗口
        JPanel p=new JPanel();    //面板
        JPanel cards=new JPanel(new CardLayout());    //卡片式布局的面板
        frame.setLocation(200, 150);

        //返回上级
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(100,30));
        p.add(button);
        button.setText("返回上级");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Page2 Page = new Page2();
                Page.page();

            }
        });

        ImageIcon image = new ImageIcon("src/map.png");// 这是背景图片 .png .jpg .gif 等格式的图片都可以
        image.setImage(image.getImage().getScaledInstance(600,840,Image.SCALE_DEFAULT));//这里设置图片大小，目前是20*20
        JLabel im = new JLabel(image);
        im.setBounds(0, 0, 100, 200);
        p.add(im);
        cards.add(p);
        CardLayout c=(CardLayout)(cards.getLayout());
        c.show(cards,"card");    //调用show()方法显示面板
        frame.add(cards);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
