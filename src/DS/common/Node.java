package DS.common;

public class Node{
    private String name;
    private int id;

    public Node() {}
    public Node(String name, int id) {
        this.name = name;
        this.id = ++Constants.NowNodeNum;
    }
}
