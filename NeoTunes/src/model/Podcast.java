package model;

public class Podcast extends Audio implements Reproducible{
    private String description;
    private Category category;
    public Podcast(String name, String description, Category category, String url, double duration) {
        super(name, url, duration);
        this.description = description;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Podcast clones(){
        return new Podcast(getName(), description, category, getUrl(), getDuration());
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "\n Name: " + getName() +
                "\n Url: " + getUrl() +
                "\n Duration: " + getDuration() +
                "\n Number of reproductions: " + getNumReproductions() +
                "\n Description: " + description +
                "\n Category: " + category;
    }
}
