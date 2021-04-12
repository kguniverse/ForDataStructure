package DS.function;


import DS.common.*;
import DS.function.stratrgyPack.*;
import java.util.*;
import MyLog.Mylog;

public class Navigator {
    private final Graph g;
    private int beginNum;
    private int endNum;
    private Vector<Edge> route;
    private Strategy strategy;
    private ArrayList<Integer> WayToPoint;
    private Vector<Edge> buffer;
    private int cannotApproach;

    public Navigator(){ g = new Graph(); }
    public Navigator(Graph g1){
        g = g1;
        route = new Vector<>();
        buffer = new Vector<>();
    }

    public int getBeginNum() {
        return beginNum;
    }
    public int getEndNum() {
        return endNum;
    }
    public ArrayList<Integer> getWayToPoint() {
        return WayToPoint;
    }



    public void setBeginNum(int x){beginNum = x;}
    public void setEndNum(int x){endNum = x;}
    public void setStrategy(int x){
        if(x == 1) strategy = new Strategy1();
        else if(x == 2) strategy = new Strategy2();
        else if(x == 3) strategy = new Strategy3();
        else if(x == 4) strategy = new Strategy4();
    }
    public void setWaytoPoint(ArrayList<Integer> WayToPoint){
        this.WayToPoint = WayToPoint;
    }

    public boolean judgeBetweenCampus(){
        return g.getNode(beginNum) != g.getNode(endNum);
    }


    public int Dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>(strategy.getCmp());
        int[] dis = new int[g.getNodeNum() + 1];
        Edge[] fa = new Edge[g.getNodeNum() + 1];
        Edge[] buf = new Edge[g.getNodeNum() + 1];
        cannotApproach = 0;
        for(int i = 1; i <= g.getNodeNum(); i++){
            //dis[i] = Constants.inf;
        }
        dis[start] = 0;
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()){
            Edge u = pq.poll();
            if(u.getFrom() == end) break;
            for(int i = 0; i < g.getNodeNum(); i++){
                Edge v = g.getEdge(u.getFrom(), i);
                int t = v.getTo();
                if(dis[t] > dis[u.getFrom()] + strategy.cmpValue(v)){
                    dis[t] = dis[u.getFrom()] + strategy.cmpValue(v);
                    pq.add(new Edge(t, dis[t]));
                    fa[t] = v;
                }
            }
        }
        if(dis[end] == 1) {
            Mylog.lWprintf("endpoint cannot approach");
            cannotApproach = 1;
            return -1;
        }else{
            int rec = end;
            int cnt = 0;
            while(rec != start){
                buf[cnt++] = fa[rec];
                rec = fa[rec].getTo();
            }
            //get reverse route
            for(int i = cnt - 1; i >= 0; i--){
                buffer.add(buf[i]);
            }
            //Correction
            Mylog.lIprintf("successfully get the direct route");
            return dis[end];
        }
    }
    public void addMustBy(int x) {
        WayToPoint.add(x);
    }
    public void confirmedStart(){
        if(WayToPoint.isEmpty()){
            int min_length = Dijkstra(beginNum, endNum);
            route.addAll(buffer);
            buffer.clear();
        }
        else{
            TSP TSP_method = new TSP(this);
            TSP_solution solution = TSP_method.SA_TSP();
            for(int i = 0; i <= WayToPoint.size(); i++){
                int min_length = Dijkstra(WayToPoint.get(solution.getInitNum(solution.path[i])), solution.getInitNum(solution.path[i + 1]));
                route.addAll(buffer);
                buffer.clear();
            }
        }
    }
    public void showRoute(){
        int num = buffer.size();
        if(cannotApproach == 1){
            System.out.println("Sorry, you can not approach from "
                    + g.getNodeIndexToName(beginNum)
                    + " -> "
                    + g.getNodeIndexToName(endNum)
            );
            return;
        }

        System.out.println("Great, You find the way!\n");
        System.out.println(g.getNodeIndexToName(beginNum));
        StringBuilder info = new StringBuilder();
        for (Edge edge : route) {
            info.append(" -> ").append(g.getNodeIndexToName(edge.getTo()));
        }
        Mylog.lIprintf(info.toString());
    }
}