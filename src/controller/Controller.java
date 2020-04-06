package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.logic.Modelo;
import model.logic.Multa;
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
	 * @throws noExisteObjetoException 
	 */
	public void run() throws InputMismatchException
	{
		try {
			Scanner reader = new Scanner(System.in);
			boolean end = false;

			while (!end) {
				view.displayMenu();
				int option = reader.nextInt();
				switch (option) {

				case 0:
					view.displayOp0Menu(modelo.retornarreq1());
					break;

				case 1:
					// Display option 1
					view.displayOp1Menu();
					long n = reader.nextLong();
					view.displayOp1Data(modelo.reque2(n));
					break;

				case 2:
					
					view.displayOp2Menu();
					long min = reader.nextLong();
					long max = reader.nextLong();
	
					try {
						view.displayOp2Data(modelo.reque3(min, max));
					} catch (Exception e) {
						System.out.println("el minimo debe ser menor o igual al maximo");
					}
				
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
