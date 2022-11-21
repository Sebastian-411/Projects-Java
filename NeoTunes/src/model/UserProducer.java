package model;

import java.util.Date;

public abstract class UserProducer extends User{
    private int numReproduction;
    private double timeReproduced;
    private String url;

    public UserProducer(String name, String id, Date date, String url) {
        super(name, id, date);
        this.numReproduction = 0;
        this.timeReproduced = 0;
        this.url = url;
    }

    public int getNumReproduction() {
        return numReproduction;
    }

    public void setNumReproduction(int numReproduction) {
        this.numReproduction = numReproduction;
    }

    public double getTimeReproduced() {
        return timeReproduced;
    }

    public void setTimeReproduced(double timeReproduced) {
        this.timeReproduced = timeReproduced;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public abstract void refresh();

    @Override
    public String toString() {
        return "UserProducer" +
                "\n Name: " + getName() +
                "\n ID: " + getId() +
                "\n Date: " + getDate() +
                "\n Number of Reproduction: " + numReproduction +
                "\n Time Reproduced: " + timeReproduced +
                "\n Url: " + url;
    }
}
