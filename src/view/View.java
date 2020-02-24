package view;

import model.logic.Modelo;

public class View 
{
    // -------------------------------------------------------------
    // Constants
    // -------------------------------------------------------------

   

    // -------------------------------------------------------------
    // Displays
    // -------------------------------------------------------------

    /**
     * Displays the user menu.
     */
    public void displayMenu() {

        System.out.println(  " **==========================**");
        System.out.println(" ||      ==== MENU ====      ||");

        System.out.println( " ||" +  " 0. Cargar datos   "  + "       ||");
        System.out.println( " ||" +  " 1. Crear arreglo "  + "        ||");
        System.out.println( " ||" + " 2. Ordenar Arreglo ShellSort " + " ||");
        System.out.println("||" + "3. Ordenar Arreglo por MergeSort");
        System.out.println("||" + "4. Ordenar Arreglo por QuickSort");
        System.out.println( " **==========================**\n");

        // display hint
        this.displayHint();
        System.out.print("Input -> \n\n" );
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
                 "Enter the number corresponding to the option, the press the Return "
                        + "key: (e.g ., 1,2..):\n" );
    }


    // -------------------------------------------------------------
    // Option 0
    // -------------------------------------------------------------

    /**
     * Print option 0 menu.
     */
    public void displayOp0Menu(String mensaje) {
        System.out.println( "====== Cargar datos ======");
        System.out.println(mensaje);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        

    }

    /**
     * Print option 0 data.
     */
    public void displayOp0Data(String pName) {
        System.out.println( "Name set to: " + pName);
        System.out.println("======================\n");

    }

    // -------------------------------------------------------------
    // Option 1
    // -------------------------------------------------------------

    /**
     * Print option 1 menu.
     */
    public void displayOp1Menu() {
        System.out.println( "====== Ordenar arreglo shell sort ======");
        

    }

    /**
     * Print option 1 data.
     */
    public void displayOp1Data() {
        System.out.println("Los comparendos son: " );
        System.out.println( "======================\n");

    }

    // -------------------------------------------------------------
    // Option 2
    // -------------------------------------------------------------

    /**
     * Print option 2 menu.
     */
    public void displayOp2Menu() {
        System.out.println( "====== Arreglo Ordenado Shell Sort ======");
    }

    /**
     * Print option 2 data.
     */
    public void displayOp2Data(String pInfo) {

        System.out.println( "Name: " + pInfo.split("-")[0]);
        System.out.println( "Age: " + pInfo.split("-")[1]);
        System.out.println("======================\n");

    }
    
    public void displayOp3Menu()
    {
    	System.out.println("===== Arreglo ordenado por Merge Sort =====");
    }
    
    public void displayOp4Menu()
    {
    	System.out.println("======= Arreglo ordenado por el metodo Quick Sort");
    }
}
