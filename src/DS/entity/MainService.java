package DS.entity;

import DS.common.*;
import DS.function.Navigator;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MainService {
    public static void main(String[] args) {
        //Todo:程序入口：先读入地点信息后建图。
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        try {
            Scanner scEdge = new Scanner(Paths.get("src/readinFiles/edges.txt"));
            while(scEdge.hasNext()){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Scanner scNode = new Scanner(Paths.get("src/readinFiles/nodes.txt"));
            while(scNode.hasNext()){
                int posX, posY, campus;
                String name;
                name = scNode.next();
                posX = scNode.nextInt();
                posY = scNode.nextInt();
                campus = scNode.nextInt();
                nodes.add(new Node(name, posX, posY, campus));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graph g = new Graph(edges, nodes);
        Navigator nav = new Navigator(g);

        //TODO：读入完成
        //TODO：日志模块
        //TODO：界面（命令行，能用就行）

        //TODO：建图（通过两个数组）over
        //TODO：建导航（接口为图）over
        //TODO：读入起始点，终点
        //TODO：询问是否添加途径点
        //TODO：输出


    }
}
