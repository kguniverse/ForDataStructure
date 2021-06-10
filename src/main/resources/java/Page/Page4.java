//定点导航
package Page;

import DS.common.Graph;
import DS.common.Node;
import DS.function.Navigator;
import simuNavi.SimuNaviInit;
import readinFiles.readGraph;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Page4 {
    private static String initStart;
    private static String initEnd;
    private static String start = "";
    private static String end = "";
    private static final String[] items = new String[15];
    public static String getStart() { return start; }
    public static String getEnd() { return end; }
    public static void setStart(String s) { start = s; }
    public static void setEnd(String e) { end = e; }
    public static String getInitStart() { return initStart; }
    public static String getInitEnd() { return initEnd; }
    private int num = 0;
    private int strtege = 1;

    public void navigate_single() {
        JFrame frame = new JFrame("校园导览系统");
        frame.setSize(460, 230);
        frame.setLocation(100, 455);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        panel.setLayout(null);
        JLabel startLabel = new JLabel("起点名");
        startLabel.setBounds(10,20,80,25);
        panel.add(startLabel);
        JTextField startText = new JTextField(20);
        startText.setBounds(100,20,155,25);
        panel.add(startText);
        // 输入的文本域用于目的地
        JLabel endLabel = new JLabel("终点名");
        endLabel.setBounds(10,50,80,25);
        panel.add(endLabel);
        JTextField endText = new JTextField(20);
        endText.setBounds(100,50,155,25);
        panel.add(endText);

        JCheckBox xituchengStart = new JCheckBox("西土城校区");
        JCheckBox shaheStart = new JCheckBox("沙河校区");
        xituchengStart.setBounds(255, 20, 100, 25);
        shaheStart.setBounds(355, 20, 100, 25);
        panel.add(xituchengStart);
        panel.add(shaheStart);
        JCheckBox xituchengEnd = new JCheckBox("西土城校区");
        JCheckBox shaheEnd = new JCheckBox("沙河校区");
        xituchengEnd.setBounds(255, 50, 100, 25);
        shaheEnd.setBounds(355, 50, 100, 25);
        panel.add(xituchengEnd);
        panel.add(shaheEnd);

        JCheckBox strtege1 = new JCheckBox("最短距离");
        JCheckBox strtege2 = new JCheckBox("最短时间");
        strtege1.setBounds(255, 100, 100, 25);
        strtege2.setBounds(355, 100, 100, 25);
        panel.add(strtege1);
        panel.add(strtege2);
        JCheckBox strtege3 = new JCheckBox("途径最短");
        JCheckBox strtege4 = new JCheckBox("交通最短时间");
        strtege3.setBounds(255, 120, 100, 25);
        strtege4.setBounds(355, 120, 100, 25);
        panel.add(strtege3);
        panel.add(strtege4);
        strtege1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strtege = 1;
            }
        });
        strtege2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strtege = 2;
            }
        });
        strtege3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strtege = 3;
            }
        });
        strtege4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strtege = 4;
            }
        });

        shaheStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder buf = new StringBuilder("1");
                buf.append(start);
                start = buf.toString();
            }
        });
        shaheEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder buf = new StringBuilder("1");
                buf.append(end);
                end = buf.toString();
            }
        });


        JButton confirm = new JButton("确定");
        confirm.setBounds(120,100, 120, 25);
        panel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder buf = new StringBuilder(start);
                buf.append(startText.getText());
                start = buf.toString();
                buf = new StringBuilder(end);
                buf.append(endText.getText());
                end = buf.toString();
                initEnd = end;
                initStart = start;
                shaheEnd.setSelected(false);
                shaheStart.setSelected(false);
                if(readGraph.g.getNameToNodeIndex(start) != -1 &&readGraph.g.getNameToNodeIndex(end) != -1)
                    new SimuNaviInit().simuInit(null, 1);
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
        // 输入的文本域用于途径点\
        JLabel label = new JLabel("添加途径点");
        JComboBox cmp = new JComboBox();
        for(Node u : readGraph.nodes){
            if(u.getName().getBytes(StandardCharsets.UTF_8).length != u.getName().length()) {
                cmp.addItem(u.getName());
            }
        }
        panel.add(cmp);
        //cmp.setBounds();

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
                items[num] = (String)cmp.getSelectedItem();
                jList1Model.addElement((items[num]));
                goByText.setText("");
                num++;
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(jScrollPane1, BorderLayout.EAST);

        JButton confirm = new JButton("确定");
        confirm.setBounds(120,130, 120, 25);
        panel.add(confirm);
        ArrayList<Integer> go_by = new ArrayList<>();
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start = startText.getText();
                end = endText.getText();
                for(int i = 0; i < num; i++) {
                    int index = readGraph.g.getNameToNodeIndex(items[i]);
                    if(index != -1)
                        go_by.add(index);
                }
                new SimuNaviInit().simuInit(go_by, strtege);
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
    public void change_way(String new_start) {
        JFrame frame = new JFrame("校园导览系统");
        frame.setSize(370, 270);
        frame.setLocation(170, 455);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        panel.setLayout(null);
        JLabel endLabel = new JLabel("更改终点名");
        endLabel.setBounds(10,100,80,25);
        panel.add(endLabel);
        JTextField endText = new JTextField(20);
        endText.setBounds(100,100,165,25);
        panel.add(endText);

        JCheckBox strtege1 = new JCheckBox("最短距离");
        JCheckBox strtege2 = new JCheckBox("最短时间");
        strtege1.setBounds(70, 10, 100, 25);
        strtege2.setBounds(180, 10, 100, 25);
        panel.add(strtege1);
        panel.add(strtege2);
        JCheckBox strtege3 = new JCheckBox("途径最短");
        JCheckBox strtege4 = new JCheckBox("交通最短时间");
        strtege3.setBounds(70, 40, 100, 25);
        strtege4.setBounds(180, 40, 100, 25);
        panel.add(strtege3);
        panel.add(strtege4);
        strtege1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strtege = 1;
            }
        });
        strtege2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strtege = 2;
            }
        });
        strtege3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strtege = 3;
            }
        });
        strtege4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strtege = 4;
            }
        });

        JButton confirm = new JButton("确定");
        confirm.setBounds(120,135, 120, 25);
        panel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                end = endText.getText();
                start = new_start;
                if(readGraph.g.getNameToNodeIndex(start) != -1 && readGraph.g.getNameToNodeIndex(end) != -1)
                    new SimuNaviInit().simuInit(null, strtege);
                else {
                    endText.setText("");
                    Clash.Building_clash();
                }
            }
        });

        //返回上级
        JButton button = new JButton();
        button.setBounds(120,170, 120, 25);
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