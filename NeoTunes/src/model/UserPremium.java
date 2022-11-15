package model;

import java.util.ArrayList;
import java.util.Date;

public class UserPremium extends UserConsumer{
    private ArrayList<Purchase> purchases;
    private ArrayList<Playlist> playlists;

    public UserPremium(String name, String id, Date date) {
        super(name, id, date);
        playlists = new ArrayList<>();
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
    public String reproduce(Reproducible audio) {
        String msg = "";
        boolean found = true;
        Reproducible tmp = audio;
        if(tmp instanceof Audio){
            ((Audio) tmp).setNumReproductions(1);
            if(!getReproduced().isEmpty()){
                for (int i = 0; (i < getReproduced().size() + 1) && found; i++){
                    if ( i == getReproduced().size() ){
                        getReproduced().add(tmp);
                    } else {
                        if ( getReproduced().get(i) instanceof Audio ){
                            if ( ((Audio) getReproduced().get(i)).getName().equals(((Audio) tmp).getName()) ){
                                ((Audio) getReproduced().get(i)).setNumReproductions(((Audio) getReproduced().get(i)).getNumReproductions() + 1);
                                found = false;
                            }
                        }
                    }
                }
            } else {
                getReproduced().add(tmp);
            }
            msg += "Playing " + ((Audio) tmp).getName();
        }
        if ( msg.equals("")  ){
            System.out.println("An error has occurred");
        }
        return msg;
    }

}
