package DS.common;

public class Node{
    private String name;
    private int id;
    private int posX;
    private int posY;
    private int campus;

    public Node() {}
    public Node(String name, int posX, int posY, int campus) {
        this.name = name;
        this.id = ++Constants.NowNodeNum;
        this.posX = posX;
        this.posY = posY;
        this.campus = campus;
    }

    public String getName(){return name;}
    public int getId() { return id; }
    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    public int getCampus() {return campus; }

}
