//This program is an escape room! It is a text based adventure game that the player has to navigate by interacting with the puzzles in the room in the right order. There will be
//different things that go on, but they will be documented as they come up.

import java.util.Scanner;
public class Main {
    //creating all the things that will traverse through each different method (action)
    static Scanner input = new Scanner(System.in);
    static int playerChoice;
    static boolean firstTime;
    static boolean repeatedTime;
    static boolean tryAgain;
    static boolean entryOne;
    static boolean entryTwo;
    static boolean entryThree;
    static boolean entryFour;


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
            System.out.println("Type 0 to open the journal, type 1 to inspect the writing on your arm, type 2 to interact with the directional pad on the left, type 3 to interact with the pedestal, type 4 to interact with the combination lock, or type 5 to try to open the door.");
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
        System.out.println("Welcome to the journal.");
        mainRoom();
    }
    public static void inspectArm(){
        if (entryOne){
            System.out.println("You already have recorded this in your journal.");
            mainRoom();
        }else{
            System.out.println("\nYou read the pen marks on your arm and they read out to say,\" Four your first challenge, adorn the pedestal with shapes\".\nYou noted this in your journal.");
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

    }
}