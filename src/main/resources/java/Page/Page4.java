//定点导航
package Page;

import DS.common.Graph;
import simuNavi.SimuNaviInit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Page4 {
    private static String start;
    private static String end;
    private static final String[] items = new String[15];
    public static String getStart() { return start; }
    public static String getEnd() { return end; }
    private int num = 0;

    public void navigate_single() {
        JFrame frame = new JFrame("校园导览系统");
        frame.setSize(350, 230);
        frame.setLocation(170, 455);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        panel.setLayout(null);
        JLabel startLabel = new JLabel("起点名");
        startLabel.setBounds(10,20,80,25);
        panel.add(startLabel);
        JTextField startText = new JTextField(20);
        startText.setBounds(100,20,165,25);
        panel.add(startText);
        // 输入的文本域用于目的地
        JLabel endLabel = new JLabel("终点名");
        endLabel.setBounds(10,50,80,25);
        panel.add(endLabel);
        JTextField endText = new JTextField(20);
        endText.setBounds(100,50,165,25);
        panel.add(endText);

        JButton confirm = new JButton("确定");
        confirm.setBounds(120,100, 120, 25);
        panel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start = startText.getText();
                end = endText.getText();

                if(Graph.getNameToNodeIndex(start) != -1 && Graph.getNameToNodeIndex(end) != -1)
                    new SimuNaviInit();
                else {
                    startText.setText("");
                    endText.setText("");
                    Clash.Building_clash();
                }
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
    public void navigate_goby() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("校园导览系统");
        // 设定面板大小
        frame.setSize(450, 270);
        frame.setLocation(170, 455);
        JPanel jp = new JPanel();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 270));
        //frame.add(panel);
        frame.setVisible(true);
        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));

        // 创建 JLabel
        JLabel startLabel = new JLabel("起点名");
        startLabel.setBounds(10,20,80,25);
        panel.add(startLabel);
        JTextField startText = new JTextField(20);
        startText.setBounds(100,20,165,25);
        panel.add(startText);
        // 输入的文本域用于目的地
        JLabel endLabel = new JLabel("终点名");
        endLabel.setBounds(10,50,80,25);
        panel.add(endLabel);
        JTextField endText = new JTextField(20);
        endText.setBounds(100,50,165,25);
        panel.add(endText);
        // 输入的文本域用于途径点
        JLabel goByLabel = new JLabel("途径点");
        goByLabel.setBounds(10,80,80,25);
        panel.add(goByLabel);
        JTextField goByText = new JTextField(20);
        goByText.setBounds(100,80,165,25);
        panel.add(goByText);

        JScrollPane jScrollPane1 = new JScrollPane();    //滚动条panel
        jScrollPane1.setPreferredSize(new Dimension(218, 164));
        DefaultListModel jList1Model =  new DefaultListModel();
        JList myJlist = new JList(jList1Model);
        jScrollPane1.setViewportView(myJlist);
        jp.add(panel);
        jp.add(jScrollPane1);

        JButton add= new JButton("添加");
        add.setBounds(120,130, 120, 25);
        panel.add(add);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(num < 15) {
                    items[num] = goByText.getText();
                    jList1Model.addElement(items[num]);
                    goByText.setText("");
                    num++;
                }
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(jScrollPane1, BorderLayout.EAST);


        JButton confirm = new JButton("确定");
        confirm.setBounds(120,130, 120, 25);
        panel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start = startText.getText();


                end = endText.getText();
                /*
                TODO: 需要一个查询函数，查找输入的地点是否存在，以及地点的坐标
                 */
                new SimuNaviInit();
            }
        });

        //返回上级
        JButton button = new JButton();
        button.setBounds(120,180, 120, 25);
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

    //TODO 中途修改目的点，需要查询当前点位置
    public void change_way(String start, String end) {

    }
}