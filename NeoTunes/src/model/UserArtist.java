package model;

import java.util.ArrayList;
import java.util.Date;

public class UserArtist extends UserProducer{
    private ArrayList<Song> songs;
    public UserArtist(String name, String id, Date date, String url) {
        super(name, id, date, url);
        songs = new ArrayList<Song>();
    }

    public boolean addSong(Song song){
        return songs.add(song);
    }
}
