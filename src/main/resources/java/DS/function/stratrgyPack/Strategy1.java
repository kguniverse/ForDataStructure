package DS.function.stratrgyPack;

import DS.common.Edge;
import DS.function.*;

import java.util.Comparator;

public class Strategy1 extends Strategy{

    public Strategy1(){
        cmp = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getCmp() - o2.getCmp();
            }
        };
    }
    @Override
    public int cmpValue(Edge x) {
        return x.getLength();
    }
}
