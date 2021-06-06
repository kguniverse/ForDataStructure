package DS.common;

public class Edge{
    private int type;
    private int stream;
    private int length;
    private int id;
    private int from;
    private int to;
    private int campus;
    private int cmp;

    public Edge() {}
    public Edge(int type, int from, int to, int length, int campus, int stream) {
        this.type = type;
        this.stream = 0;
        this.length = length;
        this.from = from;
        this.id = ++Constants.NowEdgeNum;
        this.to = to;
        this.campus = campus;
        this.stream = stream;
    }
    public Edge(int to, int val){
        this.to = to;
        this.cmp = val;
    }
    public Edge(String[] detailedInfoEdge){
        this.type = Integer.parseInt(detailedInfoEdge[0]);
        this.length = Integer.parseInt(detailedInfoEdge[1]);
        this.id = Integer.parseInt(detailedInfoEdge[2]);
        this.from = Integer.parseInt(detailedInfoEdge[3]);
        this.to = Integer.parseInt(detailedInfoEdge[4]);
        this.campus = Integer.parseInt(detailedInfoEdge[5]);
        this.stream = Integer.parseInt(detailedInfoEdge[6]);
    }

    public int getLength() { return length; }
    public int getStream() {
        return stream;
    }
    public int getFrom() {return from;}
    public int getTo() {return to;}
    public int getId() {return id;}
    public int getType() { return type; }

    public void setLength(int length){ this.length = length; }
    public void showInDos(){

    }

    public Edge getReverseEdge(){ return new Edge(type, to, from, length, campus, stream); }

    public int getCmp() {
        return cmp;
    }
}
