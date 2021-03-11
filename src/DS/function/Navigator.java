package DS.function;


import DS.common.*;
import DS.function.stratrgyPack.*;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Navigator {
    private Graph g;
    private int beginNum;
    private int endNum;
    private int[] route;

    public Navigator(){ g = new Graph(); }

    public Navigator(Graph g1){ g = g1; }


    public void setBeginNum(int x){beginNum = x;}
    public void setEndNum(int x){endNum = x;}

    public void go(){
        if(beginNum == 0 || endNum == 0){
            return;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    }
}
