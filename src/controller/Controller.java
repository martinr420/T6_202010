package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	
	    // -------------------------------------------------------------
	    // Attributes
	    // -------------------------------------------------------------

	    /**
	     * A model.
	     */
	    private Modelo modelo;

	    /**
	     * A view.
	     */
	    private View view;

	    // -------------------------------------------------------------
	    // Constructor
	    // -------------------------------------------------------------

	    /**
	     * Creates the project view and the project model
	     */
	    public Controller() {
	        modelo = new Modelo();
	        view = new View();
	    }

	    // -------------------------------------------------------------
	    // Methods
	    // -------------------------------------------------------------

	    /**
	     * Prints the user options and updates the view using the model.
	     *
	     * @throws InputMismatchException If the user inputs an incorrect number sequence.
	     */
	    public void run() throws InputMismatchException {
	        try {
	            Scanner reader = new Scanner(System.in);
	            boolean end = false;

	            while (!end) {
	                view.displayMenu();
	                int option = reader.nextInt();
	                switch (option) {

	                    case 0:
	                        // Display option 0
	                        view.displayOp0Menu();

	                        // read name from input
	                        String name = reader.next();

	                        // set name in model
	                        modelo.setName(name);

	                        // display name in view
	                        view.displayOp0Data(name);
	                        break;

	                    case 1:
	                        // Display option 1
	                        view.displayOp1Menu();

	                        // read age from input
	                        int age = reader.nextInt();

	                        // set age in model
	                        model.setAge(age);

	                        // display age in view
	                        view.displayOp1Data(age);
	                        break;

	                    case 2:
	                        // Display option 2
	                        view.displayOp2Menu();

	                        // get info from model
	                        String info = model.getName()+"-"+model.getAge();

	                        // display info in view
	                        view.displayOp2Data(info);

	                        break;

	                    // Invalid option
	                    default:
	                        view.badOption();
	                        end = true;
	                        break;
	                }
	            }
	        } 
	        catch (InputMismatchException e)
	        {
	            run();
	        }
	    }

}
