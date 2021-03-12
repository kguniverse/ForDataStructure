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

    public void go(){
        if(beginNum == 0 || endNum == 0){
            return;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
    }

    public void showRoute(){
        
    }
}
