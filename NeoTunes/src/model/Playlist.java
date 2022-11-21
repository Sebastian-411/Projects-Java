package model;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private String code;
    private ArrayList<Audio> audios;

    public Playlist(String name, String code) {
        this.name = name;
        this.code = code;
        audios = new ArrayList<Audio>();
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    @Override
    public String toString() {
        return "Playlist" +
                "\n Name: " + name +
                "\n Code: " + code +
                "\n Audios: " + audios;
    }
}
