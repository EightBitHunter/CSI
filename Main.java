//This program is an escape room! It is a text based adventure game that the player has to navigate by interacting with the puzzles in the room in the right order. There will be
//different things that go on, but they will be documented as they come up.

import java.util.Scanner;
import java.util.Random;
public class Main {
    //creating all the things that will traverse through each different method (action)
    static Random random = new Random();
    static Scanner input = new Scanner(System.in);
    static int deathChance = 10;
    static int playerChoice;
    static boolean firstTime;
    static boolean repeatedTime;
    static boolean tryAgain;
    static boolean entryOne;
    static boolean entryTwo;
    static boolean entryThree;
    static boolean entryFour;
    static boolean entryFive;
    static boolean entrySix;
    static boolean goBack;
    static boolean hasKey = false;
    static boolean firstJournal = true;

    public static void main(String[] args) {
        //main menu/start screen
        System.out.println("Hello player! Welcome to \"The Shape Shift\"! This is an escape room where you try and battle the puzzles with your wit!\nThe goal is to escape the room, and if you jiggle the door handle 3 times unsuccessfully, then the room will flood with water and you will have to start over. You will have access to a journal, which you can access when you start the game by typing 0.\nTo start type in the the number 1, or to end type in the number 2!");
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
        if(firstTime){
            System.out.println("\nYou wake up in a new room unfamiliar with your surroundings. You slowly wake up and notice a couple of oddities around the room. There are some words written on your arm in pen, but you have to focus to read them out.\nIn front of you are three things that draw your attention. There is a directional pad on the floor to your left, a pedestal with 5 three dimensional shapes behind it straight ahead, and a safe with a combination lock on it on the far right corner of the room.");
            System.out.println("There is a door to the right of you, and you notice the room is decorated lavishly with old paintings, dressers, cabinets, and a grandfather clock.");
            System.out.println("Type 0 to open the journal, type 1 to inspect the writing on your arm, type 2 to interact with the directional pad on the left, type 3 to interact with the pedestal, type 4 to interact with the combination lock, or type 5 to try to open the door.");
            playerChoice = input.nextInt();
        }else if (tryAgain){
            playerChoice = input.nextInt();
        }else if (repeatedTime){
            System.out.println("You are in the main room. Type 0 to open the journal, type 1 to inspect the writing on your arm, type 2 to interact with the directional pad on the left, type 3 to interact with the pedestal, type 4 to interact with the combination lock, or type 5 to try to open the door.");
        }
        firstTime = false;
        tryAgain = false;
        repeatedTime = true;
        switch (playerChoice){
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
                tryAgain = true;
                mainRoom();
        }
    }
    public static void journal(){
        if (firstJournal){
            System.out.println("Welcome to the journal. You can re-read hints from earlier on. Type in 1 for journal entry one, 2 for journal entry 2, 3, 4, or 5 respectively. Type 0 to go back to the main selection screen.");
            firstJournal = false;
        }
        playerChoice = input.nextInt();
        switch (playerChoice){
            case 0:
                firstJournal = true;
                mainRoom();
                break;
            case 1:
                if(entryOne){
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

    }
    public static void shapePedestal(){

    }
    public static void lock(){

    }
    public static void tryDoor(){
        if(hasKey){
            System.out.println("You used the key you picked up from the safe to unlock the door. You have escaped!!! Congrats on winning the game.");
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
