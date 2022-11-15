package ui;



import model.NeoTunesController;

import java.util.ArrayList;
import java.util.Scanner;

public class NeoTunesManager {
    private Scanner sc;
    private NeoTunesController controller;
    public NeoTunesManager() {
        sc = new Scanner(System.in);
        controller = new NeoTunesController();
    }
    public static void main(String[] args) {
        NeoTunesManager manager = new NeoTunesManager();
        manager.menu();
    }

    /**
     * Description:
     *      This method will be in charge of show the menu, receive the user's answers and redirect the user according to his answers.
     */
    public void menu(){
        while(true) {
            System.out.println("Welcome to NeoTune"
                    + "\n What could we help you?"
                    + "\n 1. Register an user"
                    + "\n 2. Register an audio"
                    + "\n 3. Create a playlist"
                    + "\n 4. Edit a playlist"
                    + "\n 5. Share a playlist"
                    + "\n 6. Simulate the playing of a song or podcast"
                    + "\n 7. Buy a song");
            switch (intAnswer()){
                case 1:
                    registerUser();
                    break;
                case 2:
                    registerAudio();
                    break;
                case 3:
                    createPlaylist();
                    break;
                case 4:
                    editPlaylist();
                    break;
                case 5:
                    sharePlaylist();
                    break;
                case 6:
                    simulatePlaying();
                    break;
                case 7:
                    buySong();
                    break;
                case 10:
                    System.exit(0);
            }
        }
    }

    public void buySong(){
        System.out.println("Please, select the user that will reproduce");
        if(!controller.getAllUserConsumers().equals("")){
            System.out.println(controller.getAllUserConsumers());
            int selection = intAnswer();
            if ( controller.canBuySong(selection) ){
                System.out.println("Please, select the song to buy");
                System.out.println(controller.getAllSongs());
                int selection1 = intAnswer();
                controller.buySong(selection, selection1);
            } else {
                System.out.println("Sorry, this user cannot make any more purchases.");
            }
        } else{
            System.out.println("Please, register an user");
        }

    }

    public void simulatePlaying(){
        if(!controller.getAllUserConsumers().equals("")){
            System.out.println("Please, select the user that will reproduce");
            System.out.println(controller.getAllUserConsumers());
            int selection = intAnswer();
            String msg = "";
            System.out.println("Please, enter the audio that will be reproduced"
                    + "\n 1. Song"
                    + "\n 2. Podcast"
                    + "\n 3. Menu");
            switch (intAnswer()) {
                case 1:
                    msg = controller.getAllSongs();
                    if ( msg.equals("") ){
                        System.out.println("Please, register a song");
                        menu();
                    }
                    break;
                case 2:
                    msg = controller.getAllPodcast();
                    if ( msg.equals("") ){
                        System.out.println("Please, register a podcast");
                        menu();
                    }
                    break;
                case 3:
                    menu();
                    break;
                default:
                    System.out.println("Please, enter a valid option");
            }
            System.out.println(msg);
            int selection1 = intAnswer();
            System.out.println(controller.reproduceAudio(selection, selection1));
        } else{
            System.out.println("Please, register an user");
        }
    }

    /** Description:
     *      This method will process the request to share a playlist, either get the code to share it or search for a playlist by entering the code, it is important to know that this only allows you to view the playlist.
     */
    public void sharePlaylist(){
        System.out.println("What could we help you?"
                + "\n 1. Share a playlist"
                + "\n 2. View a playlist");
        switch (intAnswer()){
            case 1:
                System.out.println("Please, select the user that will share the playlist");
                if(!controller.getAllUserConsumers().equals("")){
                    System.out.println(controller.getAllUserConsumers());
                    int selection = intAnswer();
                    if ( controller.getUserPlaylists(selection).equals("") ){
                        System.out.println("The user has no playlist");
                    } else {
                        System.out.println(controller.getUserPlaylists(selection));
                        System.out.println("Please, select the playlist");
                        int selection1 = intAnswer();
                        System.out.println(controller.getUserPlaylistCode(selection, selection1));
                    }
                } else{
                    System.out.println("Please, register an user");
                }
                break;
            case 2:
                System.out.println("Please, enter the playlist's code");
                System.out.println(controller.getPlaylistToCode(sc.nextLine()));
                break;
            default:
                System.out.println("Enter a valid option");
        }
        menu();
    }

