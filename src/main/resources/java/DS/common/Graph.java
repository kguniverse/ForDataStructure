package DS.common;

import java.util.*;

public class Graph{
    private Vector<Vector<Edge>> e1;
    private HashMap<String, Integer> nameToNodeIndex;
    private HashMap<Integer, String> nodeIndexToName;

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
        nameToNodeIndex = new HashMap<>();
        for(Node x : nodes){
            nameToNodeIndex.put(x.getName(), x.getId());
            nodeIndexToName.put(x.getId(), x.getName());
        }
    }

    public void addEdge(Edge e){
        int u = e.getFrom();
        e1.get(u).add(e);
    }
    public Edge getEdge(int u, int index){
        return e1.get(u).get(index);
    }
    public Node getNode(int index) { return nodes.get(index); }
    public int getNameToNodeIndex(String name) {return nameToNodeIndex.get(name);}
    public String getNodeIndexToName(int index) {return nodeIndexToName.get(index);}
}
