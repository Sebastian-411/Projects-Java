package model;

import java.util.ArrayList;
import java.util.Date;

public class UserContentCreator extends UserProducer{
    private ArrayList<Podcast> podcasts;
    public UserContentCreator(String name, String id, Date date, String url) {
        super(name, id, date, url);
        podcasts = new ArrayList<Podcast>();
    }
    public void refresh() {
        int x = 0;
        for(int i = 0; podcasts.size()>i; i++){
            x += podcasts.get(i).getNumReproductions();
        }
        setNumReproduction(x);
    }

    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    /** Description:
     *          This method will take care of adding a podcast to the user.
     * @param podcast Podcast: Podcast to add
     * @return status boolean: Process status
     */
    public boolean addPodcast(Podcast podcast){
        return podcasts.add(podcast);
    }
}
