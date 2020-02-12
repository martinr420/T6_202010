package view;

import model.logic.Modelo;

public class View 
{
    // -------------------------------------------------------------
    // Constants
    // -------------------------------------------------------------

    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String DYELLOW = "\u001B[38;5;214m";
    private static final String PINK = "\u001B[38;5;205m";
    private static final String WEIRDRED = "\u001B[38;5;203m";
    private static final String ORANGE = "\u001B[38;5;208m";
    private static final String LIGHTBLUE = "\u001B[38;5;50m";
    private static final String GREEN = "\u001B[38;5;84m";
    private static final String PRETTYPURPLE = "\u001B[38;5;213m";
    private static final String BBLUE = "\u001B[38;5;87m";
    private static final String DARKORANGE = "\u001B[38;5;202m";


    // -------------------------------------------------------------
    // Displays
    // -------------------------------------------------------------

    /**
     * Displays the user menu.
     */
    public void displayMenu() {

        System.out.println(DYELLOW + " **==========================**");
        System.out.println(DYELLOW + " ||      ==== MENU ====      ||");

        System.out.println(DYELLOW + " ||" + BBLUE + " 0. Set name  " + DYELLOW + "            ||");
        System.out.println(DYELLOW + " ||" + GREEN + " 1. Set age " + DYELLOW + "              ||");
        System.out.println(DYELLOW + " ||" + PINK + " 2. Get Info  " + DYELLOW + "            ||");
        System.out.println(DYELLOW + " **==========================**\n");

        // display hint
        this.displayHint();
        System.out.print(BLUE + "Input -> \n\n" + RESET);
    }

    /**
     * Displays an error message to the user if the option selected is invalid.
     */
    public void badOption() {
        System.out.println("\u001B[31m########## \n?Invalid option !! \n########## \u001B[0m");
    }

    /**
     * Print a hint to the user to select an option.
     */
    public void displayHint() {
        System.out.println(
                BLUE + "Enter the number corresponding to the option, the press the Return "
                        + "key: (e.g ., 1,2..):\n" + RESET);
    }


    // -------------------------------------------------------------
    // Option 0
    // -------------------------------------------------------------

    /**
     * Print option 0 menu.
     */
    public void displayOp0Menu() {
        System.out.println(DYELLOW + "====== Set Name ======");
        System.out.println(LIGHTBLUE + "Enter name: ");

    }

    /**
     * Print option 0 data.
     */
    public void displayOp0Data(String pName) {
        System.out.println(LIGHTBLUE + "Name set to: " + RESET + pName);
        System.out.println(DYELLOW + "======================\n");

    }

    // -------------------------------------------------------------
    // Option 1
    // -------------------------------------------------------------

    /**
     * Print option 1 menu.
     */
    public void displayOp1Menu() {
        System.out.println(DYELLOW + "====== Set Age ======");
        System.out.println(LIGHTBLUE + "Enter Age: ");

    }

    /**
     * Print option 1 data.
     */
    public void displayOp1Data(int pAge) {
        System.out.println(LIGHTBLUE + "Age set to: " + RESET + pAge);
        System.out.println(DYELLOW + "======================\n");

    }

    // -------------------------------------------------------------
    // Option 2
    // -------------------------------------------------------------

    /**
     * Print option 2 menu.
     */
    public void displayOp2Menu() {
        System.out.println(DYELLOW + "====== Get Info ======");
    }

    /**
     * Print option 2 data.
     */
    public void displayOp2Data(String pInfo) {

        System.out.println(LIGHTBLUE + "Name: " + RESET + pInfo.split("-")[0]);
        System.out.println(LIGHTBLUE + "Age: " + RESET + pInfo.split("-")[1]);
        System.out.println(DYELLOW + "======================\n");

    }
}
