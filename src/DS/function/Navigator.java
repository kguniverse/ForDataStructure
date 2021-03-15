package DS.function;


import DS.common.*;
import DS.function.stratrgyPack.*;
import java.util.*;

public class Navigator {
    private Graph g;
    private int beginNum;
    private int endNum;
    private int[] route;
    private Strategy strategy;
    private ArrayList<Edge>WayToPoint;

    public Navigator(){ g = new Graph(); }
    public Navigator(Graph g1){ g = g1; }


            public void setBeginNum(int x){beginNum = x;}
    public void setEndNum(int x){endNum = x;}
    public void setStrategy(int x){
        if(x == 1) strategy = new Strategy1();
        else if(x == 2) strategy = new Strategy2();
        else if(x == 3) strategy = new Strategy3();
        else if(x == 4) strategy = new Strategy4();
    }
    public void setWaytoPoint(ArrayList<Edge> WayToPoint){
        this.WayToPoint = WayToPoint;
    }
    private void Dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>(strategy.getCmp());
        int[] dis = new int[g.getNodeNum() + 1];
        for(int i = 1; i <= g.getNodeNum(); i++){
            dis[i] = Constants.inf;
        }
        dis[start] = 0;
        while(!pq.isEmpty()){

        }
    }
    public void go(){
        if(beginNum == 0 || endNum == 0){
            return;
        }
    }

    public void showRoute(){

    }


}