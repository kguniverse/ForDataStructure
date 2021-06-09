package DS.function;

import DS.common.*;
import DS.function.strategyPack.*;
import java.util.*;
import Page.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import readinFiles.readGraph;

public class Navigator {
    final static Logger logger = LoggerFactory.getLogger(Navigator.class);
    private Graph g;
    private int beginNum;
    private int endNum;
    private Vector<Edge> route;
    private Strategy strategy;
    private ArrayList<Integer> wayToPoint;
    private Vector<Edge> buffer;
    private int cannotApproach;
    private boolean setBeginNum;

    public Navigator(){ g = readGraph.g; }
    public Navigator(Graph g1){
        g = g1;
        route = new Vector<>();
        buffer = new Vector<>();
        wayToPoint = new ArrayList<>();
        setBeginNum = false;
        setStrategy(1);
    }
    //不含必经点
    public void setBeginNumByPage(){
        this.beginNum = g.getNameToNodeIndex(Page4.getStart());
        this.endNum = g.getNameToNodeIndex(Page4.getEnd());
        setBeginNum = true;
        logger.debug("already set beginNum to {}, endNum to {}", beginNum, endNum);
    }
    //包含必经点
    //TODO:type???
    public void setBeginNumByPage(int type){
        this.beginNum = g.getNameToNodeIndex(Page4.getStart());
        this.endNum = g.getNameToNodeIndex(Page4.getEnd());
        setBeginNum = true;
        logger.debug("already set beginNum to {}, endNum to {}", beginNum, endNum);
    }
    public int getBeginNum() {
        return beginNum;
    }
    public int getEndNum() {
        return endNum;
    }
    public ArrayList<Integer> getWayToPoint() {
        return wayToPoint;
    }


    public void setBeginNum(int x){beginNum = x;}
    public void setEndNum(int x){endNum = x;}
    public void setStrategy(int x){
        if(x == 1) strategy = new StrategyOfLength();
        else if(x == 2) strategy = new StrategyOfTime();
        else if(x == 3) strategy = new Strategy3();
        else if(x == 4) strategy = new Strategy4();
    }
    public void setWaytoPoint(ArrayList<Integer> wayToPoint){
        this.wayToPoint = wayToPoint;
        logger.debug("the way to point is set to {}", wayToPoint);
    }

    public boolean judgeBetweenCampus(){
        return g.getNode(beginNum) != g.getNode(endNum);
    }

    public double Dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>(strategy.getCmp());
        double[] dis = new double[Constants.MAXIMUM_Node];
        Edge[] fa = new Edge[Constants.MAXIMUM_Node];
        Edge[] buf = new Edge[Constants.MAXIMUM_Edge];
        cannotApproach = 0;
        for(int i = 1; i < Constants.MAXIMUM_Node; i++){
            dis[i] = Constants.inf;
        }
        dis[start] = 0;
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()){
            Edge u = pq.poll();
            if(u.getTo() == end)
                break;
            Vertex head = g.getHeadVertex(u.getTo());
            while(head.hasNext()){
                Edge v = head.getNextVertex().getEdge();
                int t = v.getTo();
                if(dis[t] > dis[u.getTo()] + strategy.cmpValue(v)/*v.getLength()*/){
                    dis[t] = dis[u.getTo()] + strategy.cmpValue(v);
                    pq.add(new Edge(t, dis[t]));
                    fa[t] = v;
                }
                head = head.getNextVertex();
            }
        }
        if(dis[end] == Constants.inf) {
            logger.warn("endpoint cannot approach");
            cannotApproach = 1;
            return -1;
        }else{
            int rec = end;
            int cnt = 0;
            while(rec != start){
                buf[cnt++] = fa[rec];
                rec = fa[rec].getFrom();
            }
            //get reverse route
            logger.info("get reverse route");
            for(int i = cnt - 1; i >= 0; i--){
                buffer.add(buf[i]);
            }
            //Correction
            logger.info("successfully get the direct route");
            return dis[end];
        }
    }
    public void addMustBy(int x) {
        wayToPoint.add(x);
    }
    public void confirmedStart(){
        if(wayToPoint.isEmpty()){
            double min_length = Dijkstra(beginNum, endNum);
            route.addAll(buffer);
            buffer.clear();
        }
        else{
            TSP TSP_method = new TSP(this);
            TSP_solution solution;
            if(TSP_method.G.vex_num <= 15){
                solution = TSP_method.BSM_dfs_TSP();
                logger.debug("run the BSM algorithm");
            }
            else{
                solution = TSP_method.SA_TSP();
                logger.debug("run the SA algorithm");
            }
            double min_length = 0;
            for(int i = 0; i <= wayToPoint.size(); i++){
                min_length += Dijkstra(TSP_method.getInitNum(solution.path[i]), TSP_method.getInitNum(solution.path[i + 1]));
                route.addAll(buffer);
                buffer.clear();
            }
            showRoute();
            logger.debug("途径点问题算法得到的距离答案：" + min_length) ;
        }
    }
    public void showRoute(){
        int num = route.size();
        if(cannotApproach == 1){
//            System.out.println("Sorry, you can not approach from "
//                    + g.getNodeIndexToName(beginNum)
//                    + " -> "
//                    + g.getNodeIndexToName(endNum)
//            );
            logger.warn("Sorry, you can not approach from "
                    + g.getNodeIndexToName(beginNum)
                    + " -> "
                    + g.getNodeIndexToName(endNum));
            return;
        }
        logger.info("Great, You find the way!\n");
        StringBuilder info = new StringBuilder(g.getNodeIndexToName(beginNum));
        for (Edge edge : route) {
            info.append(" -> ").append(g.getNodeIndexToName(edge.getTo()));
        }
        logger.info(info.toString());
    }
    public void go(){
        double dis = Dijkstra(beginNum, endNum);
        logger.debug("shortest distance:" + dis);
        route.addAll(buffer);
        showRoute();
        // TESTED
    }

    public int getRoute(int index) {
        return route.get(index).getTo();
    }

    public Vector<Edge> getRouteEdge() { return route; }

    public int getNum() {
        return route.size();
    }
    public Node getNode(int index){
        return g.getNode(index);
    }
    public void clearRoute() {
        buffer.clear();
        route.clear();
    }
}