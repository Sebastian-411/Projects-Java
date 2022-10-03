package model;

import java.util.Arrays;

public class Level {
    private int idLevel;
    private double score;
    private Treasure[] treasures = new Treasure[50];
    private Enemy[] enemies = new Enemy[25];
    private DifficultLevel difficultLevel;

    public Level(int idLevel, double score) {
        this.idLevel = idLevel;
        this.score = score;
    }

    // Gets and setters

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public DifficultLevel getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(DifficultLevel difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

    /**
     * Description:
     * In this method we are going to add enemy to the level
     *
     * @param enemy Enemy: enemy that will be added
     * @param x     int: random position in X
     * @param y     int: random position in Y
     * @return boolean: status of the process
     */
    public boolean addEnemy(Enemy enemy, int x, int y) {
        for (int i = 0; i < enemies.length; i++){
            if ( enemies[i] == null ){
                enemies[i] = enemy;
                enemies[i].setPositionX(x);
                enemies[i].setPositionY(y);
                return true;
            }
        }
        return false;
    }


    /**
     * Description:
     * In this method we are going to add Treasure to the level
     *
     * @param treasure Treasure: enemy that will be added
     * @param x        int: random position in X
     * @param y        int: random position in Y
     * @return boolean: status of the process
     */
    public boolean addTreasure(Treasure treasure, int x, int y) {
        for (int i = 0; i < treasures.length; i++){
            if ( treasures[i] == null ){
                treasures[i] = treasure;
                treasures[i].setPositionX(x);
                treasures[i].setPositionY(y);
                return true;
            }
        }
        return false;
    }

    /**
     * Description:
     * In this method we are going to seacrh for enemies to don't repeat the same enemy for level
     *
     * @param enemy Enemy: Enemy that will be search
     * @return boolean: status of the search
     */
    public boolean searchEnemy(Enemy enemy) {
        for (int i = 0; i < enemies.length; i++){
            if ( enemies[i] != null ){
                if ( enemies[i].equals(enemy) ){
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "\nLevel information:" +
                "\n  idLevel: " + idLevel +
                "\n  score: " + score +
                "\n  treasures: " + Arrays.toString(treasures) +
                "\n  enemies: " + Arrays.toString(enemies) +
                "\n  difficultLevel: " + difficultLevel;
    }

    /**
     * Description:
     * In this method we will get the values of the all score that give the enemies
     *
     * @return double: the plus of the all score that give the enemies
     */
    public double valuePointsEnemy() {
        double valueEnemy = 0;
        for (int i = 0; i < enemies.length; i++){
            if ( enemies[i] != null ){
                valueEnemy = valueEnemy + enemies[i].getScore();
            }
        }
        return valueEnemy;
    }

    /**
     * Description:
     * In this method we will get the values of the all score that give the treasure
     *
     * @return double: the plus of the all score that give the treasure
     */
    public double valuePointsTreausure() {
        double valueTreasure = 0;
        for (int i = 0; i < treasures.length; i++){
            if ( treasures[i] != null ){
                valueTreasure = valueTreasure + treasures[i].getScore();
            }
        }
        return valueTreasure;
    }

    /**
     * Description:
     * In this method we will get the trasures assign to the level
     *
     * @return int:  the trasures assign to the level
     */
    public int amountTreasure() {
        int amountTreasure = 0;
        for (int i = 0; i < treasures.length; i++){
            if ( treasures[i] != null ){
                amountTreasure +=1;
            }
        }
        return amountTreasure;
    }

    /**
     * Description:
     * In this method we will get the enemies assign to the level
     *
     * @return int:  the enemies assign to the level
     */
    public int amountEnemies() {
        int amountEnemies = 0;
        for (int i = 0; i < enemies.length; i++){
            if ( enemies[i] != null ){
                amountEnemies +=1;
            }
        }
        return amountEnemies;
    }

    /**
     * Description:
     * This is a method that can help us to get details to level
     *
     * @return int: this method will return a details
     */
    public String getEnemiesTreasuresToLevel() {
        String mE = "";
        String mT = "";
        for (int i = 0; i < treasures.length; i++){
            if ( treasures[i] != null ){
                mT += ", " + treasures[i].getName();
            } else {
                if ( (i + 1) == treasures.length ){
                    if ( mT.equals("") ){
                        mT = "Nothing";
                    }
                }
            }
            if ( i < enemies.length ){
                if ( enemies[i] != null ){
                    mE += enemies[i].getName() + ", ";
                }
            } else {
                if ( (i + 1) == treasures.length ){
                    if ( mE.equals("") ){
                        mE = "Nothing";
                    }
                }
            }
        }
        return "Enemies, " + mE + "\nTreasures, " + mT;
    }
}
