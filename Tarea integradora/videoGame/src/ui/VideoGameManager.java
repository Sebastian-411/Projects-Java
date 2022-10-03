package ui;
import model.VideoGameController;

import java.util.Random;
import java.util.Scanner;

public class VideoGameManager {
    public static Scanner sc = new Scanner(System.in);
    public static VideoGameController videoController = new VideoGameController(0);
    public static Random rd = new Random();

    public static void main(String[] args) {
        menuQuality();
        createLevels();
        menu();

    }

    /** Description:
     *    in this method we are going to input the information that we need to set the video game's quality
     * Pre: nothing
     * Pos: nothing
     */
    private static void menuQuality(){
        boolean validation = true;
        while (validation) {
            System.out.println("Por favor ingrese la calidad que desea");
            for(int i = 0; i<videoController.amountQuality(); i ++){
                System.out.println("    "+(i+1) + "." + videoController.qualityTypes(i));
            }
            int answer = intAnswer();
            if(answer>videoController.amountQuality() || answer<=0){
                System.out.println("Esta ingresando una opcion invalida");
            } else {
                validation = false;
                videoController = new VideoGameController(answer-1);
                System.out.println("Calidad escogida con exito");
            }
        }
    }

    /** Description:
     *      In this method it will execute the levels that the game has
     *      pre: null
     *      pos: null
     */
    private static void createLevels(){
        double score = 0;
        boolean validation = true;
        for(int i = 1; videoController.validationLevels(); i++){
            score += rd.nextInt(100);
            validation = validation&& videoController.registerLevel(i, score);
        }
        if (validation){
            System.out.println("El videojuego se ha a cargado con exito");
        } else {
            System.out.println("Ha ocurrido un error al inicializar el videojuego");
            System.exit(0);
        }
    }

    /** Description:
     *     This is the principal menu, in this menu we can show the options users
     * Pre: nothing
     * Pos: nothing
     */
    private static void menu(){
        while(true) {
            System.out.println("1. Registrar un enemigo");
            System.out.println("2. Registrar un tesoro");
            System.out.println("3. Gestionar usuario");
            System.out.println("4. Gestionar niveles");
            System.out.println("5. Salir");
            switch (intAnswer()) {
                case 1:
                    registerEnemy();
                    break;
                case 2:
                    registerTreauser();
                    break;
                case 3:
                    menuPlayer();
                    break;
                case 4:
                    menuLevels();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ingrese una opcion disponible");
            }
        }
    }

    /** Description:
     *     This is the player manager menu, in this menu we can show the options users
     * Pre: nothing
     * Pos: nothing
     */
    private static void menuPlayer(){
        while(true) {
            System.out.println("1. Crear jugador");
            System.out.println("2. Incrementar el nivel del usuario");
            System.out.println("3. Modificar puntaje del usuario");
            System.out.println("4. Mejores 5 jugadores");
            System.out.println("5. Regresar al nivel original");
            switch (intAnswer()) {
                case 1:
                    registerPlayer();
                    break;
                case 2:
                    increaseLevel();
                    break;
                case 3:
                    modifyScore();
                case 4:
                    System.out.println(videoController.bestPlayer());
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("Ingrese una opcion disponible");
            }
        }
    }


    /** Description:
     *      In this method we are going to try increase the level of the player
     *  pre: nothing
     *  post: nothing
     */
    private static void modifyScore(){
        if (videoController.amountPlayerCreated() != 0){
            System.out.println("A que jugador le aumentara el puntaje?");
            for (int i = 0; i < videoController.amountPlayerCreated(); i++) {
                System.out.println((i + 1) + ". " + videoController.showPlayer(i) + ".");
            }
            int player = intAnswer();
            System.out.println("Cuanto puntos desea agregar?");
            double score = intAnswer();
            videoController.setNewScore(player-1, score);
            System.out.println("El puntaje ha sido cambiado con exito");
        } else {
            System.out.println("Registra jugadores!!!");
        }
        menuPlayer();
    }

