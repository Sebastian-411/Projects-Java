package model;


public class Player {
    private String nickName;
    private String name;
    private double score;
    private int lives;
    private Level level;

    //Set and Get

    public Player(String nickName, String name, double startingScore, int lives, Level level){
        this.nickName = nickName;
        this.name = name;
        this.score = startingScore;
        this.lives = lives;
        this.level = level;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double startingScore) {
        this.score = startingScore;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    //



    // toString
    public String toString(){
        return  "\nPlayer info:" +
                "\n    Nick name: " + nickName +
                "\n    Name: " + name +
                "\n    Score: " + score +
                "\n    lives: " + lives +
                "\n    level: " + level;
    }

}
