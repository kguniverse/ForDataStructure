package DS.common;

import java.util.*;

public class Graph{
    private Vector<Vector<Edge>> e1;
    private HashMap<String, Integer> nameToBuildingIndex;
    private int totalNodeNum;
    private ArrayList<Edge> edges;
    private ArrayList<Node> nodes;

    public int getNodeNum(){return totalNodeNum;}
    public Graph(){}
    public Graph(ArrayList<Edge> edges, ArrayList<Node> nodes){
        this.edges = edges;
        this.nodes = nodes;
        this.totalNodeNum = nodes.size();
        for(Edge e : edges){
            addEdge(e);
        }
        nameToBuildingIndex = new HashMap<>();
        for(Node x : nodes){
            nameToBuildingIndex.put(x.getName(), x.getId());
        }
    }
    public void addEdge(Edge e){
        int u = e.getFrom(), v = e.getTo();
        e1.get(u).add(e);
    }

}
