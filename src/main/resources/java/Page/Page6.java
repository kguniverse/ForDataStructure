package Page;

import DS.common.Edge;
import simuNavi.SimuNaviInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Page6 {
    private static String start;
    private static String end;
    private static final String[] items = new String[15];
    public static String getStart() { return start; }
    public static String getEnd() { return end; }
    private int num = 0;
    public void schedule() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("日程管理");
        // 设定面板大小
        frame.setSize(540, 270);
        frame.setLocation(170, 455);
        JPanel jp = new JPanel();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 270));
        //frame.add(panel);
        frame.setVisible(true);
        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));

        // 创建 JLabel
        JLabel startLabel = new JLabel("时间");
        startLabel.setBounds(10,20,80,25);
        panel.add(startLabel);
        JTextField timeText = new JTextField(20);
        timeText.setBounds(100,20,165,25);
        panel.add(timeText);
        // 输入的文本域用于目的地
        JLabel endLabel = new JLabel("事件");
        endLabel.setBounds(10,50,80,25);
        panel.add(endLabel);
        JTextField eventText = new JTextField(20);
        eventText.setBounds(100,50,165,25);
        panel.add(eventText);
        // 输入的文本域用于途径点
        JLabel goByLabel = new JLabel("地点");
        goByLabel.setBounds(10,80,80,25);
        panel.add(goByLabel);
        JTextField goByText = new JTextField(20);
        goByText.setBounds(100,80,165,25);
        panel.add(goByText);

        JScrollPane jScrollPane1 = new JScrollPane();    //滚动条panel
        jScrollPane1.setPreferredSize(new Dimension(308, 164));
        DefaultListModel jList1Model =  new DefaultListModel();
        JList myJlist = new JList(jList1Model);
        jScrollPane1.setViewportView(myJlist);
        jp.add(panel);
        jp.add(jScrollPane1);

        Scanner scEdge = null;
        try {
            scEdge = new Scanner(Paths.get("src/main/resources/java/readinFiles/user.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton add= new JButton("添加");
        add.setBounds(120,130, 120, 25);
        panel.add(add);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < num; i++) {
                    if(timeText.getText() == items[i]) {
                        Clash crash = new Clash();
                        crash.time_clash();
                        break;
                    }
                }
                if(num == 4) {
                    Clash crash = new Clash();
                    crash.time_clash();
                }
                if(num < 15 && num != 4) {
                    items[num] += num;
                    items[num] += ". ";
                    items[num] += "  时间：";
                    items[num] += timeText.getText();
                    items[num] += "  事件：";
                    items[num] += eventText.getText();
                    items[num] += "  地点：";
                    items[num] += goByText.getText();
                    items[num] += "                                                               ";
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
                start = timeText.getText();
                end = eventText.getText();
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

    public void inteligent_you() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("智慧小邮");
        // 设定面板大小
        frame.setSize(540, 270);
        frame.setLocation(170, 455);
        JPanel jp = new JPanel();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 270));
        //frame.add(panel);
        frame.setVisible(true);
        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));

        // 创建 JLabel
        JLabel startLabel = new JLabel("时间");
        startLabel.setBounds(10,20,80,25);
        panel.add(startLabel);
        JTextField timeText = new JTextField(20);
        timeText.setBounds(100,20,165,25);
        panel.add(timeText);
        // 输入的文本域用于目的地
        JLabel endLabel = new JLabel("当前位置");
        endLabel.setBounds(10,50,80,25);
        panel.add(endLabel);
        JTextField preLocation = new JTextField(20);
        preLocation.setBounds(100,50,165,25);
        panel.add(preLocation);
        JScrollPane jScrollPane1 = new JScrollPane();    //滚动条panel
        jScrollPane1.setPreferredSize(new Dimension(308, 164));
        DefaultListModel jList1Model =  new DefaultListModel();
        JList myJlist = new JList(jList1Model);
        jScrollPane1.setViewportView(myJlist);
        jp.add(panel);
        jp.add(jScrollPane1);

        Scanner scEdge = null;
        try {
            scEdge = new Scanner(Paths.get("src/main/resources/java/readinFiles/user.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.add(jScrollPane1, BorderLayout.EAST);

        JButton confirm = new JButton("确定");
        confirm.setBounds(120,130, 120, 25);
        panel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO 计算路径时间
                start = timeText.getText();
                end = preLocation.getText();
                /*
                TODO: 需要一个查询函数，查找输入的地点是否存在，以及地点的坐标
                 */
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
}
