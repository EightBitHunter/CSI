//This program is an escape room! It is a text based adventure game that the player has to navigate by interacting with the puzzles in the room in the right order. There will be
//different things that go on, but they will be documented as they come up.

import java.util.Scanner;
import java.util.Random;
public class Main {
    //creating all the things that will traverse through each different method (action)
    //Some of these are to create checks if the player has certain objectives completed, ans some of these are for if a player repeats a room
    //Each will be explained when implemented
    static Random random = new Random();
    static Scanner input = new Scanner(System.in);
    static int deathChance = 10;
    static int playerChoice;
    static boolean electricity;
    static boolean firstTime;
    static boolean mainRoomRepeatedTime;
    static boolean shapeRepeatedTime;
    static boolean directionalOneDone;
    static boolean heptagonalPrismDone;
    static boolean directionalTwoDone;
    static boolean tryAgain;
    static boolean entryOne;
    static boolean entryTwo;
    static boolean entryThree;
    static boolean entryFour;
    static boolean entryFive;
    static boolean entrySix;
    static boolean goBack;
    static boolean cubeDone;
    static boolean hasKey = false;
    static boolean firstJournal = true;

    public static void main(String[] args) {
        //main menu/start screen
        System.out.println("Hello player! Welcome to \"The Shape Shift\"!");
        //This ascii art was found on https://www.asciiart.eu/miscellaneous/keys
        System.out.println(" ooo,    .---.\n" +
                " o`  o   /    |\\________________\n" +
                "o`   'oooo()  | ________   _   _)\n" +
                "`oo   o` \\    |/        | | | |\n" +
                "  `ooo'   `---'         \"-\" |_|");
        System.out.println("This is an escape room where you try and battle the puzzles with your wit!\nThe goal is to escape the room, and if you jiggle the door handle unsuccessfully, then the room will have an escalating chance to flood with water and you will have to start over once it does. You will have access to a journal, which you can access when you start the game by typing 0.\nTo start type in the the number 1, or to end type in the number 2!");
        startingChoice();
    }
    public static void startingChoice(){
        // takes the players choice and then starts the program
        playerChoice = input.nextInt();
        firstTime = true;
        switch (playerChoice){
            case 1:
                mainRoom();
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Please type either the number 1 or 2 in the box please!");
                startingChoice();
        }
    }
    public static void mainRoom(){
        //Checks if this is the players first time in the room, and if so gives them an introduction
        if(firstTime){
            System.out.println("\nYou wake up in a new room unfamiliar with your surroundings. You slowly wake up and notice a couple of oddities around the room. There are some words written on your arm in pen, but you have to focus to read them out.\nIn front of you are three things that draw your attention. There is a directional pad on the floor to your left, a pedestal with 5 three dimensional shapes behind it straight ahead, and a safe with a combination lock on it on the far right corner of the room.");
            System.out.println("There is a door to the right of you, and you notice the room is decorated lavishly with old paintings, dressers, cabinets, and a grandfather clock.");
            System.out.println("Type 0 to open the journal, type 1 to inspect the writing on your arm, type 2 to interact with the directional pad on the left, type 3 to interact with the pedestal, type 4 to interact with the combination lock, or type 5 to try to open the door.");
            playerChoice = input.nextInt();
        }else if (tryAgain){ // This is to check for if they player is trying to input a correct response down below
            playerChoice = input.nextInt();
        }else if (mainRoomRepeatedTime){ // this is for if you come back to the main room anytime after your first time
            System.out.println("You are in the main room. Type 0 to open the journal, type 1 to inspect the writing on your arm, type 2 to interact with the directional pad on the left, type 3 to interact with the pedestal, type 4 to interact with the combination lock, or type 5 to try to open the door.");
        }
        //sets up that the player has been here for the first time, they no longer are trying again, and the check for if they come back is now true
        firstTime = false;
        tryAgain = false;
        mainRoomRepeatedTime = true;
        switch (playerChoice){// player choice now, takes them to the next method and starts the main obj
            case 0:
                journal();
                break;
            case 1:
                inspectArm();
                break;
            case 2:
                dPad();
                break;
            case 3:
                shapePedestal();
                break;
            case 4:
                lock();
                break;
            case 5:
                tryDoor();
                break;
            default:
                System.out.println("Please enter one of these options {0 Journal, 1 Inspect writing, 2 Directional pad, 3 Shape pedestal, 4 combination lock, or 5 Door handle}");
                tryAgain = true;// this is soley so they can input another answer quickly
                mainRoom();
        }
    }
    public static void journal(){
        if (firstJournal){// this only prints if they have just opened the journal
            System.out.println("Welcome to the journal. You can re-read hints from earlier on. Type in 1 for journal entry one, 2 for journal entry 2, 3, 4, or 5 respectively. Type 0 to go back to the main selection screen.");
            firstJournal = false;
        }
        playerChoice = input.nextInt();//placed this here so that the program can relaunch the journal choice prompt without needing the text. Faster to run this way
        switch (playerChoice){
            case 0:
                firstJournal = true;//sets this to true so that when they come back it opens starting text
                mainRoom();
                break;
            case 1:
                if(entryOne){//Code here is repeated. Same type of check for if they have the journal entry unlocked.
                    System.out.println("The journal entry states,\" Four your first challenge, adorn the pedestal with shapes\".");
                } else {
                    System.out.println("You do not have this hint unlocked yet.");
                }
                System.out.println("Type in 1 for journal entry one, 2 for journal entry 2, 3, 4, or 5 respectively. Type 0 to go back to the main selection screen.");
                journal();
                break;
            case 2:
                if(entryTwo){
                    System.out.println("After you placed the cube on the table, a black light turned on and a code on the cube appeared. It had directional arrows that went up, up, blank, blank, left, right, left, right. The clock chimed 3 times, and the directional pad started to hum with electricity.");
                } else {
                    System.out.println("You do not have this hint unlocked yet.");
                }
                System.out.println("Type in 1 for journal entry one, 2 for journal entry 2, 3, 4, or 5 respectively. Type 0 to go back to the main selection screen.");
                journal();
                break;
            case 3:
                if(entryThree){
                    System.out.println("After inputing the correct code from the cube puzzle, a painting fell off the wall and 5 candles in front of it lit up in the shape of a pentagon. The lights turned back on afterwards and the black light was turned off.");
                } else {
                    System.out.println("You do not have this hint unlocked yet.");
                }
                System.out.println("Type in 1 for journal entry one, 2 for journal entry 2, 3, 4, or 5 respectively. Type 0 to go back to the main selection screen.");
                journal();
                break;
            case 4:
                if(entryFour){
                    System.out.println("\"The 7 sins are the folley of man.\nLooking down is pride on those who lied,\nLooking right is envy with wishes aplenty,\nLooking up is wrath on the bloody path,\nLooking left is sloth covered in tatterd cloth,\nLooking right is greed never wanting to conceed,\nLooking up is lust with desires unjust,\nAnd looking down is gluttony gnashing his teeth sullenly.\"\nThe clock chimes 8 times and the directional pad hums with electricity.");
                } else {
                    System.out.println("You do not have this hint unlocked yet.");
                }
                System.out.println("Type in 1 for journal entry one, 2 for journal entry 2, 3, 4, or 5 respectively. Type 0 to go back to the main selection screen.");
                journal();
                break;
            case 5:
                if(entryFive){
                    System.out.println("After you input the correct code from the pentagon puzzle you saw that a black light turned on again while the lights stayed on.\nYou noticed that the number 7 was now visible in the middle of the pentagram.");
                } else {
                    System.out.println("You do not have this hint unlocked yet.");
                }
                System.out.println("Type in 1 for journal entry one, 2 for journal entry 2, 3, 4, or 5 respectively. Type 0 to go back to the main selection screen.");
                journal();
                break;
            case 6:
                if(entrySix){
                    System.out.println("After placing the heptagonal prism on the pedestal, a cupboard opened with ink that wrote,\"The chimes of the clock open the lock.\"The clock chimed 7 times.");
                } else {
                    System.out.println("You do not have this hint unlocked yet.");
                }
                System.out.println("Type in 1 for journal entry one, 2 for journal entry 2, 3, 4, or 5 respectively. Type 0 to go back to the main selection screen.");
                journal();
                break;
            default:
                System.out.println("Please enter one of these options {0 Main Room, 1 Entry one, 2 Entry two, 3 Entry three, 4 Entry four, or 5 Entry five}");
                journal();
        }
    }
    public static void inspectArm(){
        if (entryOne){
            System.out.println("You already have recorded this in your journal.");
            mainRoom();
        }else{
            System.out.println("\nYou read the pen marks on your arm and they read to say,\" Four your first challenge, adorn the pedestal with shapes\".\nYou noted this in your journal as entry 1.");
            entryOne = true;
        }
    }
    public static void dPad(){
        if (electricity){
            System.out.println("You approach the directional pad on the ground, and it hums with electricity. It has four options, up, right, down, and left.");
            
        }else{
            System.out.println("You approach the directional pad on the ground. It has four options, up, right, down, and left. Type 1 to press up, type 2 to press right, type 3 to press down, type 4 to press left, and type 0 to go back to the main room.");
            playerChoice = input.nextInt();
            if(playerChoice == 1 || playerChoice == 2 || playerChoice == 3 || playerChoice == 4){
                System.out.println("You press on the pad, but it does nothing. You step away wondering if you should come back later...");
                dPad();
            }else if(playerChoice == 0){
                System.out.println("You decide to step away from the pad for now and go back to the main room.");
                mainRoom();
            }else{
                System.out.println("*Incorrect input. Please input a number 0-4.*")
            }
        }
    }
    public static void shapePedestal(){
        if (shapeRepatedTime){
            System.out.println("Type 1 to place the triangular prism, type 2 to place the cube, type 3 to place the pentagonal prism, type 4 to place the hexagonal prism, type 5 to place the heptagonal prism, and type 0 to go back to the main room.")
        }else{
            System.out.println("You approach the shape pedestal again. There are 5 different three dimensional shapes to choose from. Type 1 to place the triangular prism, type 2 to place the cube, type 3 to place the pentagonal prism, type 4 to place the hexagonal prism, type 5 to place the heptagonal prism, and type 0 to go back to the main room.");
        }
        shapeRepeatedTime = true;
        playerChoice = input.nextInt();
        switch (playerChoice){
            case 0:
                shapeRepeatedTime = false;
                mainRoom();
                break;
            case 1:
                System.out.println("You place the triangular prism on the pedestal. You hear a dull click and nothing happens. You take the triangular prism and place it back with the other shapes.");
                shapePedestal();
                break;
            case 2:
                if(cubeDone){
                    System.out.println("You place the cube back onto the pedestal. You hear a dull click and nothing happens. You take the cube and place it back with the other shapes.");
                    shapePedestal();
                } else {
                    System.out.println("You place the cube onto the pedestal. A swtich activates, the room lights turn off, and a black light turns on. The black light shines onto the cube and it now shows the code \"up, up, ____, ____, left, right, left, right.\"\nThe clock chimes 3 times and the hum of electricity can be heard from the directional pad now. You write this in your jounral as entry two.\nYou remove the cube and place it back with the other shapes.");
                    electricity = true;
                    entryTwo = true;
                    cubeDone = true;
                    System.out.println("You take a step back into the main room.");
                    mainRoom();
                }
                break;
            case 3:
                if(pentagonalPrismDone || !directionalOneDone){
                    System.out.println("You place the pentagonal prism back onto the pedestal. You hear a dull click and nothing happens. You take the pentagonal prism and place it back with the other shapes.");
                    shapePedestal();
                } else if (directionalOneDone){
                    System.out.println("You place the pentagonal prism onto the pedestal. A switch activates inside the shape and the top opens up. Inside there is a note and it reads,\"The 7 sins are the folley of man.\nLooking down is pride on those who lied,\nLooking right is envy with wishes aplenty,\nLooking up is wrath on the bloody path,\nLooking left is sloth covered in tatterd cloth,\nLooking right is greed never wanting to conceed,\nLooking up is lust with desires unjust,\nAnd looking down is gluttony gnashing his teeth sullenly.\"\nThe clock chimes 8 times and the directional pad hums with electricity again.\"\nYou remove the pentagonal prism and place it back with the other shapes.");
                    electricity = true;
                    entryFour = true;
                    pentagonalPrismDone = true;
                    System.out.println("You take a step back into the main room.");
                    mainRoom();
                }
                break;
            case 4:
                System.out.println("You place the hexagonal prism on the pedestal. You hear a dull click and nothing happens. You take the hexagonal prism and place it back with the other shapes.");
                shapePedestal();
                break;
            case 5:
                if(heptagonalPrismDone || !directionalTwoDone){
                    System.out.println("You place the heptagonal prism back onto the pedestal. You hear a dull click and nothing happens. You take the heptagonal prism and place it back with the other shapes.");
                    shapePedestal();
                } else if (directionalTwoDone){
                    System.out.println("You place the heptagonal prism onto the pedestal. There is a loud switch that activates and a drawer underneath the pedestal opens up. You look inside the drawer and see that on the inside written in ink are the words,\"The chimes of the clock open the lock.\"\nYou take the heptagonal prism of the pedestal and place it with the other shapes.");
                    entrySix = true;
                    heptagonalPrismDone = true;
                    System.out.println("You take a step back into the main room.");
                    mainRoom();
                }
                break;
            default:
                System.out.println("*Incorrect input. Please enter a number 0-5.*");
                shapePedestal();
        }
    }
    public static void lock(){
        int lockOne;
        int lockTwo;
        int lockThree;
        System.out.println("You approach the lock to the safe. It is a scrolling number lock with inputs of 0-9 in the sequence X-X-X. Type 1 to enter a sequence into the lock, and type 2 to go back into the main area.");
        playerChoice = input.nextInt();
        switch (playerChoice){
            case 1:
                System.out.println("Please input your sequence of characters one at a time. Type your first number now:");
                lockOne = input.nextInt();
                System.out.println("Type your second number now:");
                lockTwo = input.nextInt();
                System.out.println("Type your third number now:");
                lockThree = input.nextInt();
                if(lockOne == 3 && lockTwo == 8 && lockThree == 7){
                    System.out.println("You have input the correct code and the lock opens with a click. You open the safe and find a lone key inside.")
                    hasKey = true;
                    System.out.println("You take a step back and have the key in your hand now.");
                    mainRoom();
                }else{
                    System.out.println("The lock stays shut and doesnt budge. You take a step back and contemplate what the numbers could be.");
                    lock();
                }
                break;
            case 2:
                mainRoom();
                break;
            default:
                System.out.println("Please input either 1 or 2 into the box.");
                lock();
                break;
        }
    }
    public static void tryDoor(){
        if(hasKey){
            System.out.println("You used the key you picked up from the safe to unlock the door. You have escaped!!! Congrats on winning the game.");
            //This ascii art was found on https://www.asciiart.eu/holiday-and-events/fireworks
            System.out.println("              *    *\n" +
            "   *         '       *       .  *   '     .           * *\n" +
                    "                                                             '\n" +
                    "     *                *'          *          *        '\n" +
                    "   .          *               |               /\n" +
                    "              '.         |    |      '       |   '     *\n" +
                    "                 |*        |   |             /\n" +
                    "       '          |     '* |    |  *        |*                *  *\n" +
                    "            *      `.       |   |     *     /    *      '\n" +
                    "  .                  |      |   |          /               *\n" +
                    "     *'  *     '      |      |   '.       |\n" +
                    "        -._            `                  /         *\n" +
                    "  ' '      ``._   *                           '          .      '\n" +
                    "   *           **          * .   .      *\n" +
                    "  '        *    `-._                       .         _..:='        *\n" +
                    "             .  '      *       *    *   .       _.:--'\n" +
                    "          *           .     .     *         .-'         *\n" +
                    "   .               '             . '   *           *         .\n" +
                    "  *       ___.-=--..-._     *                '               '\n" +
                    "                                  *       *\n" +
                    "                *        _.'  .'       `.        '  *             *\n" +
                    "     *              *_.-'   .'            `.               *\n" +
                    "                   .'                       `._             *  '\n" +
                    "   '       '                        .       .  `.     .\n" +
                    "       .                      *                  `\n" +
                    "               *        '             '                          .\n" +
                    "     .                          *        .           *  *\n" +
                    "             *        .                                    '\n");
        } else{
            if(deathChance > 50){
                System.out.println("You jiggled the door handle and the room began to be filled with water. You try to find an escape but it is too late.\nGAME OVER.");
                System.exit(0);
            }else{
                deathChance += deathChance + random.nextInt(20);
                System.out.println("You jiggled the door handle, but it jiggles and does nothing. You feel a lingering sense of dread after your hand leaves the handle, almost like you got one step closer to death.");
            }
        }
        mainRoom();
    }
}
