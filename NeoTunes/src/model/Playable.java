package model;

public interface Playable {
    String reproduce(Reproducible audio);
    boolean addPlaylist(Playlist playlist);
    // Boolean buySong(Song song);
}
