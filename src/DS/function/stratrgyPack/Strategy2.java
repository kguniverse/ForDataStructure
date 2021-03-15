package DS.function.stratrgyPack;

import DS.common.Edge;
import DS.function.*;

public class Strategy2 extends Strategy{

    @Override
    public boolean judgeRelaxation(Edge u, int v) {
        return false;
    }

    @Override
    public void Relaxation(Edge u, int v) {

    }
}
