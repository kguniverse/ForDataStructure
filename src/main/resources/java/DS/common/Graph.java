package DS.common;

import java.util.*;
import java.util.function.UnaryOperator;

public class Graph{
    private Vertex[] e1;
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
        e1 = new Vertex[Constants.MAXIMUM_Node];
        for(int i = 0; i < Constants.MAXIMUM_Node; i++) e1[i] = new Vertex();
        for(Edge e : edges) addEdge(e);
        nameToNodeIndex = new HashMap<>();
        nodeIndexToName = new HashMap<>();
        for(Node x : nodes){
            nameToNodeIndex.put(x.getName(), x.getId());
            nodeIndexToName.put(x.getId(), x.getName());
        }
    }

    public void addEdge(Edge e){
        //TODO:add next edge
        int u = e.getFrom();
        Vertex head = e1[u];
        while(head.hasNext()) head = head.getNextVertex();
        head.addNextVertex(e);
    }
    public Node getNode(int index) { return nodes.get(index); }
    public int getNameToNodeIndex(String name) {return nameToNodeIndex.get(name);}
    public String getNodeIndexToName(int index) {return nodeIndexToName.get(index);}
    public Vertex getHeadVertex(int index) {
        return e1[index];
    }
}
