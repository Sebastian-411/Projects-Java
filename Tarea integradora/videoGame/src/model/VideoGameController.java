package model;

public class VideoGameController {
    private Quality quality;
    private Player[] players = new Player[20];
    private Treasure[] treasures = new Treasure[50];
    private Treasure[] treasuresAssign = new Treasure[50];
    private Enemy[] enemies = new Enemy[25];
    private Enemy[] enemiesAssign = new Enemy[25];
    private Level[] levels = new Level[10];

    public Player[] getPlayers() {
        return players;
    }

    public VideoGameController(int i) {
        this.quality = quality.values()[i];
    }

    //Gets and setters

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public Level[] getLevels() {
        return levels;
    }

    public void setLevels(Level[] levels) {
        this.levels = levels;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    // Storage validation

    /**
     * Description:
     * in this method we are going to check the storage that have the array to save more information
     * Pre: nothing
     * Pos: nothing
     *
     * @return boolean: this is going to tell to us if the array has storage to save more information
     */
    public boolean validationPlayers() {
        for (int i = 0; i < players.length; i++){
            if ( players[i] == null ){
                return true;
            }
        }
        return false;
    }


    /**
     * Description:
     * in this method we are going to check the nickname that have the array to dont save information double.
     * Pre: nothing
     * Pos: nothing
     *
     * @return boolean: this is going to tell us if the array has storage to save more information
     */
    public boolean validationNicknamePlayer(String nickname) {
        for (int i = 0; i < players.length; i++){
            if ( players[i] != null ){
                if ( players[i].getNickName().equals(nickname) ){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Description:
     * in this method we are going to check the nickname that have the array to dont save information double.
     * Pre: nothing
     * Pos: nothing
     *
     * @return boolean: this is going to tell us if the array has storage to save more information
     */
    public boolean validationNameEnemy(String name) {
        for (int i = 0; i < enemies.length; i++){
            if ( enemies[i] != null ){
                if ( enemies[i].getName().equals(name) ){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Description:
     * in this method we are going to check the nickname that have the array to dont save information double.
     * Pre: nothing
     * Pos: nothing
     *
     * @return boolean: this is going to tell us if the array has storage to save more information
     */
    public boolean validationNameTreasure(String name) {
        for (int i = 0; i < treasures.length; i++){
            if ( treasures[i] != null ){
                if ( treasures[i].getName().equals(name) ){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Description:
     * in this method we are going to check the storage that have the array to save more information
     * Pre: nothing
     * Pos: nothing
     *
     * @return boolean: this is going to tell to us if the array has storage to save more information
     */
    public boolean validationTreasures() {
        for (int i = 0; i < treasures.length; i++){
            if ( treasures[i] == null ){
                return true;
            }
        }
        return false;
    }

    /**
     * Description:
     * in this method we are going to check the storage that have the array to save more information
     * Pre: nothing
     * Pos: nothing
     *
     * @return boolean: this is going to tell to us if the array has storage to save more information
     */
    public boolean validationEnemies() {
        for (int i = 0; i < enemies.length; i++){
            if ( enemies[i] == null ){
                return true;
            }
        }
        return false;
    }

    /**
     * Description:
     * in this method we are going to check the storage that have the array to save more information
     * Pre: nothing
     * Pos: nothing
     *
     * @return boolean: this is going to tell to us if the array has storage to save more information
     */
    public boolean validationLevels() {
        for (int i = 0; i < levels.length; i++){
            if ( levels[i] == null ){
                return true;
            }
        }
        return false;
    }


    // Register information

    /**
     * Description:
     * in this method we are going to process the given data for the user to register in the software.
     * Pre: nothing
     * Pos: nothing
     *
     * @param nickname String: is the nickname of the player in the game
     * @param name     String: is the player's real name
     * @param score    double: it is the score the user has, the user begin to play with 10 points
     * @param life     int:  it is the lives the user has, the user begin to play with 5 lives
     * @param level    int: its the level initial
     * @return boolean: this is going to tell us if the player was register in the software
     */
    public boolean registerPlayer(String nickname, String name, double score, int life, int level) {
        Player player = new Player(nickname, name, score, life, levels[level]);
        for (int i = 0; i < players.length; i++){
            if ( players[i] == null ){
                players[i] = player;
                return true;
            }
        }
        return false;
    }

    /**
     * Description:
     * in this method we are going to process the given data for the user to register an ememy in the software.
     * Pre: nothing
     * Pos: nothing
     *
     * @param name   String: this is going to be the id to the enemy
     * @param damage double: this is the damage that the enemy will make to the user
     * @param score  double: this is the score given for the enemy to the user if the user finished with the enemy
     * @param id     int: This is the number of the type of the enemy
     * @return
     */
    public boolean registerEnemy(String name, double damage, double score, int id) {
        Enemy enemy = new Enemy(name, damage, score, enemiesTypes(id));
        for (int i = 0; i < enemies.length; i++){
            if ( enemies[i] == null ){
                enemies[i] = enemy;
                return true;
            }
        }
        return false;
    }


    /**
     * Description:
     * in this method we are going to process the given data for the user to register an treasure in the software.
     * Pre: nothing
     * Pos: nothing
     *
     * @param name  String: this will be the name or id of the treasure
     * @param url   String: this is the URL of the image treasure
     * @param score double: this is the score that give to the user
     * @return
     */
    public boolean registerTreasure(String name, String url, double score) {
        Treasure treasure = new Treasure(name, url, score);
        for (int i = 0; i < treasures.length; i++){
            if ( treasures[i] == null ){
                treasures[i] = treasure;
                return true;
            }
        }
        return false;
    }

    /**
     * Description:
     * in this method, we are going to process the given data for the user to register in the software.
     *
     * @param idLevel String: this going to be the ID which will identified the level
     * @param score   int: this variable will be the score necessary to access the level create
     * @return boolean: this is going to tell us if the level was created without error or if the level was created with successful
     */
    public boolean registerLevel(int idLevel, double score) {
        Level level = new Level(idLevel, score);
        for (int i = 0; i < levels.length; i++){
            if ( levels[i] == null ){
                levels[i] = level;
                return true;
            }
        }
        return false;
    }

    /**
     * Description:
     * in this method, we are going to process the given data for the user to change in the software.
     *
     * @param player String: this going to be the ID which will identified the player
     * @param score  int: this variable will be the score necessary to set to the player
     * @return boolean: this is going to tell us if the level was modify without error
     */
    public void setNewScore(int player, double score) {
        players[player].setScore(score);
    }


    /**
     * Description:
     * In this method we are going to check the values of the class enum, using the method ".values()"
     *
     * @param i int: the number that we going to check
     * @return TypesEnemies: return the type of enemies that the software has
     */
    public TypesEnemies enemiesTypes(int i) {
        return TypesEnemies.values()[i];
    }

    /**
     * Description:
     * In this method we are going to check the values of the class enum, using the method ".values()"
     *
     * @param i int: the number that we going to check
     * @return TypesEnemies: return the type of quality that the software has
     */
    public String qualityTypes(int i) {
        return Quality.values()[i].toString();
    }


    /**
     * Description:
     * In this method we are checking the number of enum that has the class for control for and whiles
     *
     * @return int: number of the types
     */
    public int amountEmemies() {
        return TypesEnemies.values().length;
    }

    /**
     * Description:
     * In this method we are checking the number of enum that has the class for control for and whiles
     *
     * @return int: number of the types
     */
    public int amountQuality() {
        return Quality.values().length;
    }

    /**
     * Description:
     * In this method we are showing the values of the array that has enemy
     *
     * @return String: the values of the enemy
     */
    public String showEnemy(int i) {
        return enemies[i].getName() + " Tipo: " + enemies[i].getTypesEnemies();
    }


    /**
     * Description:
     * In this method we are showing the values of the array that has treasure
     *
     * @return String: the values of the treasure
     */
    public String showTreasure(int i) {
        return treasures[i].getName() + " Score: " + treasures[i].getScore();
    }

    /**
     * Description:
     * In this method we are showing the values of the array that has level
     *
     * @return String: the values of the level
     */
    public int showLevel(int i) {
        return levels[i].getIdLevel();
    }

    /**
     * Description:
     * In this method we are showing the values of the array that has players
     *
     * @return String: the values of the level
     */
    public String showPlayer(int i) {
        return players[i].getNickName() + " nivel: " + players[i].getLevel().getIdLevel();
    }


    /**
     * Description:
     * In this method we are checking the number of spaces in tthe array that has level for control for and whiles
     *
     * @return int: number of the spaces
     */
    public int amountLevel() {
        return levels.length;
    }

    /**
     * Description:
     * In this method we are checking the number of spaces in tthe array that has enemies for control for and whiles
     *
     * @return int: number of the spaces
     */
    public int amountEnemiesCreated() {
        int a = 0;
        for (int i = 0; i < enemies.length; i++){
            if ( enemies[i] != null ){
                a++;
            }
        }
        return a;
    }

    /**
     * Description:
     * In this method we are checking the number of spaces in tthe array that has treasure for control for and whiles
     *
     * @return int: number of the spaces
     */
    public int amountTreasureCreated() {
        int a = 0;
        for (int i = 0; i < treasures.length; i++){
            if ( treasures[i] != null ){
                a++;
            }
        }
        return a;
    }

    /**
     * Description:
     * In this method we are checking the number of spaces in tthe array that has players for control for and whiles
     *
     * @return int: number of the spaces
     */
    public int amountPlayerCreated() {
        int a = 0;
        for (int i = 0; i < players.length; i++){
            if ( players[i] != null ){
                a++;
            }
        }
        return a;
    }

    /**
     * Description:
     * In this method we are going to make a operations necesary for register a enemy in a level
     *
     * @param level int: its the level that will be manage
     * @param enemy int: its the enemy that we are going to Assign
     * @return bolean: this can help to know the status of the register.
     */
    public boolean registerEnemyLevel(int level, int enemy, int x, int y) {
        if ( !levels[level].searchEnemy(enemies[enemy]) ){
            if ( enemies[enemy] != null ){
                for (int i = 0; i < enemiesAssign.length; i++){
                    if ( enemiesAssign[i] == null ){
                        enemiesAssign[(i)] = enemies[enemy];
                        return levels[level].addEnemy(enemies[enemy], x, y);
                    }
                }

            }
        }
        return false;
    }

    /**
     * Description:
     * In this method we are going to make a operations necesary for register a treasure in a level
     *
     * @param level    int: its the level that will be manage
     * @param treasure int: its the treasure that we are going to Assign
     * @return boolean: this can help to know the status of the register.
     */
    public boolean registerTreasureLevel(int level, int treasure, int x, int y) {

        if ( treasures[treasure] != null ){
            for (int i = 0; i < treasuresAssign.length; i++){
                if ( treasuresAssign[i] == null ){
                    treasuresAssign[(i)] = treasures[treasure];
                    return levels[level].addTreasure(treasures[treasure], x, y);
                }
            }
        }
        return false;
    }

    /**
     * Description:
     * This is a method that can help us to set the difficult of the level
     *
     * @param level int: its the number of the level that we're gonna make the assign
     * @return String: this method will return the difficult
     */
    public String assignDifficult(int level) {
        double pointsEnemies = levels[level].valuePointsEnemy();
        double pointsTreasure = levels[level].valuePointsTreausure();
        switch ((pointsTreasure > pointsEnemies) ? 1 : (pointsTreasure < pointsEnemies) ? 2 : pointsTreasure == pointsEnemies ? 3 : 4) {
            case 1:
                levels[level].setDifficultLevel(DifficultLevel.values()[0]);
                return "El nivel ha sido asignado como " + DifficultLevel.values()[0].toString().toLowerCase();
            case 2:
                levels[level].setDifficultLevel(DifficultLevel.values()[2]);
                return "El nivel ha sido asignado como " + DifficultLevel.values()[2].toString().toLowerCase();
            case 3:
                levels[level].setDifficultLevel(DifficultLevel.values()[1]);
                return "El nivel ha sido asignado como " + DifficultLevel.values()[1].toString().toLowerCase();
            default:
                return "Ha ocurrido un error al asignar el nivel";

        }
    }

    /**
     * Description:
     * This is a method that can help us to set the level of the player
     *
     * @return int: this method will return a int that can help us make a different process
     */
    public int incressLevel(int player) {
        if ( (players[player].getLevel().getIdLevel() != 10) ){
            if ( players[player].getScore() >= players[player].getLevel().getScore() ){
                players[player].setLevel(levels[(players[player].getLevel().getIdLevel()) + 1]);
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
    }

    /**
     * Description:
     * This is a method that can help us to get details to level
     *
     * @return String: this method will return a details
     */
    public String getEnemiesTreasuresToLevel(int level) {
        return levels[level].getEnemiesTreasuresToLevel();
    }

    /**
     * Description:
     * This is a method that can help us to get the amount of the enemies in a level
     *
     * @return int: this method will return a details
     */
    public int getEnemiesToLevel(int level) {
        return levels[level].amountEnemies();
    }

    /**
     * Description:
     * This is a method that can help us to get the amount of the treasure in a level
     *
     * @return int: this method will return a details
     */
    public int getTreasureToLevel(int level) {
        return levels[level].amountTreasure();
    }


    /**
     * Description:
     * This is a method that can help us to set the level of the player
     *
     * @return int: this method will return a int that can help us make a different process
     */
    public double differentScorePlayerLevel(int player) {
        return levels[(players[player].getLevel().getIdLevel()) + 1].getScore() - players[player].getScore();
    }

    /**
     * description:
     * This method can help us to control the places of the characters (enemies, treasure)
     *
     * @return int: max position X
     */
    public int positionX() {
        return quality.getPositionX();
    }


    /**
     * description:
     * This method can help us to control the places of the characters (enemies, treasure)
     *
     * @return int: max position Y
     */
    public int positionY() {
        return quality.getPositionY();
    }

    /**
     * description:
     * This method can help us to get the amount repeat of the treasures
     *
     * @return int: amount repeat
     */
    public int getAmountTreasureRepeat() {
        for (int i = 0; i < amountTreasureCreated(); i++){

        }
        return 0;
    }

    /**
     * description:
     * This method can help us to get the enemy with more score
     *
     * @return int: amount repeat
     */
    public String getEnemyMaxScore() {
        int a = 0;
        String message = " En el nivel";
        Enemy enemy;
        if ( enemiesAssign[0] == null ){
            return "Registra enemigos a los niveles !";
        } else {
            enemy = enemiesAssign[0];
        }
        for (int i = 1; i < enemies.length; i++){
            if ( enemiesAssign[i] != null ){
                if ( enemiesAssign[i].getScore() >= enemy.getScore() ){
                    enemy = enemiesAssign[i];
                }
            }
        }
        for (int i = 0; i < levels.length; i++){
            if ( levels[i].searchEnemy(enemy) ){
                a++;
                message += ", " + levels[i].getIdLevel();
            }
        }
        return "El enemigo que mas puntos otorga es: " + enemy.getName() + message;
    }


    /**
     * Description:
     * In this method we're going to write a word without vocals
     *
     * @param word String; word
     * @return String: word without vocals
     */
    public String enemiesWithoutVocals(String word) {
        String finalWord = "";
        char letter;
        for (int i = 0; i < word.length(); i++){
            letter = word.charAt(i);
            if ( !('a' == letter || 'e' == letter || 'i' == letter || 'o' == letter || 'u' == letter) ){
                finalWord += letter;
            }
        }
        return finalWord;
    }


    /**
     * Description:
     * In this method we are going to find the most repeated treasure
     *
     * @return String: The treasure most repeated
     */
    public String mostRepeatedTreasure() {
        Treasure treasure = treasuresAssign[0];
        int c = 0;
        int a = 0;
        if ( treasuresAssign[0] != null ){
            for (int i = 0; i < treasuresAssign.length; i++){
                c = 0;
                if ( treasures[i] != null ){
                    for (int b = 0; b < treasuresAssign.length; b++){
                        if ( treasuresAssign[b] != null ){
                            if ( (treasures[i].getName()).equals(treasuresAssign[b].getName()) ){
                                c++;
                            }
                        }
                    }
                    if ( c > a ){
                        a = c;
                        treasure = treasures[(i)];
                    }
                }

            }
            return "Tesoro mas repetido: " + treasure.getName();
        }
        return "Asigna tesoros!";
    }


    /**
     * Description:
     * In this method we are going to find five players with most scores
     *
     * @return String: five players with most scores
     */
    public String bestPlayer() {
        String msg = "";
        Player[] best = new Player[5];
        if(amountPlayerCreated()!=0){
            for (int x = 0; x < best.length; x++){
                for (int i = 0; i < amountPlayerCreated(); i++){
                    if ( !(players[i].equals(best[0]) || players[i].equals(best[1]) || players[i].equals(best[2]) || players[i].equals(best[3]) || players[i].equals(best[4])) ){
                        if (best[x] == null){
                            best[x] = players[i];
                        } else {
                            if ( players[i].getScore() > best[x].getScore() ){
                                best[x] = players[i];
                            }
                        }
                    }
                }
            }
        } else {
            return "Registra jugadores!";
        }
        for (int x = 0; x<best.length; x++){
            if(best[x]!=null){
                msg += "\n " + (x + 1) + ". " + best[x].getNickName();
            }
        }
        return msg;
    }
}
