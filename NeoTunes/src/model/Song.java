package model;

public class Song extends Audio implements Sellable, Reproducible{
    private double price;
    private int numSells;
    private String Album;
    private Genre genre;

    public Song(String name, String album, Genre genre, String url, double duration, double price) {
        super(name, url, duration);
        this.price = price;
        this.numSells = 0;
        Album = album;
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumSells() {
        return numSells;
    }

    public void setNumSells(int numSells) {
        this.numSells = numSells;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Sellable sell() {
        setNumSells(getNumSells()+1);
        return Song.this;
    }

    public String reproduce() {
        return null;
    }


    @Override
    public String toString() {
        return "Song{" +
                "\n Name: " + getName() +
                "\n Url: " + getUrl() +
                "\n Duration: " + getDuration() +
                "\n Number of reproductions: " + getNumReproductions() +
                "\n Price: " + price +
                "\n Number of sells: " + numSells +
                "\n Album: " + Album +
                "\n Genre: " + genre;
    }
}
