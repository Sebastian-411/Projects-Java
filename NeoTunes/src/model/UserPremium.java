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

    public String reproduce() {
        return null;
    }

    public String advertisable() {
        return null;
    }
}
