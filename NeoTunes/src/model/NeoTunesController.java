package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class NeoTunesController {
    private Random rd;
    private ArrayList<UserConsumer> consumers;
    private ArrayList<UserProducer> producers;

    private ArrayList<Audio> audios;
    public NeoTunesController() {
        rd = new Random();
        consumers = new ArrayList<UserConsumer>();
        producers = new ArrayList<UserProducer>();
        audios = new ArrayList<Audio>();
        consumers.add(new UserStandard("Juan", "222", new Date()));
        producers.add(new UserArtist("Juan", "222", new Date(), "asdasdas"));

    }

    public boolean registerUser(String name, String id, int selection){
        switch (selection){
            case 1:
                return consumers.add(new UserStandard(name, id, new Date()));
            case 2:
                return consumers.add(new UserPremium(name, id, new Date()));
            default:
                return false;
        }
    }
    public boolean registerUser(String name, String id, String url, int selection){
        switch (selection){
            case 1:
                return producers.add(new UserArtist(name, id, new Date(), url));
            case 2:
                return producers.add(new UserContentCreator(name, id, new Date(), url));
            default:
                return false;
        }
    }

    public boolean registerAudio(int selection, String name, String album, int genre, String url, double duration, double price){
        Song temp = new Song(name, album, Genre.values()[genre-1], url, duration, price);
        if(!(producers.get(selection-1) instanceof UserArtist)){
            return false;
        }
        return audios.add(temp)||(((UserArtist) producers.get(selection-1)).addSong(temp));
    }

    public boolean registerAudio(int selection, String name, String description, int category, String url, double duration){
        Podcast temp = new Podcast(name, description, Category.values()[category-1], url, duration);
        if(!(producers.get(selection-1) instanceof UserContentCreator)){
            return false;
        }
        return audios.add(temp)||(((UserContentCreator) producers.get(selection-1)).addPodcast(temp));
    }

    public boolean canCreatePlaylist(int selection){
        switch ((consumers.get(selection-1) instanceof UserPremium) ? 1 : (consumers.get(selection-1) instanceof UserStandard) ? 2 : 3){
            case 1:
                return true;
            case 2:
                Playlist[] temp = ((UserStandard) consumers.get(selection-1)).getPlaylists();
                for(int i =  0; i<temp.length; i++){
                    if(temp[i]==null){
                        return true;
                    }
                }
        }
        return false;
    }

    public boolean registerPlayList(int selection, String name, ArrayList<Integer> selections){
        ArrayList<Audio> temp = new ArrayList<>();
        boolean hasSong = false;
        boolean hasPodcast = false;
        for(int i = 0; i<selections.size(); i++){
            temp.add(audios.get(selections.get(i)-1));
            hasSong = ((audios.get(selections.get(i) - 1) instanceof Song) || hasSong);
            hasPodcast = ((audios.get(selections.get(i) - 1) instanceof Podcast) || hasPodcast);
        }
        int caseCode = (hasSong && hasPodcast) ? 3 : hasSong ? 2 : hasPodcast ? 1 : 4;
        if (caseCode== 4){
            return false;
        }
        Playlist temp1 = new Playlist(name, generateCodePlaylist(caseCode));
        temp1.setAudios(temp);
        return (consumers.get(selection-1)).addPlaylist(temp1);
    }

    public String generateCodePlaylist(int caseCode){
        int number = 0;
        int rows = 6;
        int columns = 6;
        int[][] tmp = new int[rows][columns];
        String msg = "";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tmp[i][j] = rd.nextInt(10);
            }
        }

        switch (caseCode){
            case 1:
                for(int i = 0; i<tmp.length/2; i++){
                    msg += tmp[0][i];
                }
                for(int i = 1; i<tmp[(tmp.length/2)-1].length; i++){
                    msg += tmp[i][(tmp.length/2)-1];
                }
                for(int i = tmp.length-1; i>=0; i--){
                    msg += tmp[i][(tmp.length/2)];
                }
                for(int i = (tmp.length/2)+1; i<tmp.length; i++){
                    msg += tmp[0][i];
                }
                break;
            case 2:
                for(int i = tmp.length-1; i>=0; i--){
                    msg += tmp[i][0];
                }
                for(int i = 1; i<tmp.length-1; i++){
                    msg += tmp[i][i];
                }
                for(int i = tmp.length-1; i>=0; i--){
                    msg += tmp[i][tmp.length-1];
                }
                break;
            case 3:
                for (int i = (tmp.length)-1; i >= 0; i--) {
                    for (int j = (tmp[0].length)-1; j >= 0; j--) {

                        if((i+j)>1 && (i+j)%2!=0 ){
                            msg += tmp[i][j];
                        }
                    }
                }
                break;
        }
        return msg;
    }
    public String getAllUserConsumers(){
        String msg = "";
        for(int i = 0; i<consumers.size(); i++){
            msg += "\n " + (i+1) + ". " + (consumers.get(i)).getName() + ", " + (consumers.get(i)).getId();
        }
        return msg;
    }

    public String getAllAudios(){
        String msg = "";
        for(int i = 0; i<audios.size(); i++){
            msg += "\n " + (i+1) + ". " + (consumers.get(i)).getName() + ", " + (consumers.get(i)).getId();
        }
        return msg;
    }

    public String getAllUserProducer(){
        String msg = "";
        for(int i = 0; i<producers.size(); i++){
            msg += "\n " + (i+1) + ". " + (producers.get(i)).getName() + ", " + (producers.get(i)).getId();
        }
        if(msg.equals("")){
            msg += "Please, register a User Producer";
        }
        return msg;
    }

    public String getAllArtist(){
        String msg = "";
        for(int i = 0; i<producers.size(); i++){
            if(producers.get(i) instanceof UserArtist){
                msg += "\n " + (i+1) + ". " + (producers.get(i)).getName() + ", " + (producers.get(i)).getId();
            }
        }
        return msg;
    }

    public String getAllContentCreator(){
        String msg = "";
        for(int i = 0; i<producers.size(); i++){
            if(producers.get(i) instanceof UserContentCreator){
                msg += "\n " + (i + 1) + ". " + (producers.get(i)).getName() + ", " + (producers.get(i)).getId();
            }
        }
        return msg;
    }
    public String getGenre(){
        String msg = "";
        for(int i = 0; i< Genre.values().length; i++){
            msg += "\n " + (i + 1) + ". " + Genre.values()[i];
        }
        return msg;
    }

    public String getCategory(){
        String msg = "";
        for(int i = 0; i< Category.values().length; i++){
            msg += "\n " + (i + 1) + ". " + Category.values()[i];
        }
        return msg;
    }

    public String getAllSongs(){
        String msg = "";
        for(int i = 0; i<audios.size(); i++){
            if(audios.get(i) instanceof Song){
                msg += "\n " + (i + 1) + ". " + (audios.get(i)).getName() + ", " + ((Song) audios.get(i)).getGenre();
            }
        }
        return msg;
    }

    public String getAllPodcast(){
        String msg = "";
        for(int i = 0; i<audios.size(); i++){
            if(audios.get(i) instanceof Podcast){
                msg += "\n " + (i + 1) + ". " + (audios.get(i)).getName() + ", " + ((Podcast) audios.get(i)).getCategory();
            }
        }

        return msg;
    }

    public String getUserPlaylists(int selection){
        String msg = "";
        if(consumers.get(selection-1) instanceof UserPremium){
            ArrayList<Playlist> temp = ((UserPremium) consumers.get(selection-1)).getPlaylists();
            for(int i = 0; i<temp.size(); i++){
                msg += "\n " + (i + 1) + ". " + (temp.get(i)).getName();
            }
        }
        if(consumers.get(selection-1) instanceof UserStandard){
            Playlist[] temp = ((UserStandard) consumers.get(selection-1)).getPlaylists();
            for(int i = 0; i<temp.length; i++){
                if(temp[i] != null){
                    msg += "\n " + (i + 1) + ". " + (temp[i]).getName();
                }
            }
        }
        return msg;
    }

    public String getUserPlaylist(int selection, int selection1){
        String msg = "";
        if(consumers.get(selection-1) instanceof UserPremium){
            ArrayList<Playlist> temp = ((UserPremium) consumers.get(selection-1)).getPlaylists();
            for(int i = 0; i<temp.get(selection1-1).getAudios().size(); i++){
                msg += "\n " + (i + 1) + ". " + temp.get(selection1-1).getAudios().get(i).getName();
            }
        }
        if(consumers.get(selection-1) instanceof UserStandard){
            Playlist[] temp = ((UserStandard) consumers.get(selection-1)).getPlaylists();
            if(temp[selection1-1] != null){
                for(int i = 0; i<temp[selection1-1].getAudios().size(); i++){
                    msg += "\n " + (i + 1) + ". " + temp[selection1-1].getAudios().get(i).getName();
                }
            }
        }
        return msg;
    }

    public boolean deleteAudioPlaylist(int selection, int selection1, int selection2){
        if(consumers.get(selection-1) instanceof UserPremium){
            if(((UserPremium) consumers.get(selection-1)).getPlaylists().get(selection1-1).getAudios().isEmpty()){
                return false;
            }   else {
                return ((UserPremium) consumers.get(selection - 1)).getPlaylists().get(selection1 - 1).getAudios().remove(((UserPremium) consumers.get(selection - 1)).getPlaylists().get(selection1 - 1).getAudios().get(selection2 - 1));
            }
        }
        if(consumers.get(selection-1) instanceof UserStandard){
            if(((UserStandard) consumers.get(selection-1)).getPlaylists()[selection1-1].getAudios().isEmpty()){
                return false;
            }   else {
                return ((UserStandard) consumers.get(selection-1)).getPlaylists()[selection1-1].getAudios().remove(((UserStandard) consumers.get(selection-1)).getPlaylists()[selection1-1].getAudios().get(selection2-1));
            }
        }
        return false;
    }

    public boolean registerAudiotoPlaylist(int selection, int selection1, ArrayList<Integer> selections){
        boolean temp = true;
        if(consumers.get(selection-1) instanceof UserPremium){
            for (int i = 0; i < selections.size(); i++){
                temp = temp && ((UserPremium) consumers.get(selection - 1)).getPlaylists().get(selection1 - 1).getAudios().add(audios.get(selections.get(i) - 1));
            }
        }
        if(consumers.get(selection-1) instanceof UserStandard){
            for (int i = 0; i < selections.size(); i++){
                temp = temp &&  ((UserStandard) consumers.get(selection-1)).getPlaylists()[selection1-1].getAudios().add(audios.get(selections.get(i)-1));
            }
        }
        return temp;
    }

    public boolean renamePlaylist(int selection, int selection1, String rename){
        if(consumers.get(selection-1) instanceof UserPremium){
            return ((UserPremium) consumers.get(selection - 1)).getPlaylists().get(selection1 - 1).setName(rename);
        }
        if(consumers.get(selection-1) instanceof UserStandard){
            return ((UserStandard) consumers.get(selection - 1)).getPlaylists()[selection1 - 1].setName(rename);
        }
        return false;
    }

}