    /** Description:
     *      This method will process the request to edit a playlist, the capabilities with this method allow you to delete an audio, add an audio or rename a playlist
     */
    public void editPlaylist(){
        if(!controller.getAllUserConsumers().equals("")){
            System.out.println("Please, select the user that make this playlist");
            System.out.println(controller.getAllUserConsumers());
            int selection = intAnswer();
            if(controller.getUserPlaylists(selection).equals("")){
                System.out.println("The user has no playlist");
            } else {
                System.out.println(controller.getUserPlaylists(selection));
                System.out.println("Please, select the playlist");
                int selection1 = intAnswer();
                System.out.println("What do you want to do?"
                                    + "\n 1. Delete a Audio"
                                    + "\n 2. Add a Audio"
                                    + "\n 3. Rename playlist"
                                    + "\n 4. Back");
                switch (intAnswer()){
                    case 1:
                        if(controller.getUserPlaylist(selection, selection1).equals("")){
                            System.out.println("This playlist has not audios");
                            menu();
                        } else {
                            System.out.println(controller.getUserPlaylist(selection, selection1));
                            System.out.println("Please, choose the audio to delete ");
                            if ( controller.deleteAudioPlaylist(selection, selection1, intAnswer()) ){
                                System.out.println("The audio was deleted");
                            } else {
                                System.out.println("The audio was not deleted");
                            }
                        }
                        break;
                    case 2:
                        ArrayList<Integer> selections = new ArrayList<Integer>();
                        System.out.println("Please, add the audios to the playlist");
                        boolean control = true;
                        while (control) {
                            String msg = "";
                            control = false;
                            System.out.println("What do you want to add?"
                                    + "\n 1. Song"
                                    + "\n 2. Podcast"
                                    + "\n 3. Menu");
                            switch (intAnswer()) {
                                case 1:
                                    msg = controller.getAllSongs();
                                    if ( msg.equals("") ){
                                        System.out.println("Please, register a song");
                                        control = true;
                                    }
                                    break;
                                case 2:
                                    msg = controller.getAllPodcast();
                                    if ( msg.equals("") ){
                                        System.out.println("Please, register a podcast");
                                        control = true;
                                    }
                                    break;
                                case 3:
                                    menu();
                                    break;
                                default:
                                    System.out.println("Please, enter a valid option");
                                    control = true;
                            }
                            if(!control){
                                System.out.println(msg);
                                System.out.println("Please, enter the audio's ID");
                                selections.add(intAnswer());
                                System.out.println("Do you want to add another audio?"
                                        + "\n 1. Yes" +
                                        "\n 2. No");
                                if ( intAnswer() == 1 ){
                                    control = true;
                                } else {
                                    control = false;
                                    if (controller.registerAudiotoPlaylist(selection, selection1, selections)){
                                        System.out.println("The audio was added successfully" +
                                                "\n The playlist's code has been changed");
                                    } else {
                                        System.out.println("An error has occurred, try again later");
                                    }
                                    menu();
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Please, enter the new name");
                        String rename = sc.nextLine();
                        if ( controller.renamePlaylist(selection, selection1, rename) ){
                            System.out.println("The name has been changed successfully");
                        } else {
                            System.out.println("The name has not been changed");
                        }
                }
            }

        } else {
            System.out.println("Please, register ");
        }
    }

    /** Description:
     *          This method will allow the creation of a playlist, that is it will receive the information given by the user. and assign it directly to a consumer user.
     */
    public void createPlaylist(){
        if(!controller.getAllUserConsumers().equals("") && !controller.getAllSongs().equals("")){
            ArrayList<Integer> selections = new ArrayList<Integer>();
            System.out.println("Please, select the user that make this playlist");
            System.out.println(controller.getAllUserConsumers());
            int selection = intAnswer();
            if ( !controller.canCreatePlaylist(selection) ){
                System.out.println("The user can not create more playlist");
                menu();
            } else {
                System.out.println(controller.getUserPlaylists(selection));
                System.out.println("Please, enter the playlist's name");
                String name = sc.nextLine();
                System.out.println("Please, add the audios to the playlist");
                boolean control = true;
                while (control) {
                    String msg = "";
                    control = false;
                    System.out.println("What do you want to add?"
                            + "\n 1. Song"
                            + "\n 2. Podcast"
                            + "\n 3. Menu");
                    switch (intAnswer()) {
                        case 1:
                            msg = controller.getAllSongs();
                            if ( msg.equals("") ){
                                System.out.println("Please, register a song");
                                control = true;
                            }
                            break;
                        case 2:
                            msg = controller.getAllPodcast();
                            if ( msg.equals("") ){
                                System.out.println("Please, register a podcast");
                                control = true;
                            }
                            break;
                        case 3:
                            menu();
                            break;
                        default:
                            System.out.println("Please, enter a valid option");
                            control = true;
                    }
                    if(!control){
                        System.out.println(msg);
                        System.out.println("Please, enter the audio's ID");
                        selections.add(intAnswer());
                        System.out.println("Do you want to add another audio?"
                                + "\n 1. Yes" +
                                "\n 2. No");
                        if ( intAnswer() == 1 ){
                            control = true;
                        } else {
                            String tmsg = controller.registerPlayList(selection, name, selections);
                            if (!tmsg.equals("")){
                                System.out.println(tmsg);
                                System.out.println("The play was created successfully");
                            } else {
                                System.out.println("An error has occurred, try again later");
                            }
                            menu();
                        }
                    }
                }

            }
        } else {
            if(controller.getAllUserConsumers().equals("")){
                System.out.println("Please, register User consumers");
            } else {
                System.out.println("Please, register audios");
            }
            menu();
        }
    }

    /** Description:
     *          This method will take care of the creation of an audio will receive the information given by the user. and redirects it according to your selection.
     */
    public void registerAudio(){
            System.out.println("What type of user do you want to register? "
                    + "\n 1. Register a song"
                    + "\n 2. Register a podcast"
                    + "\n 3. Back");
            switch (intAnswer()){
                case 1:
                    registerSong();
                    break;
                case 2:
                    registerPodcast();
                    break;
                case 3:
                    menu();
                default:
                    System.out.println("Enter a valid option");
            }
    }

    /** Description:
     *          This method will take care of the creation of a song will receive the information given by the user. and assign it directly to a user artist.
     */
    public void registerSong(){
        if(!(controller.getAllArtist().equals(""))){
            System.out.println("Please, select the artist that make this song");
            System.out.println(controller.getAllArtist());
            int selection = intAnswer();
            System.out.println("Please, enter the song's name");
            String name = sc.nextLine();
            System.out.println("Please, enter the song's album");
            String album = sc.nextLine();
            System.out.println("Please, choose the song's genre");
            System.out.println(controller.getGenre());
            int genre = intAnswer();
            System.out.println("Please, enter the song's url photo");
            String url = sc.nextLine();
            System.out.println("Please, enter the song's duration (minutes : seconds)");
            String duration = sc.nextLine();
            int minute = Integer.parseInt(duration.split(":")[0]);
            int seconds = Integer.parseInt(duration.split(":")[1]);
            int time = (minute * 60) + seconds;
            System.out.println("Please, enter the song's price");
            double price = doubleAnswer();
            if(controller.registerAudio(selection, name, album, genre, url, time, price)){
                System.out.println("The audio was created successfully");
                menu();
            }
        } else {
            System.out.println("There are not user artist, please register one.");
            menu();
        }
    }

    /** Description:
     *          This method will take care of the creation of a podcast will receive the information given by the user. and assign it directly to a user content creator.
     */
    public void registerPodcast(){
        if(!(controller.getAllContentCreator().equals(""))){
            System.out.println("Please, select the content creator that make this podcast");
            System.out.println(controller.getAllContentCreator());
            int selection = intAnswer();
            System.out.println("Please, enter the podcast's name");
            String name = sc.nextLine();
            System.out.println("Please, enter the podcast's description");
            String description = sc.nextLine();
            System.out.println("Please, choose the podcast's category");
            System.out.println(controller.getCategory());
            int category = intAnswer();
            System.out.println("Please, enter the podcast's url photo");
            String url = sc.nextLine();
            System.out.println("Please, enter the song's duration (minutes : seconds)");
            String duration = sc.nextLine();
            int minute = Integer.parseInt(duration.split(":")[0]);
            int seconds = Integer.parseInt(duration.split(":")[1]);
            int time = (minute * 60) + seconds;
            if(controller.registerAudio(selection, name, description, category, url, time)){
                System.out.println("The audio was created successfully");
                menu();
            }
        } else {
            System.out.println("There are not user artist, please register one.");
            menu();
        }
    }

    /** Description:
     *          This method will handle the creation of a user, receive the information given by the user. and redirects it according to their selection.
     */
    public void registerUser(){
            System.out.println("What type of user do you want to register? "
                    + "\n 1. User Consumer"
                    + "\n 2. User Producer"
                    + "\n 3. Back");
            switch (intAnswer()){
                case 1:
                    registerConsumer();
                    break;
                case 2:
                    registerProducer();
                    break;
                case 3:
                    menu();
                default:
                    System.out.println("Enter a valid option");
            }
    }

    /** Description:
     *       This method will take care of the creation of a consumer user, it will receive the information given by the user to create a new user
     */
    public void registerConsumer(){
        System.out.println("What type of user consumer do you want to register? "
                + "\n 1. Standard User"
                + "\n 2. Premium User"
                + "\n 3. Back");
        int selection = intAnswer();
        if(selection == 3){
            menu();
        } else {
            System.out.println("Please, enter the user's name");
            String name = sc.nextLine();
            System.out.println("Please, enter the user's personal ID");
            String id = sc.nextLine();
            if ( controller.registerUser(name, id, selection) ){
                System.out.println("The User was created successfully");
                menu();
            }
        }
    }

    /** Description:
     *          This method will handle the creation of a producer user, it will receive the information given by the user to create a new user.
     */
    public void registerProducer(){
        System.out.println("What type of user consumer do you want to register? "
                + "\n 1. Artist User"
                + "\n 2. Content creator User"
                + "\n 3. Back");
        int selection = intAnswer();
        if(selection == 3){
            menu();
        } else {
            System.out.println("Please, enter the user's name");
            String name = sc.nextLine();
            System.out.println("Please, enter the user's personal ID");
            String id = sc.nextLine();
            System.out.println("Please, enter the user's url photo");
            String url = sc.nextLine();
            if ( controller.registerUser(name, id, url, selection) ){
                System.out.println("The User was created successfully");
                menu();
            }
        }
    }

    /** Description:
     *          This method will help us to obtain an integer numerical answer.
     * @return intAnswer int: Integer answer
     */
    public int intAnswer(){
        while(true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Try to enter a numeric datum");
            }
        }
    }

    /** Description:
     *          This method will help us to obtain an Double  numerical answer.
     * @return doubleAnswer int: Double  answer
     */
    public double doubleAnswer(){
        while(true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Try to enter a numeric datum");
            }
        }
    }
}