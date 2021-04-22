package DS.common;

public class Vertex {
    private Edge e;
    private Vertex nextNode;

    public Vertex() {
    }

    public Vertex(Edge edge) {
        e = edge;
        nextNode = null;
    }

    public Vertex getNextVertex() {
        return nextNode;
    }
    public void addNextVertex(Edge e) {
        this.nextNode = new Vertex(e);
    }

    public boolean hasNext() {
        return nextNode != null;
    }

    public Edge getEdge() {
        return e;
    }
}
