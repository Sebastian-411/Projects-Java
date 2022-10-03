package model;

public class Treasure {
    private String name;
    private String url;
    private double score;
    private double positionX;
    private double positionY;

    public Treasure(String name, String url, double score) {
        this.name = name;
        this.url = url;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "\nTreasure info:" +
               "\n  name: " + name +
               "\n  url: " + url +
               "\n  score: " + score +
               "\n  positionX: " + positionX +
               "\n  positionY: " + positionY;
    }
}
