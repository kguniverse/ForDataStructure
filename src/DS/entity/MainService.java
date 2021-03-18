package DS.entity;

import DS.common.Edge;
import DS.common.Node;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MainService {
    public static void main(String[] args) {
        //Todo:程序入口：先读入地点信息后建图。
        ArrayList<Edge> edges;
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
    }
}
