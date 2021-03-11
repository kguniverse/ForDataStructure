package DS.common;

import java.util.*;

public class Graph{
    private Vector<Vector<Edge>> e1;
    private int totalNodeNum;
    public Graph(){}
    public Graph(int totalNodeNum){

        if(totalNodeNum <= Constants.MAXIMUM_Node)
        {
            e1 = new Vector<>(totalNodeNum);
            Constants.NowNodeNum += totalNodeNum;
            this.totalNodeNum = totalNodeNum;
        }
        //TODO:else brunch
    }
    public void addEdge(int type, int u, int v, int length){
        e1.get(u).add(new Edge(type, v, length));
        e1.get(v).add(new Edge(type, u, length));
    }
    public int getNodeNum(){return totalNodeNum;}
}
