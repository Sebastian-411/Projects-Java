package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class UserConsumer extends User implements Playable{

    public UserConsumer(String name, String id, Date date) {
        super(name, id, date);
    }

}
