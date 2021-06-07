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
        int begin = 9047;
        int end = 9005;
        readGraph readgra = new readGraph();
        Navigator nav = new Navigator(readGraph.g);
        nav.setBeginNum(begin);
        nav.setEndNum(end);

        nav.go();
    }
}
