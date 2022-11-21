package model;

import java.util.ArrayList;
import java.util.Date;

public class UserPremium extends UserConsumer{
    private ArrayList<Purchase> purchases;
    private ArrayList<Playlist> playlists;

    public UserPremium(String name, String id, Date date) {
        super(name, id, date);
        playlists = new ArrayList<>();
        purchases = new ArrayList<>();
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }


    /** Description:
     *          This method will take care of return the playlists of the user.
     * @return playlists Playlist: User playlists.
     */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }


    /** Description:
     *          This method will take care of adding a playlist to the user.
     * @param playlist Playlist: playlist to add
     * @return status boolean: Process status
     */
    public boolean addPlaylist(Playlist playlist) {
        return playlists.add(playlist);
    }


    @Override
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
                msg += "Playing " + (tmp).getName();
            }
            if ( !found ){
                if(tmp instanceof Song){
                    getReproduced().add(((Song) tmp).clones());
                }
                if(tmp instanceof Podcast){
                    getReproduced().add(((Podcast) tmp).clones());
                }
                msg += "Playing " + (tmp).getName();
            }
            if ( msg.equals("")  ){
                msg = ("An error has occurred");
            }
            return msg;
    }

}
