package simuNavi;

public class Campus {
    private int widthFrame;
    private int heightFrame;
    private int widthImage;
    private int heightImage;

    Campus() {
        widthFrame = 1093;
        heightFrame = 730;
        widthImage = 1053;
        heightImage = 666;
    }
    Campus(int i) {
        widthFrame = 850;
        heightFrame = 1315;
        widthImage = 762;
        heightImage = 876;
    }

    public void setHeightFrame(int heightFrame) {
        this.heightFrame = heightFrame;
    }

    public void setHeightImage(int heightImage) {
        this.heightImage = heightImage;
    }

    public void setWidthFrame(int widthFrame) {
        this.widthFrame = widthFrame;
    }

    public void setWidthImage(int widthImage) {
        this.widthImage = widthImage;
    }

    public int getWidthFrame() {
        return widthFrame;
    }
    public int getHeightFrame() {
        return heightFrame;
    }

    public int getWidthImage() {
        return widthImage;
    }

    public int getHeightImage() {
        return heightImage;
    }
}
