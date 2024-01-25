package ie.atu.sw;

import java.util.Scanner;

/**
 * @author Michael Clarke
 * @version 1.0
 * @since JavaSE-19
 *
 *        This class acts as the interface between the user and the benchmarking
 *        class.
 */
public class ApplicationInterface {
	// Keeps the application running
	private boolean keepRunning;
	// Takes input from the user.
	private Scanner userInput;
	// Counts the number of times the benchmark runs.
	private int counter;

	/**
	 * Creates an instance of the application interface.
	 */
	public ApplicationInterface() {
		this.keepRunning = true;
		this.userInput = new Scanner(System.in);
		counter = 1;
	}

	/**
	 * Prints the user interface. Takes input from the user. Creates instances of
	 * the benchmark.
	 */
	public void start() {
		do {
			System.out.println("******************    Sorting Algorithm Benchmark   ******************");
			System.out.println("[INFO] Enter 'r' to run this application.");
			System.out.println("[INFO] Enter 'q' to quit this application.");
			var choice = userInput.next();
			if (choice.equalsIgnoreCase("r")) {
				new Benchmarker().run(counter);
				counter++;
			} else if (choice.equalsIgnoreCase("q")) {
				System.out.println("[INFO] The application is shutting down. Please wait...");
				keepRunning = false; // Sets the instance variable that closes the do loop.
			} else {
				System.out.println("[ERROR] Invalid input...");
				System.out.println("[INFO] Please enter 'r' or 'q'");
			}

		} while (keepRunning);
		System.out.println("[INFO] The application has shutdown.");
	}
}
