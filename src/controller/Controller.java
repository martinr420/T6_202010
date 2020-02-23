package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.LinkedQueue;
import model.data_structures.Nodo;
import model.data_structures.noExisteObjetoException;
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
	public void run() throws InputMismatchException, noExisteObjetoException {
		try {
			Scanner reader = new Scanner(System.in);
			boolean end = false;

			while (!end) {
				view.displayMenu();
				int option = reader.nextInt();
				switch (option) {

				case 0:
					
					modelo.cargarDatos();

					view.displayOp0Menu(modelo.retornarreq1());
					
					
					break;

				case 1:
					// Display option 1
					view.displayOp1Menu();
					modelo.copiarComparendos();
					
					
					break;

				case 2:
					view.displayOp2Menu();
					
					
					modelo.shellSort(modelo.copiarComparendos());

					break;
					
				case 3:
					view.displayOp3Menu();
					modelo.darInfoMergeSort(modelo.copiarComparendos(), 0, modelo.copiarComparendos().length-1);
					view.displayOp3Menu();
					
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
