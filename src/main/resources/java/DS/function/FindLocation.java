package DS.function;
import readinFiles.readGraph;
import DS.common.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class FindLocation {
    private static final int distance = 150;
    public static ArrayList<Node> findlocation(int x, int y) {
        ArrayList<Node> location = new ArrayList<>();
        for(int i = 0; i < readGraph.nodes.size(); i++) {
            if(Math.abs(readGraph.nodes.get(i).getPosX()-x) + Math.abs(readGraph.nodes.get(i).getPosY()-y) < distance && !Character.isDigit(readGraph.nodes.get(i).getName().charAt(0))) {
                location.add(readGraph.nodes.get(i));
            }
        }

        Collections.sort(location, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(Math.abs(o1.getPosX()-x + o1.getPosY()-y) > Math.abs(o2.getPosX()-x + o2.getPosY()-y))
                    return 1;
                return 0;
            }
        });
        return location;
    }
}