    /** Description:
     *      In this method we are going to try increase the level of the player
     *  pre: nothing
     *  post: nothing
     */
    private static void increaseLevel(){
        if (videoController.amountPlayerCreated() != 0){
            System.out.println("A que jugador le aumentara el nivel?");
            for (int i = 0; i < videoController.amountPlayerCreated(); i++) {
                System.out.println((i + 1) + ". " + videoController.showPlayer(i) + ".");
            }
            int player = intAnswer();
            switch (videoController.incressLevel((player-1))){
                case 0:
                    System.out.println("Puntos insuficientes para pasar de nivel, el jugador necesita " + videoController.differentScorePlayerLevel(player-1) + " puntos");
                    break;
                case 1:
                    System.out.println("El jugador esta en el nivel maximo");
                    break;
                case 2:
                    System.out.println("El jugador ha pasado al siguiente nivel");
                    break;
                default:
                    System.out.println("Ha ocurrido un error");
            }
        } else {
            System.out.println("Registra jugadores!!!");
        }
        menuPlayer();
    }

    /** Description:
     *     This is the levels manager menu, in this menu we can show the options users
     * Pre: nothing
     * Pos: nothing
     */
    private static void menuLevels(){
        while(true) {
            System.out.println("Que opcion desea elegir?");
            System.out.println("1. Asignar enemigo a un nivel");
            System.out.println("2. Asignar tesoros a un nivel");
            System.out.println("3. Informe de un nivel sobre enemigos y tesoros");
            System.out.println("4. Conocer la cantidad de enemigos en un nivel");
            System.out.println("5. Conocer la cantidad de tesoros en un nivel");
            System.out.println("6. Tesoro mas repetido en los niveles");
            System.out.println("7. Enemigo que otorga mas puntos y en que niveles se ubica");
            System.out.println("8. Lista de los enemigos sin vocales");
            System.out.println("9. Volver al menu principal");
            switch (intAnswer()) {
                case 1:
                    assignEnemy();
                    break;
                case 2:
                    assignTreasure();
                    break;
                case 3:
                    showDetailsLevel();
                    break;
                case 4:
                    showEnemiesLevel();
                    break;
                case 5:
                    showTreasureLevel();
                    break;
                case 6:
                    System.out.println(videoController.mostRepeatedTreasure());
                    break;
                case 7:
                    System.out.println(videoController.getEnemyMaxScore());
                    break;
                case 8:
                    listEnemyWithoutVocals();
                    break;
                case 9:
                    menu();
                    break;
                default:
                    System.out.println("Ingrese una opcion disponible");
            }
        }
    }


    /** Description:
     *      In this method we're going to write an enemies without vocals

     */
    private static void listEnemyWithoutVocals() {
        if (videoController.amountEnemiesCreated() != 0){
            for (int i = 0; i < videoController.amountEnemiesCreated(); i++){
                System.out.println((i + 1) + ". " + videoController.enemiesWithoutVocals(videoController.showEnemy(i)));
            }
        }
    }

    /** Description:
     *      In this method we are going to do the process to show the details of a level
     *  pre: nothing
     *  pos: nothing
     */
    private static void showEnemiesLevel() {
        System.out.println("A que nivel quiere conocer los detalles?");
        for (int i = 0; i < videoController.amountLevel(); i++) {
            System.out.println((i + 1) + ". Level " + videoController.showLevel(i) + ".");
        }
        int level = intAnswer();
        System.out.println("En el nivel " + level + " hay " + videoController.getEnemiesToLevel(level-1) + " enemigos");
    }

    /** Description:
     *      In this method we are going to do the process to show the details of a level
     *  pre: nothing
     *  pos: nothing
     */
    private static void showTreasureLevel() {
        System.out.println("A que nivel quiere conocer los detalles?");
        for (int i = 0; i < videoController.amountLevel(); i++) {
            System.out.println((i + 1) + ". Level " + videoController.showLevel(i) + ".");
        }
        int level = intAnswer();
        System.out.println("En el nivel " + level + " hay " + videoController.getTreasureToLevel(level-1) + " tesoros");
    }

