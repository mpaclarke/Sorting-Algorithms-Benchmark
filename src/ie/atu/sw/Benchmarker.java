package ie.atu.sw;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Michael Clarke
 * @version 1.0
 * @since JavaSE-19
 *
 *        This class creates the benchmark data.
 *
 */
public class Benchmarker {
	// Instance of the data table class.
	public DataTable dt;
	// Instance of the sorting algorithm class.
	public SortingAlgorithms sa;
	// Variables to store time in nanoseconds
	private long startTime, endTime, estTime;
	// Variable to store time in milliseconds
	private double estTimeInMilliSec, temp, avgTime;
	// Static variable to convert times
	private static final double NANOSECDIVIDER = 1e+6d;
	// Data for the array sizes.
	private int[] arrSize = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10_000 };

	/**
	 * Creates an instance of the benchmarking class.
	 */
	public Benchmarker() {
		this.startTime = 0l;
		this.endTime = 0l;
		this.estTime = 0l;
		this.estTimeInMilliSec = 0.0d;
		this.temp = 0.0d;
		this.avgTime = 0.0d;
		dt = new DataTable();
		sa = new SortingAlgorithms();
	}

	/**
	 * Starts this class. Calls the methods that calls each sorting algorithm.
	 * Prints information and the data table to the user.
	 * 
	 * Keeps a count of each run by taking an integer from the application interface
	 * class.
	 * 
	 * @param counter
	 */
	public void run(int counter) {
		System.out.println("[INFO] Sorting arrays that contain unordered data...");
		System.out.println("[INFO] This may take some time :)");
		this.runSortingAlgorithms();
		System.out.println("[INFO] Sorting Complete. Printing results for run " + counter + "...");
		System.out.println();
		dt.printRandomArrayDataTable(dt.getTable(), counter);
		System.out.println();
		this.resetVariables();
		System.out.println("[INFO] Each table entry is an average of ten runs of unsorted data.");
		System.out.println("[INFO] Returning to the main menu...");
		System.out.println();
	}

	/**
	 * Call each of the sorting algorithms in turn.
	 */
	private void runSortingAlgorithms() {
		this.runBubbleSort();

		this.runSelectionSort();

		this.runInsertionSort();

		this.runCountingSort();

		this.runMergeSort();
	}

	/**
	 * Calls bubble sort.
	 * 
	 * Calls the method that generates arrays and sends the array to the sorting
	 * algorithm. Calculates an average of 10 runs. Stores the data in the data
	 * table class.
	 * 
	 * The following sources influenced this design:
	 * 
	 * Carr, D. (2023) Benchmarking in Java, 46887 Computational Thinking with
	 * Algorithms available:
	 * https://vlegalwaymayo.atu.ie/pluginfile.php/924515/mod_resource/content/0/CTA___Week_11__Benchmarking_in_Java.pdf
	 * [accessed 21 April 2023].
	 * 
	 * Porter, L, Minnes, M. Alvarado, C. (2023) ‘Core: Using Java Time’ Data
	 * Structures and Performance [Video] available:
	 * https://www.coursera.org/lecture/data-structures-optimizing-performance/core-using-java-time-lTy4W
	 * [accessed 03 April 2023].
	 */
	private void runBubbleSort() {
		// Stores row data in the data table.
		dt.table[1][0] = "Bubble Sort";
		// Tracks the row entries.
		int col = 1;
		// Outer loop iterates though increasing array sizes.
		for (int i = 0; i < arrSize.length; i++) {
			// Resets the variables for each increasing array size.
			this.resetVariables();
			// Inner loop repeats the text 10 times.
			for (int j = 1; j <= 10; j++) {
				// Creates a new arrays for each run.
				int[] arr = new int[arrSize[i]];
				// Generates an array of random numbers.
				this.generateArr(arr, 1, arrSize[i]);
				// Marks start time.
				startTime = System.nanoTime();
				// Calls sorting algorithm and passes array.
				sa.bubbleSort(arr);
				// Marks end time.
				endTime = System.nanoTime();
				// Stores time it took to sort data.
				estTime = endTime - startTime;
				// Converts to milliseconds
				estTimeInMilliSec = (double) estTime / NANOSECDIVIDER;
				// Stores time for each repeated run.
				temp += estTimeInMilliSec;
			}
			// Calculates and stores average time.
			avgTime = temp / 10;
			// Stores the data to the data table.
			dt.table[1][col] = String.format("%.3f", avgTime);
			// Increments the column number.
			col++;
		}
	}

	/**
	 * Calls selection sort.
	 * 
	 * Same process as above.
	 */
	private void runSelectionSort() {
		dt.table[2][0] = "Selection Sort";

		int col = 1;
		for (int i = 0; i < arrSize.length; i++) {
			this.resetVariables();
			for (int j = 1; j <= 10; j++) {
				int[] arr = new int[arrSize[i]];
				this.generateArr(arr, 1, arrSize[i]);
				startTime = System.nanoTime();
				sa.selectionSort(arr);
				endTime = System.nanoTime();
				estTime = endTime - startTime;
				estTimeInMilliSec = (double) estTime / NANOSECDIVIDER;
				temp += estTimeInMilliSec;
			}
			avgTime = temp / 10;
			dt.table[2][col] = String.format("%.3f", avgTime);
			col++;
		}
	}

	/**
	 * Calls insertion sort.
	 * 
	 * Same process as above.
	 */
	private void runInsertionSort() {
		dt.table[3][0] = "Insertion Sort";

		int col = 1;
		for (int i = 0; i < arrSize.length; i++) {
			this.resetVariables();
			for (int j = 1; j <= 10; j++) {
				int[] arr = new int[arrSize[i]];
				this.generateArr(arr, 1, arrSize[i]);
				startTime = System.nanoTime();
				sa.insertionSort(arr);
				endTime = System.nanoTime();
				estTime = endTime - startTime;
				estTimeInMilliSec = (double) estTime / NANOSECDIVIDER;
				temp += estTimeInMilliSec;
			}
			avgTime = temp / 10;
			dt.table[3][col] = String.format("%.3f", avgTime);
			col++;
		}
	}

	/**
	 * Calls counting sort.
	 * 
	 * Same process as above.
	 */
	private void runCountingSort() {
		dt.table[4][0] = "Counting Sort";

		int col = 1;
		for (int i = 0; i < arrSize.length; i++) {
			this.resetVariables();
			for (int j = 1; j <= 10; j++) {
				int[] arr = new int[arrSize[i]];
				this.generateArr(arr, 1, arrSize[i]);
				startTime = System.nanoTime();
				sa.countingSort(arr);
				endTime = System.nanoTime();
				estTime = endTime - startTime;
				estTimeInMilliSec = (double) estTime / NANOSECDIVIDER;
				temp += estTimeInMilliSec;
			}
			avgTime = temp / 10;
			dt.table[4][col] = String.format("%.3f", avgTime);
			col++;
		}

	}

	/**
	 * Calls merge sort.
	 * 
	 * Same process as above.
	 */
	private void runMergeSort() {
		dt.table[5][0] = "Merge Sort";

		int col = 1;
		for (int i = 0; i < arrSize.length; i++) {
			this.resetVariables();
			for (int j = 1; j <= 10; j++) {
				int[] arr = new int[arrSize[i]];
				this.generateArr(arr, 1, arrSize[i]);
				startTime = System.nanoTime();
				sa.mergeSort(arr);
				endTime = System.nanoTime();
				estTime = endTime - startTime;
				estTimeInMilliSec = (double) estTime / NANOSECDIVIDER;
				temp += estTimeInMilliSec;
			}
			avgTime = temp / 10;
			dt.table[5][col] = String.format("%.3f", avgTime);
			col++;
		}
	}

	/**
	 * Reset the instance variables that collect time data.
	 */
	private void resetVariables() {
		estTimeInMilliSec = temp = avgTime = 0.0d; // Resets these variables.
		startTime = endTime = estTime = 0l; // Resets these variables.
	}

	/**
	 * Takes in an array and returns an array of random numbers.
	 * 
	 * I cite the following as a design influence. Carr, D. (2023) Benchmarking in
	 * Java, 46887 Computational Thinking with Algorithms available:
	 * https://vlegalwaymayo.atu.ie/pluginfile.php/924515/mod_resource/content/0/CTA___Week_11__Benchmarking_in_Java.pdf
	 * [accessed 21 April 2023].
	 * 
	 * @param arr: the array to be filled.
	 * @param min: minimum size of the array.
	 * @param max: maximum size of the array.
	 * @return An array of random numbers.
	 */
	private int[] generateArr(int[] arr, int min, int max) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ThreadLocalRandom.current().nextInt(min, max);
		}
		return arr;
	}

}
