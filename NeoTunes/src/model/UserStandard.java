package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class UserStandard extends UserConsumer implements Advertisable{
    private Purchase[] purchases;
    private Playlist[] playlists;

    private int songReproduced;

    public UserStandard(String name, String id, Date date) {
        super(name, id, date);
        this.purchases = new Purchase[100];
        this.playlists = new Playlist[20];
        songReproduced = 0;
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

    /** Description:
     *          This method will take care of adding a playlist to the user.
     * @param playlist Playlist: playlist to add
     * @return status boolean: Process status
     */
    public boolean addPlaylist(Playlist playlist) {
        for(int i =  0; i<playlists.length; i++){
            if(playlists[i]==null){
                playlists[i] = playlist;
                return true;
            }
        }
        return false;
    }


    /** Description:
     *          This method will take care of return a playlist of the user.
     * @param selection int: playlist to return
     * @return playlists Playlist: Playlist selected.
     */
    public Playlist getPlaylist(int selection) {
        return playlists[selection];
    }

    public String reproduce(Audio tmp) {
        int i = 0;
        String msg = "";
        boolean found = true;
        if(!getReproduced().isEmpty()){
            for (i = 0; (i < getReproduced().size()) && found; i++){
                if ( getReproduced().get(i) instanceof Audio ){
                    if (getReproduced().get(i).equals(tmp)){
                        getReproduced().get(i).reproduce();
                        found = false;
                    }
                }
            }
        }else {
            if(tmp instanceof Song){
                getReproduced().add(((Song) tmp).clones());
            }
            if(tmp instanceof Podcast){
                getReproduced().add(((Podcast) tmp).clones());
            }
        }
        if ( !found ){
            if(tmp instanceof Song){
                getReproduced().add(((Song) tmp).clones());
            }
            if(tmp instanceof Podcast){
                getReproduced().add(((Podcast) tmp).clones());
            }
        }
        if(tmp instanceof Podcast){
            msg += advertisable();
            msg += "Playing " + ((Podcast) tmp).getName();
        }
        if (tmp instanceof Song){
            if ( songReproduced == 2 ){
                msg += "AD: " + advertisable();
                msg += "\n Now playing " + ((Song) tmp).getName();
                songReproduced = 0;
            } else {
                msg += "Playing " + ((Song) tmp).getName();
                songReproduced ++;
            }
        }
        if ( msg.equals("") ){
            System.out.println("An error has occurred");
        }
        return msg;
    }

    public String advertisable() {
        Random rd = new Random();
        return Advertisable.ads[rd.nextInt(Advertisable.ads.length)];
    }
}
