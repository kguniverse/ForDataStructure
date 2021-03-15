package DS.function;

import java.util.Comparator;
import DS.common.*;

public abstract class Strategy {
    //TODO:此类会重写，添加函数，返回值为比较值的映射
    private Comparator<Edge> cmp;

    public Comparator<Edge> getCmp(){ return cmp; }

    public abstract boolean judgeRelaxation(Edge u, int v);
    public abstract void Relaxation(Edge u, int v);
}

