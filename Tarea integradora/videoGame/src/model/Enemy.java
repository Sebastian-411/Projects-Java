package model;

public class Enemy {
    private String name;
    private double damage;
    private double score;
    private TypesEnemies typesEnemies;
    private double positionX;
    private double positionY;

    public Enemy(String name, double damage, double score, TypesEnemies typesEnemies) {
        this.name = name;
        this.damage = damage;
        this.score = score;
        this.typesEnemies = typesEnemies;
    }

    // Gets and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
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

    public TypesEnemies getTypesEnemies() {
        return typesEnemies;
    }

    public void setTypesEnemies(TypesEnemies typesEnemies) {
        this.typesEnemies = typesEnemies;
    }

    //


    // toString
    @Override
    public String toString() {
        return "\nEnemy info: " +
               "\n  name: " + name +
               "\n  damage: " + damage +
               "\n  score: " + score +
               "\n  positionX=" + positionX +
               "\n  positionY=" + positionY;
    }
}