    /** Description:
     *      In this method we are going to do the process to show the details of a level
     *  pre: nothing
     *  pos: nothing
     */
    private static void showDetailsLevel() {
        System.out.println("A que nivel quiere conocer los detalles?");
        for (int i = 0; i < videoController.amountLevel(); i++) {
            System.out.println((i + 1) + ". Level " + videoController.showLevel(i) + ".");
        }
        System.out.println(videoController.getEnemiesTreasuresToLevel(intAnswer()-1));
    }

    /** Description:
     *      In this method we are going to do the process to assign the teasure to a level
     *  pre: nothing
     *  pos: nothing
     */
    private static void assignTreasure() {
        int a = 0;
        if (videoController.amountTreasureCreated() != 0) {
            System.out.println("A que nivel quiere asignarle tesoros?");
            for (int i = 0; i < videoController.amountLevel(); i++) {
                System.out.println((i + 1) + ". Level " + videoController.showLevel(i) + ".");
            }
            int level = intAnswer();
            System.out.println("Por favor seleccione el tesoro que desea agregar");
            for (int i = 0; i < videoController.amountTreasureCreated(); i++) {
                System.out.println((i+1) + ". " + videoController.showTreasure(i));
            }
            int treasure = intAnswer();
            System.out.println("Cuantos de estos tesoros quiere en este nivel?");
            int iteraciones = intAnswer();
            for (int i = 0; i < iteraciones; i++) {
                if (videoController.registerTreasureLevel(level - 1, treasure - 1, rd.nextInt(videoController.positionX()), rd.nextInt(videoController.positionY()))) {
                    a++;
                    if(i+1==iteraciones) {
                        System.out.println("Se ha agregado con exito " + (i+1) + " tesoros!" );
                        System.out.println(videoController.assignDifficult(level - 1));
                    }
                } else {
                    if(i+1==iteraciones) {
                        System.out.println("Error, ha ocurrido un error");
                    }
                    if(a!=0){
                        System.out.println("Pero, se han agregado " + a + " exitosamente:)");
                    }
                }
            }
        } else {
            System.out.println("Agrega tesoros!!");
        }
        menuLevels();
    }


    /** Description:
     *      In this method we are going to do the process to assign the enemy to a level
     *  pre: nothing
     *  pos: nothing
     */
    private static void assignEnemy() {
        if (videoController.amountEnemiesCreated() != 0) {
            System.out.println("A que nivel quiere asignarle enemigos?");
            for (int i = 0; i < videoController.amountLevel(); i++) {
                System.out.println((i + 1) + ". Level " + videoController.showLevel(i) + ".");
            }
            int level = intAnswer();
            System.out.println("Por favor seleccione el enemigo que desea agregar");
            for (int i = 0; i < videoController.amountEnemiesCreated(); i++) {
                System.out.println((i+1) + ". " + videoController.showEnemy(i));
            }
            int enemy = intAnswer();
            if ( videoController.registerEnemyLevel(level - 1, enemy-1, rd.nextInt(videoController.positionX()), rd.nextInt(videoController.positionY())) ){
                System.out.println("Se ha agregado con exito!");
                System.out.println(videoController.assignDifficult(level - 1));
            } else {
                System.out.println("Error, esta opcion no es valida");
            }
        } else {
            System.out.println("Agrega enemigos!!");
        }
        menuLevels();
    }


    /** Description:
     *    in this method we are going to input the information that we need to create a new user, and we use other method to do the validation before input the information
     * Pre: nothing
     * Pos: nothing
     */
    private static void registerPlayer(){
        if(videoController.validationPlayers()) {
            System.out.println("Usted ha seleccionado la opcion \" Crear un usuario \"" + "\n Por favor ingrese el apodo del jugador");
            String nickname = sc.nextLine();
            while(videoController.validationNicknamePlayer(nickname)){
                System.out.println("Este nickname ya fue elegido, vuelve a intentarlo");
                nickname = sc.nextLine();
            }
            System.out.println("Por favor ingrese el nombre del jugador");
            String name = sc.nextLine();
            double score = 10;
            int life = 5;
            if(videoController.registerPlayer(nickname, name, score, life, (0))){
                System.out.println("El jugador se ha registrado con exito");
            } else {
                System.out.println("Ha ocurrido un problema al registar el jugador, vuelve a intentarlo");
            }
        } else {
            System.out.println("Esta opcion no esta disponible por el momento:(");
        }
        menuPlayer();
    }

