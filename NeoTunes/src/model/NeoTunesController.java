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
    }

    public String bestContentCreator(int amount){
        boolean control = false;
        String msg = "";
        UserContentCreator[] best = new UserContentCreator[amount];
        for (int x = 0; x < best.length; x++){
            for (int i = 0; i < producers.size(); i++){
                if( producers.get(i) instanceof UserContentCreator){
                    for(int y = 0; y< best.length; y++){
                        if(best[y] != null){
                            control = control || !((producers.get(i) + producers.get(i).getId()).equals(best[y].getName() + best[y].getId()));
                        }
                    }
                    if ( !control ){
                        if ( best[x] == null ){
                            best[x] = (UserContentCreator) producers.get(i);
                        } else {
                            if ( producers.get(i).getNumReproduction() > best[x].getNumReproduction() ){
                                best[x] = (UserContentCreator) producers.get(i);
                            }
                        }
                    }
                }
            }
        }

        for (int x = 0; x<best.length; x++){
            if(best[x]!=null){
                msg += "\n " + (x + 1) + ". " + best[x].getName() + ". Reproduction: " + best[x].getNumReproduction();
            }
        }
        return msg;
    }

    public String bestArtist(int amount){
        boolean control = false;
        String msg = "";
        UserArtist[] best = new UserArtist[amount];
        for (int x = 0; x < best.length; x++){
            for (int i = 0; i < producers.size(); i++){
                if( producers.get(i) instanceof UserArtist){
                    for(int y = 0; y< best.length; y++){
                        if(best[y] != null){
                            control = control || !((producers.get(i) + producers.get(i).getId()).equals(best[y].getName() + best[y].getId()));
                        }
                    }
                    if ( !control ){
                        if ( best[x] == null ){
                            best[x] = (UserArtist) producers.get(i);
                        } else {
                            if ( producers.get(i).getNumReproduction() > best[x].getNumReproduction() ){
                                best[x] = (UserArtist) producers.get(i);
                            }
                        }
                    }
                }
            }
        }

        for (int x = 0; x<best.length; x++){
            if(best[x]!=null){
                msg += "\n " + (x + 1) + ". " + best[x].getName() + ". Reproduction: " + best[x].getNumReproduction();
            }
        }
        return msg;
    }

    public String bestSong(int amount){
        boolean control = false;
        String msg = "";
        Song[] best = new Song[amount];
        for (int x = 0; x < best.length; x++){
            for (int i = 0; i < audios.size(); i++){
                if( audios.get(i) instanceof Song){
                    for(int y = 0; y< best.length; y++){
                        if(best[y] != null){
                            control = control || !((audios.get(i) + audios.get(i).getUrl()).equals(best[y].getName() + best[y].getUrl()));
                        }
                    }
                    if ( control ){
                        if ( best[x] == null ){
                            best[x] = (Song) audios.get(i);
                        } else {
                            if ( audios.get(i).getNumReproductions() > best[x].getNumReproductions() ){
                                best[x] = (Song) audios.get(i);
                            }
                        }
                    }
                }
            }
        }

        for (int x = 0; x<best.length; x++){
            if(best[x]!=null){
                msg += "\n " + (x + 1) + ". " + best[x].getName() + ". Reproduction: " + best[x].getNumReproductions();
            }
        }
        return msg;
    }

    public String bestPodcast(int amount){
        boolean control = false;
        String msg = "";
        Podcast[] best = new Podcast[amount];
        for (int x = 0; x < best.length; x++){
            for (int i = 0; i < audios.size(); i++){
                if( audios.get(i) instanceof Podcast){
                    for(int y = 0; y< best.length; y++){
                        if(best[y] != null){
                            control = control || !((audios.get(i) + audios.get(i).getUrl()).equals(best[y].getName() + best[y].getUrl()));
                        }
                    }
                    if ( control ){
                        if ( best[x] == null ){
                            best[x] = (Podcast) audios.get(i);
                        } else {
                            if ( audios.get(i).getNumReproductions() > best[x].getNumReproductions() ){
                                best[x] = (Podcast) audios.get(i);
                            }
                        }
                    }
                }
            }
        }

        for (int x = 0; x<best.length; x++){
            if(best[x]!=null){
                msg += "\n " + (x + 1) + ". " + best[x].getName() + ". Reproduction: " + best[x].getNumReproductions();
            }
        }
        return msg;
    }

    /** Description:
     *         This method will take care of receiving the user information and create a user from it.
     * @param name String: user's name
     * @param id String: personal user id
     * @param selection int: type of user to register
     * @return boolean: User creation status
     */
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

    /** Description:
     * This method will be responsible for receiving the user information and creating a user from it.
     * @param name String: user's name
     * @param id String: user's personal identifier.
     * @param url String: text string: Url of the user's photo.
     * @param selection int: type of user to register
     * @return boolean: type of user to register User creation state
     */
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

    /** Description:
     *         This method will be responsible for receiving the user information and creating an audio from it.
     * @param selection int: User who produces the audio
     * @param name int: audio name
     * @param album String: album name
     * @param genre int: audio genre position
     * @param url String: photo url
     * @param duration int: audio duration
     * @param price double: audio price
     * @return boolean: audio registration status
     */
    public boolean registerAudio(int selection, String name, String album, int genre, String url, double duration, double price){
        Song temp = new Song(name, album, Genre.values()[genre-1], url, duration, price);
        if(!(producers.get(selection-1) instanceof UserArtist)){
            return false;
        }
        return audios.add(temp)&&(((UserArtist) producers.get(selection-1)).addSong(temp));
    }

    /**
     * @param selection
     * @param name
     * @param description
     * @param category
     * @param url
     * @param duration
     * @return
     */
    /** Description:
     *         This method will be responsible for receiving the user information and creating an audio from it.
     * @param selection int: User who produces the audio
     * @param name int: audio name
     * @param description String: description
     * @param category int: audio category position
     * @param url String: photo url
     * @param duration int: audio duration
     * @return boolean: audio registration status
     */
    public boolean registerAudio(int selection, String name, String description, int category, String url, double duration){
        Podcast temp = new Podcast(name, description, Category.values()[category-1], url, duration);
        if(!(producers.get(selection-1) instanceof UserContentCreator)){
            return false;
        }
        return audios.add(temp)&&(((UserContentCreator) producers.get(selection-1)).addPodcast(temp));
    }

    /** Description:
     *      This method will tell if a user is able to create a playlist.
     * @param selection int: User to analyze
     * @return boolean: status of ability to save a playlist
     */
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

    /** Description:
     *         This method creates a matrix in a random order.
     * @return matrix int[][]: generated matrix
     */
    public int[][] generateMatriz(){
        int rows = 6;
        int columns = 6;
        int[][] tmp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tmp[i][j] = rd.nextInt(10);
            }
        }
        return tmp;
    }

    /** Description:
     *        This method will create a playlist.
     * @param selection int: User who will make the playlist
     * @param name String: nombre de la playlist
     * @param selections Arraylist<Integer>: selected songs
     * @return msg String: in case the creation has been successful, it will show the created code and its array. In the opposite case, it will not show anything.
     */
    public String registerPlayList(int selection, String name, ArrayList<Integer> selections){
        ArrayList<Audio> temp = new ArrayList<>();
        boolean hasSong = false;
        boolean hasPodcast = false;
        int[][] tmp = generateMatriz();
        for(int i = 0; i<selections.size(); i++){
            temp.add(audios.get(selections.get(i)-1));
            hasSong = ((audios.get(selections.get(i) - 1) instanceof Song) || hasSong);
            hasPodcast = ((audios.get(selections.get(i) - 1) instanceof Podcast) || hasPodcast);
        }
        int caseCode = (hasSong && hasPodcast) ? 3 : hasSong ? 2 : hasPodcast ? 1 : 4;
        if (caseCode== 4){
            return "";
        } else {
            Playlist temp1 = new Playlist(name, generateCodePlaylist(caseCode, tmp));
            temp1.setAudios(temp);
            if ( (consumers.get(selection - 1)).addPlaylist(temp1) ){
                return getMatriz(tmp) + "\n Code generation... \n" + generateCodePlaylist(caseCode, tmp);
            } else {
                return "";
            }
        }
    }

    /** Description:
     *          This method will create the code for a playlist.
     * @param caseCode int: case of code generation
     * @param tmp int[][]: matrix to extract the code
     * @return code String: generated code
     */
    public String generateCodePlaylist(int caseCode,int[][] tmp){
        String msg = "";
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

    /** Description:
     *         this method will be in charge of generating a string in the order of a given matrix
     * @param tmp int[][]:
     * @return msg String; array to extract information
     */
    public String getMatriz(int[][] tmp){
        String msg = "";
        for (int i = 0; i < tmp.length; i++) { // filas numbers.length
            for (int j = 0; j < tmp[0].length; j++) { // columnas numbers[0].length
                msg += tmp[i][j] + " ";
            }
            msg += "\n";
        }
        return msg;
    }

    /** Description:
     *      this method will be in charge of generating a list string of all the consuming users.
     * @return msg String: list string of all the consuming users.
     */
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

    /** Description:
     *      this method will be in charge of generating a list string of all the artist users.
     * @return msg String: list string of all the artist users.
     */
    public String getAllArtist(){
        String msg = "";
        for(int i = 0; i<producers.size(); i++){
            if(producers.get(i) instanceof UserArtist){
                msg += "\n " + (i+1) + ". " + (producers.get(i)).getName() + ", " + (producers.get(i)).getId();
            }
        }
        return msg;
    }

    /** Description:
     *      this method will be in charge of generating a list string of all the content creator users.
     * @return msg String: list string of all the content creator users.
     */
    public String getAllContentCreator(){
        String msg = "";
        for(int i = 0; i<producers.size(); i++){
            if(producers.get(i) instanceof UserContentCreator){
                msg += "\n " + (i + 1) + ". " + (producers.get(i)).getName() + ", " + (producers.get(i)).getId();
            }
        }
        return msg;
    }

    /** Description:
     *      this method will be in charge of generating a list string of all the genres.
     * @return msg String: list string of all the genres.
     */
    public String getGenre(){
        String msg = "";
        for(int i = 0; i< Genre.values().length; i++){
            msg += "\n " + (i + 1) + ". " + Genre.values()[i];
        }
        return msg;
    }

    /** Description:
     *      this method will be in charge of generating a list string of all the category.
     * @return msg String: list string of all the category.
     */
    public String getCategory(){
        String msg = "";
        for(int i = 0; i< Category.values().length; i++){
            msg += "\n " + (i + 1) + ". " + Category.values()[i];
        }
        return msg;
    }

    /** Description:
     *      this method will be in charge of generating a list string of all the songs.
     * @return msg String: list string of all the songs.
     */
    public String getAllSongs(){
        String msg = "";
        for(int i = 0; i<audios.size(); i++){
            if(audios.get(i) instanceof Song){
                msg += "\n " + (i + 1) + ". " + (audios.get(i)).getName() + ", " + ((Song) audios.get(i)).getGenre();
            }
        }
        return msg;
    }


    /** Description:
     *      this method will be in charge of generating a list string of all the podcast.
     * @return msg String: list string of all the podcast.
     */
    public String getAllPodcast(){
        String msg = "";
        for(int i = 0; i<audios.size(); i++){
            if(audios.get(i) instanceof Podcast){
                msg += "\n " + (i + 1) + ". " + (audios.get(i)).getName() + ", " + ((Podcast) audios.get(i)).getCategory();
            }
        }

        return msg;
    }

    /** Description:
     *      This method will generate a list string of all the playlists of a user.
     * @return msg String: list string of all he playlists of a user.
     */
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

    /** Description:
     *          This method will take care of getting the code of a playlist.
     * @param selection int: user who has the playlist
     * @param selection1 int: Playlist
     * @return code String: playlist's code
     */
    public String getUserPlaylistCode(int selection, int selection1){
        String msg = "";
        if(consumers.get(selection-1) instanceof UserPremium){
            return ((UserPremium) consumers.get(selection-1)).getPlaylists().get(selection1-1).getCode();
        }
        if(consumers.get(selection-1) instanceof UserStandard){
            return ((UserStandard) consumers.get(selection-1)).getPlaylists()[selection1-1].getCode();

        }
        return msg;
    }

    /** Description:
     *         This method will search for a palylist with a given code.
     * @param code String: playlist code
     * @return
     */
    public String getPlaylistToCode(String code){
        String msg = "";
        for  (int i = 0; i<consumers.size(); i++){
            if(consumers.get(i) instanceof UserStandard){
                for(int j = 0; j<((UserStandard) consumers.get(i)).getPlaylists().length; j++)
                    if(((UserStandard) consumers.get(i)).getPlaylists()[j] != null){
                        if ( (((UserStandard) consumers.get(i)).getPlaylist(j).getCode()).equals(code) ){
                            return getUserPlaylist((i + 1), (j + 1));
                        }
                    } else {
                        return "Playlist not found";
                    }
            }
            if(consumers.get(i) instanceof UserPremium){
                for(int j = 0; j<((UserPremium) consumers.get(i)).getPlaylists().size(); j++)
                    if ( ((((UserPremium) consumers.get(i)).getPlaylists().get(j)).getCode()).equals(code) ){
                        return getUserPlaylist((i + 1), (j + 1));
                    }
            }
        }
        return msg = "Playlist not found";
    }

    /** Description:
     *          This method will be in charge of obtaining the information of a user's playlist.
     * @param selection int: user who has the playlist
     * @param selection1 int: Playlist
     * @return msg String: audios of the playlist
     */
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

    /** Description:
     *          This method will remove an audio from the playlist.
     * @param selection int: user who has the playlist
     * @param selection1 int: Playlist
     * @param selection2 int: audio to delete
     * @return status boolean: Deleted status
     */
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

    /** Description:
     *          This method will add audios to a playlist.
     * @param selection int: user who has the playlist
     * @param selection1 int: Playlist
     * @param selections int: audios to add
     * @return status boolean: Add status
     */
    public boolean registerAudiotoPlaylist(int selection, int selection1, ArrayList<Integer> selections){
        ArrayList<Audio> tmp;
        boolean hasSong = false;
        boolean hasPodcast = false;
        boolean temp = true;
        if(consumers.get(selection-1) instanceof UserPremium){
            for (int i = 0; i < selections.size(); i++){
                temp = temp && ((UserPremium) consumers.get(selection - 1)).getPlaylists().get(selection1 - 1).getAudios().add(audios.get(selections.get(i) - 1));
            }
            tmp = ((UserPremium) consumers.get(selection - 1)).getPlaylists().get(selection1 - 1).getAudios();
            for(int i = 0; i<tmp.size(); i++){
                hasSong = ((audios.get(i) instanceof Song) || hasSong);
                hasPodcast = ((audios.get(i) instanceof Podcast) || hasPodcast);
            }
            ((UserPremium) consumers.get(selection - 1)).getPlaylists().get(selection1 - 1).setCode(generateCodePlaylist(hasSong && hasPodcast ? 3 : hasSong ? 2 : hasPodcast ? 1 : 4, generateMatriz()));
        }
        if(consumers.get(selection-1) instanceof UserStandard){
            for (int i = 0; i < selections.size(); i++){
                temp = temp &&  ((UserStandard) consumers.get(selection-1)).getPlaylists()[selection1-1].getAudios().add(audios.get(selections.get(i)-1));
            }
            tmp = ((UserStandard) consumers.get(selection-1)).getPlaylists()[selection1-1].getAudios();
            for(int i = 0; i<tmp.size(); i++){
                hasSong = ((audios.get(i) instanceof Song) || hasSong);
                hasPodcast = ((audios.get(i) instanceof Podcast) || hasPodcast);
            }
            ((UserStandard) consumers.get(selection-1)).getPlaylists()[selection1-1].setCode(generateCodePlaylist(hasSong && hasPodcast ? 3 : hasSong ? 2 : hasPodcast ? 1 : 4, generateMatriz()));
        }
        return temp;
    }

    /** Description:
     *      This method will rename a playlist.
     * @param selection int: user who has the playlist
     * @param selection1 int: Playlist
     * @param rename String: new name
     * @return status boolean: rename Status
     */
    public boolean renamePlaylist(int selection, int selection1, String rename){
        if(consumers.get(selection-1) instanceof UserPremium){
            return ((UserPremium) consumers.get(selection - 1)).getPlaylists().get(selection1 - 1).setName(rename);
        }
        if(consumers.get(selection-1) instanceof UserStandard){
            return ((UserStandard) consumers.get(selection - 1)).getPlaylists()[selection1 - 1].setName(rename);
        }
        return false;
    }

    public String reproduceAudio(int selection, int selection1){
        audios.get(selection1-1).reproduce();
        return consumers.get(selection-1).reproduce((Audio) audios.get(selection1-1));
    }

    public boolean canBuySong(int selection){
        switch ((consumers.get(selection-1) instanceof UserPremium) ? 1 : (consumers.get(selection-1) instanceof UserStandard) ? 2 : 3){
            case 1:
                return true;
            case 2:
                for(int i =  0; i<((UserStandard) consumers.get(selection-1)).getPurchases().length; i++){
                    if(((UserStandard) consumers.get(selection-1)).getPurchases()[i]==null){
                        return true;
                    }
                }
        }
        return false;
    }

    public String totalReproductions(int selection){
        try{
            return audios.get(selection - 1).getName() + ", reproductions " + audios.get(selection - 1).getNumReproductions();
        } catch(Exception e){
            return "Error";
        }
    }
    public boolean buySong(int selection, int selection1){
        Purchase sell = new Purchase(new Date(), (((Song) audios.get(selection1-1)).sell()));
        if ( consumers.get(selection-1) instanceof UserPremium ){
            boolean st = ((UserPremium) consumers.get(selection-1)).getPurchases().add(sell);
            return st;
        }
        if ( consumers.get(selection-1) instanceof UserStandard ){
            for(int i = 0; i<((UserStandard) consumers.get(selection-1)).getPurchases().length; i++)
                if(((UserStandard) consumers.get(selection-1)).getPurchases()[i] == null){
                    ((UserStandard) consumers.get(selection-1)).getPurchases()[i] = sell;
                    return true;
                }
        }
        return false;
    }

    public void refresh(){
        for(int i = 0; i<producers.size(); i++){
            producers.get(i).refresh();
        }
    }

    public String sellGenre(int selection){
        String msg = "";
        Genre tmp = Genre.values()[selection-1];
        int totalSells = 0;
        int amountSells = 0;
        for(int i = 0; i<audios.size(); i++){
            if ( audios.get(i) instanceof Song){
                if (((Song) audios.get(i)).getGenre().equals(tmp)){
                    amountSells += (((Song) audios.get(i)).getNumSells());
                    totalSells += (((Song) audios.get(i)).getNumSells()*((Song) audios.get(i)).getPrice());
                }
            }
        }
        if (totalSells != 0){
            msg += "The genre " + (String.valueOf(tmp)).toLowerCase() + " has " + amountSells + " sells and " + totalSells + "$";
        } else {
            msg += "The genre has not sells";
        }
        return msg;
    }

    public String songMostSell(){
        String msg = "";
        Audio tmp = null;
        for(int i = 0; i<audios.size(); i++){
            if ( audios.get(i) instanceof Song ){
                if (tmp == null){
                    tmp = audios.get(i);
                } else {
                    if (((Song) tmp).getNumSells()<((Song) audios.get(i)).getNumSells()){
                        tmp = audios.get(i);
                    }
                }
            }
        }
        if(tmp == null){
            msg = "Neotunes has not sells";
        } else {
            msg = tmp.getName() + " has " + ((Song) tmp).getNumSells() + " sells with a price " + ((Song) tmp).getPrice() + "$";
        }
        return msg;
    }

    public String genreMostListened(){

        String msg = "";
        Genre tmp = null;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int j = 0; j<Genre.values().length; j++){
            tmp2 = 0;
            for (int i = 0; i < audios.size(); i++){
                if ( audios.get(i) instanceof Song ){
                    if (((Song) audios.get(i)).getGenre().equals(Genre.values()[j])){
                        tmp2 += audios.get(i).getNumReproductions();
                    }
                }
            }
            if(tmp1 < tmp2){
                tmp = Genre.values()[j];
                tmp1 = tmp2;
            }
        }
        if (tmp == null){
            msg = "No reproductions found";
        } else {
            msg = "The genre most reproduced is " + String.valueOf(tmp).toLowerCase() + " with " + tmp1 + " reproductions";
        }
        return msg;
    }

    public String genreMostListenedUser(int selection){
        ArrayList<Reproducible> tmp4 = consumers.get(selection-1).getReproduced();
        String msg = "";
        Genre tmp = null;
        int tmp1 = 0;
        int tmp2;
        for (int j = 0; j<Genre.values().length; j++){
            tmp2 = 0;
            for (int i = 0; i < tmp4.size(); i++){
                if ( tmp4.get(i) instanceof Song ){
                    if (((Song) tmp4.get(i)).getGenre().equals(Genre.values()[j])){
                        tmp2 += ((Song) tmp4.get(i)).getNumReproductions();
                    }
                }
            }
            if(tmp1 < tmp2){
                tmp = Genre.values()[j];
                tmp1 = tmp2;
            }
        }
        if (tmp == null){
            msg = "No reproductions found";
        } else {
            msg = "The genre most reproduced is " + String.valueOf(tmp).toLowerCase() + " with " + tmp1 + " reproductions";
        }
        return msg;
    }

    public String categoryMostListened(){

        String msg = "";
        Category tmp = null;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int j = 0; j<Category.values().length; j++){
            tmp2 = 0;
            for (int i = 0; i < audios.size(); i++){
                if ( audios.get(i) instanceof Podcast ){
                    if (((Podcast) audios.get(i)).getCategory().equals(Category.values()[j])){
                        tmp2 += audios.get(i).getNumReproductions();
                    }
                }
            }
            if(tmp1 < tmp2){
                tmp = Category.values()[j];
                tmp1 = tmp2;
            }
        }
        if (tmp == null){
            msg = "No reproductions found";
        } else {
            msg = "The genre most reproduced is " + String.valueOf(tmp).toLowerCase() + " with " + tmp1 + " reproductions";
        }
        return msg;
    }

    public String categoryMostListened(int selection){
        ArrayList<Reproducible> tmp4 = consumers.get(selection-1).getReproduced();
        String msg = "";
        Category tmp = null;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int j = 0; j<Category.values().length; j++){
            tmp2 = 0;
            for (int i = 0; i < tmp4.size(); i++){
                if ( tmp4.get(i) instanceof Podcast ){
                    if (((Podcast) tmp4.get(i)).getCategory().equals(Category.values()[j])){
                        tmp2 += ((Podcast)(tmp4.get(i))).getNumReproductions();
                    }
                }
            }
            if(tmp1 < tmp2){
                tmp = Category.values()[j];
                tmp1 = tmp2;
            }
        }
        if (tmp == null){
            msg = "No reproductions found";
        } else {
            msg = "The genre most reproduced is " + String.valueOf(tmp).toLowerCase() + " with " + tmp1 + " reproductions";
        }
        return msg;
    }

}
