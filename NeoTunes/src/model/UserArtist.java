package model;

import java.util.ArrayList;
import java.util.Date;

public class UserArtist extends UserProducer{
    private ArrayList<Song> songs;
    private int numSells;
    public UserArtist(String name, String id, Date date, String url) {
        super(name, id, date, url);
        songs = new ArrayList<Song>();
        numSells = 0;
    }

    public void refresh() {
        int x = 0;
        int y = 0;
        for(int i = 0; songs.size()>i; i++){
            x += songs.get(i).getNumReproductions();
            y += songs.get(i).getNumSells();
        }
        setNumReproduction(x);
        setNumSells(y);
    }

    public boolean addSong(Song song){
        return songs.add(song);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public int getNumSells() {
        return numSells;
    }

    public void setNumSells(int numSells) {
        this.numSells = numSells;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }



}
