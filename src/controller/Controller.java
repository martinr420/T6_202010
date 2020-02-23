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
					// Display option 0


					// read name from input
					modelo.cargarDatos();



					view.displayOp0Menu(modelo.retornarreq1());
					break;

				case 1:
					// Display option 1
					view.displayOp1Menu();
					view.displayOp1Data();
					
					

					// read age from input
					modelo.cargarDatos();
					

			
					LinkedQueue<Multa> lista = modelo.procesosarColaPorComparendo();
					
					
					Nodo<Multa> nodo = lista.dequeue();
					
					
					
					while(nodo!=null)
					{
						System.out.println(nodo.darGenerico().toString());
						nodo = lista.dequeue();
					}
					
					
					break;

				case 2:
					// Display option 2
					view.displayOp2Menu();

					// get info from model
					//String info = model.getName()+"-"+model.getAge();

					// display info in view
					// view.displayOp2Data(info);

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
