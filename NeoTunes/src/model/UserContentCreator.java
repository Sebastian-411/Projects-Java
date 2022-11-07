package model;

import java.util.ArrayList;
import java.util.Date;

public class UserContentCreator extends UserProducer{
    private ArrayList<Podcast> podcasts;
    public UserContentCreator(String name, String id, Date date, String url) {
        super(name, id, date, url);
        podcasts = new ArrayList<Podcast>();
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
