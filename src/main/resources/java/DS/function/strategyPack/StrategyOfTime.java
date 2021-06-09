package DS.function.strategyPack;

import DS.common.Edge;
import DS.function.*;

import java.util.Comparator;

public class StrategyOfTime extends Strategy{
    public StrategyOfTime() {
        cmp = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.getCmp(), o2.getCmp());
            }
        };
    }

    @Override
    public double cmpValue(Edge x) {
        return 1.0 * x.getLength() / x.getType();
    }
}
