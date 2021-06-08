import DS.common.Edge;
import DS.common.Graph;
import DS.common.Node;
import DS.function.Navigator;
import MyLog.Mylog;
import readinFiles.readGraph;

import java.util.ArrayList;
import java.util.Vector;


public class test {

    public static void main(String[] args) {
        Mylog.lIprintf("this is a test");
        int begin = 101;
        int end = 501;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if(i == 2) continue;
            arr.add(9002 + i);
        }
        readGraph readgra = new readGraph();
        Navigator nav = new Navigator(readGraph.g);
        nav.setBeginNum(begin);
        nav.setEndNum(end);
        nav.setWaytoPoint(arr);
//        nav.go();
        nav.confirmedStart();
    }
}
