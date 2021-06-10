//地点查询
package Page;

import DS.common.Graph;
import DS.common.Node;
import DS.function.FindLocation;
import DS.function.Navigator;
import simuNavi.SimuNaviInit;
import readinFiles.readGraph;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Page5 {
    public void consequence_query(ArrayList<Node> arr) {
        JFrame jframe = new JFrame("查询结果");
        jframe.setBounds(100,100,300,200);
        JPanel contentPane=new JPanel();
        contentPane.setBackground(new Color(0x99,0xCC, 0xFF));
        contentPane.setLayout(new BorderLayout(0, 0));
        jframe.setContentPane(contentPane);
        JScrollPane scrollPane=new JScrollPane();
        contentPane.add(scrollPane,BorderLayout.CENTER);
        JList list=new JList();
        scrollPane.setViewportView(list);
        String[] listData=new String[10];
        for (int i = 0; i< arr.size(); i++)
        {
            listData[i] = arr.get(i).getName();    //为数组中各个元素赋值
            listData[i] += "  距离： ";
            int length = Math.abs(arr.get(i).getPosX()+arr.get(i).getPosY()-arr.get(0).getPosX()-arr.get(0).getPosY());
            listData[i] += length;
        }
        list.setListData(listData);    //为列表填充数据
        jframe.setVisible(true);
    }
    public void query_buildings() {
        JFrame frame = new JFrame("地点查询");
        frame.setSize(350, 230);
        frame.setLocation(170, 455);
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        panel.setLayout(null);
        JLabel queryLabel = new JLabel("查询点");
        queryLabel.setBounds(10,20,80,50);
        panel.add(queryLabel);
        JTextField queryText = new JTextField(20);
        queryText.setBounds(100,20,165,50);
        panel.add(queryText);

        JButton confirm = new JButton("确定");
        confirm.setBounds(120,100, 120, 25);
        panel.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(readGraph.g.getNameToNodeIndex(queryText.getText()) != -1) {
                    consequence_query(FindLocation.findlocation(readGraph.g.getNode(readGraph.g.getNameToNodeIndex(queryText.getText())).getPosX(), readGraph.g.getNode(readGraph.g.getNameToNodeIndex(queryText.getText())).getPosY()));
                    frame.dispose();
                }
                else {
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
}