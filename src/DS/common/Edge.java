package DS.common;

public class Edge{
    private int type;
    private int stream;
    private int length;
    private int id;
    private int to;

    public Edge() {}

    public Edge(int type, int to, int length) {
        this.type = type;
        this.stream = 0;
        this.length = length;
        this.id = ++Constants.NowEdgeNum;
        this.to = to;
    }

    public int getLength() {
        return length;
    }

    public int getStream() {
        return stream;
    }
}
