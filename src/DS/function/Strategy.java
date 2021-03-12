package DS.function;

import java.util.Comparator;
import DS.common.Edge;

public abstract class Strategy {
    private static Comparator<Edge> cmp;

    public Comparator<Edge> getCmp(){ return cmp; }
}

