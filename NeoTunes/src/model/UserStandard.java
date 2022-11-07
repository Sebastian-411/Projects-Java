package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class UserStandard extends UserConsumer implements Advertisable{
    private Purchase[] purchases;
    private Playlist[] playlists;

    private int songReproduced = 0;

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

    public String reproduce(Reproducible audio) {
        String msg = "";
        boolean found = true;
        Reproducible tmp = audio;
        if(tmp instanceof Audio){
            ((Audio) tmp).setNumReproductions(1);
            if(!reproduced.isEmpty()){
                for (int i = 0; (i < reproduced.size() + 1) && found; i++){
                    if ( i == reproduced.size() ){
                        reproduced.add(tmp);
                    } else {
                        if ( reproduced.get(i) instanceof Audio ){
                            if ( ((Audio) reproduced.get(i)).getName().equals(((Audio) tmp).getName()) ){
                                ((Audio) reproduced.get(i)).setNumReproductions(((Audio) reproduced.get(i)).getNumReproductions() + 1);
                                found = false;
                            }
                        }
                    }
                }
            } else {
                reproduced.add(tmp);
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
