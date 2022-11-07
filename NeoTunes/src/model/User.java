package model;

import java.util.Date;

public abstract class User{
    private String name;
    private String id;
    private Date date;

    public User(String name, String id, Date date) {
        this.name = name;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "User" +
                "\n Name: " + name +
                "\n ID: " + id +
                "\n Date: " + date;
    }
}
