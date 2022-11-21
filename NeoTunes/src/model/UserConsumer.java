package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class UserConsumer extends User implements Playable{
    private ArrayList<Reproducible> reproduced;
    public UserConsumer(String name, String id, Date date) {
        super(name, id, date);
        reproduced = new ArrayList<>();
    }

    public ArrayList<Reproducible> getReproduced() {
        return reproduced;
    }

    public void setReproduced(ArrayList<Reproducible> reproduced) {
        this.reproduced = reproduced;
    }

}
