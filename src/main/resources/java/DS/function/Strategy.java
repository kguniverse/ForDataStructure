package DS.function;

import java.util.Comparator;
import DS.common.*;

public abstract class Strategy {
    //TODO:此类会重写，添加函数，返回值为比较值的映射
    protected Comparator<Edge> cmp;

    public Comparator<Edge> getCmp(){ return cmp; }

    public abstract double cmpValue(Edge x);
}

