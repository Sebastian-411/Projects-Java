package model;

import java.util.Date;

public class UserStandard extends UserConsumer implements Advertisable{
    private Purchase[] purchases;
    private Playlist[] playlists;

    public UserStandard(String name, String id, Date date) {
        super(name, id, date);
        this.purchases = new Purchase[100];
        this.playlists = new Playlist[20];
    }

    public Purchase[] getPurchases() {
        return purchases;
    }

    public void setPurchases(Purchase[] purchases) {
        this.purchases = purchases;
    }

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
    }

    public Boolean addPlaylist(Playlist playlist) {
        for(int i =  0; i<playlists.length; i++){
            if(playlists[i]==null){
                playlists[i] = playlist;
                return true;
            }
        }
        return false;
    }

    public Playlist getPlaylist(int selection) {
        return playlists[selection];
    }

    public String reproduce() {
        return null;
    }

    public String advertisable() {
        return null;
    }
}
