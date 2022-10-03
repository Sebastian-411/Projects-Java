package model;

public enum Quality {
    SD("Standard Definition",640, 480),
    QHD("Quarter of High Definition",960, 540),
    HD("High Definition",1280, 720),
    FHD("Full HD",1920, 1080),
    WQHD("Quad High Definition",2560, 1440),
    UHD("Ultra High Definition",3840, 2160),
    UHD_8K("Ultra High Definition 8k",7680,4230);
    private String fullname;
    private int positionX;
    private int positionY;
    private Quality(String fullname, int positionX, int positionY){
        this.fullname = fullname;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return this.name() + ": " + fullname + " (" +  positionX + "x" + positionY + ")";
    }
}