    /** Description:
     *    in this method we are going to input the information that we need to create a new enemy, and we use other method to do the validation before input the information
     * Pre: nothing
     * Pos: nothing
     */
    private static void registerEnemy(){
        boolean validation = true;
        int type = 0;
        if(videoController.validationEnemies()) {
            System.out.println("Usted ha seleccionado la opcion \" Registrar un enemigo \"" + "\n Por favor ingrese el nombre del enemigo");
            String name = sc.nextLine();
            while(videoController.validationNameEnemy(name)){
                System.out.println("Este nombre ya fue elegido, vuelve a intentarlo");
                name = sc.nextLine();
            }
            System.out.println("Por favor ingrese el tipo del enemigo");
            for(int i = 0; i<videoController.amountEmemies(); i ++){
                System.out.println((i+1) +". " + ((videoController.enemiesTypes(i).toString()).toLowerCase()));
            }
            while(validation) {
                type = intAnswer();
                if (type > videoController.amountEmemies() || type <= 0) {
                    System.out.println("Esta ingresando una opcion invalida");
                } else {
                    validation = false;
                    System.out.println("Tipo de enemigo elegido con exito");
                }
            }
            System.out.println("Ingrese el daño que hace el enemigo");
            double damage = doubleAnswer();
            System.out.println("Ingrese el puntaje que otorga el enemigo");
            double score = doubleAnswer();
            if(videoController.registerEnemy(name, damage, score, (type-1))){
                System.out.println("El enemigo se ha registrado con exito");
                menu();
            } else{
                System.out.println("Ha ocurrido un problema al registar el enemigo, vuelve a intentarlo");
            }
        } else {
            System.out.println("Esta opcion no esta disponible por el momento:(");
        }
    }

    /** Description:
     *    in this method we are going to input the information that we need to create a new treasure, and we use other method to do the validation before input the information
     * Pre: nothing
     * Pos: nothing
     */
    private static void registerTreauser(){
        if (videoController.validationTreasures()){
            System.out.println("Por favor ingresa el nombre del tesoro");
            String name = sc.nextLine();
            while(videoController.validationNameTreasure(name)){
                System.out.println("Este nombre ya fue elegido, vuelve a intentarlo");
                name = sc.nextLine();
            }
            System.out.println("Por favor ingresa la url de la imagen");
            String url = sc.nextLine();
            System.out.println("Ingrese los puntos le otorga al jugador al obtenerlo");
            double score = doubleAnswer();
            if(videoController.registerTreasure(name, url, score)){
                System.out.println("El tesoro fue creado correctamente");
            } else {
                System.out.println("El tesoro no se ha creado");
            }
        } else {
            System.out.println("En este momento esa opcion no esta disponible");
        }
        menu();
    }


    /** Description:
     This is method helps to validate the answer to the user, The motive to this method is for when we use the class “scanner”, we have to clear the console, and this make that the code don't look well.     \
     * Pre: nothing
     * Pos: nothing
     * @return int: This is method will return the answer of the user with a cast to number.
     */
    private static int intAnswer(){
        while (true){
            try{
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e){
                System.out.println("Ingresa un numero natural:)");
            }
        }
    }

    /** Description:
     This is method helps to validate the answer to the user, The motive to this method is for when we use the class “scanner”, we have to clear the console, and this make that the code don't look well.
     * Pre: nothing
     * Pos: nothing
     * @return double: This is method will return the answer of the user with a cast to number.
     */
    private static Double doubleAnswer(){
        while (true){
            try{
                return Double.valueOf(sc.nextLine());
            } catch (Exception e){
                System.out.println("Ingresa un numero :)");
            }
        }
    }
}
