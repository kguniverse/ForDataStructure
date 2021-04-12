package DS.common;

public class Edge{
    private int type;
    private int stream;
    private int length;
    private int id;
    private int from;
    private int to;
    private int cmp;

    public Edge() {}
    public Edge(int type, int from, int to, int length, int stream) {
        this.type = type;
        this.stream = 0;
        this.length = length;
        this.from = from;
        this.id = ++Constants.NowEdgeNum;
        this.to = to;
        this.stream = stream;
    }
    public Edge(int to, int val){
        this.to = to;
        this.cmp = val;
    }


    public int getLength() { return length; }
    public int getStream() {
        return stream;
    }
    public int getFrom() {return from;}
    public int getTo() {return to;}
    public int getId() {return id;}

    public void setLength(int length){ this.length = length; }
    public void showInDos(){

    }

    public Edge getReverseEdge(){ return new Edge(type, to, from, length, stream); }
}
