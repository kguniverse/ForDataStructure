package readinFiles;
import DS.common.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class readGraph {
    //Todo:程序入口：先读入地点信息后建图。
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static ArrayList<Node> nodes = new ArrayList<>();
    public readGraph() {
        try {
            Scanner scEdge = new Scanner(Paths.get("src/main/resources/java/readinFiles/edges.txt"));
            while(scEdge.hasNextLine()){
                String infoEdge = scEdge.nextLine();
                String[] detailedInfoEdge = infoEdge.split(" ");
                //TODO:错误处理
                edges.add(new Edge(detailedInfoEdge));
                edges.add((new Edge(detailedInfoEdge)).getReverseEdge());
//                Mylog.lDprintf("successfully add Edge:" + infoEdge);
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
//                Mylog.lDprintf("successfully add node:" + infoNode);

            }
            scNode.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
