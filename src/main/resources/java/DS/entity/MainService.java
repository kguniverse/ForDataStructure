package DS.entity;

import DS.function.Navigator;
import MyLog.Mylog;
import Page.*;
import DS.common.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class MainService {
    public static void main(String[] args) {

//        Page0 helloPage = new Page0();
//        helloPage.page();

        //Todo:程序入口：先读入地点信息后建图。
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        try {
            Scanner scEdge = new Scanner(Paths.get("src/main/resources/java/readinFiles/edges.txt"));
            while(scEdge.hasNextLine()){
                String infoEdge = scEdge.nextLine();
                String[] detailedInfoEdge = infoEdge.split(" ");
                //TODO:错误处理
                edges.add(new Edge(detailedInfoEdge));
                Mylog.lDprintf("successfully add Edge:" + infoEdge);
            }
            scEdge.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Scanner scNode = new Scanner(Paths.get("src/main/resources/java/readinFiles/nodes.txt"));
            while(scNode.hasNextLine()){
               String infoNode = scNode.nextLine();
               String[] detailedInfoNode = infoNode.split(" ");
               nodes.add(new Node(detailedInfoNode));
                Mylog.lDprintf("successfully add node:" + infoNode);

            }
            scNode.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graph g = new Graph(edges, nodes);
        Navigator nav = new Navigator(g);
        //TODO：读入完成(over)
        //TODO：日志模块 (over)
        //TODO：界面（命令行，能用就行）(over)

        //TODO：建图（通过两个数组  遇到问题
        //TODO：建导航（接口为图）遇到问题
        //TODO：读入起始点，终点
        //TODO：询问是否添加途径点
        //TODO：输出

    }
}
