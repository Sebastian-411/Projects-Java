package model;

public abstract class Audio {
    private String name;
    private String url;
    private double duration;
    private int numReproductions;
    private double timeReproduced;

    public Audio(String name, String url, double duration) {
        this.name = name;
        this.url = url;
        this.duration = duration;
        this.numReproductions = 0;
        this.timeReproduced = 0;

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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getNumReproductions() {
        return numReproductions;
    }

    public void setNumReproductions(int numReproductions) {
        this.numReproductions = numReproductions;
        setTimeReproduced(this.numReproductions * this.duration);
    }

    public double getTimeReproduced() {
        return timeReproduced;
    }

    public void setTimeReproduced(double timeReproduced) {
        this.timeReproduced = timeReproduced;
    }

    @Override
    public String toString() {
        return "Audio" +
                "\n Name: " + name +
                "\n Url: " + url +
                "\n Duration: " + ((int) duration/60) + ":" + ((int) duration%60) +
                "\n Number of reproductions: " + numReproductions;
    }
}
