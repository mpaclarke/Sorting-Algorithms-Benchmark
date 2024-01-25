package ie.atu.sw;

/**
 * @author Michael Clarke
 * @version 1.0
 * @since JavaSE-19
 * 
 *        This class stores the data generated from the benchmarking and also
 *        prints the data to the console.
 *
 */
public class DataTable {
	// Instance of the data table.
	public Object[][] table;

	/**
	 * Creates an instance of the data table
	 */
	public DataTable() {
		table = new Object[6][14];
		table[0][0] = "Size";
		table[0][1] = "100";
		table[0][2] = "250";
		table[0][3] = "500";
		table[0][4] = "750";
		table[0][5] = "1000";
		table[0][6] = "1250";
		table[0][7] = "2500";
		table[0][8] = "3750";
		table[0][9] = "5000";
		table[0][10] = "6250";
		table[0][11] = "7500";
		table[0][12] = "8750";
		table[0][13] = "10,000";
	}

	/**
	 * Returns the data table from this class.
	 * 
	 * @return the table of benchmarking data.
	 */
	protected Object[][] getTable() {
		return table;
	}

	/**
	 * Takes in the array from the benchmarking class and a count of the run from
	 * the application interface class.
	 * 
	 * @param arr
	 * @param counter
	 */
	public void printRandomArrayDataTable(Object[][] arr, int counter) {
		System.out.println("---------------------------------------------   Run No " + counter
				+ ": Results in Milliseconds   ------------------------------------------------");
		for (int row = 0; row < arr.length; row++) {
			System.out.printf("%-15s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %n", arr[row][0],
					arr[row][1], arr[row][2], arr[row][3], arr[row][4], arr[row][5], arr[row][6], arr[row][7],
					arr[row][8], arr[row][9], arr[row][10], arr[row][11], arr[row][12], arr[row][13]);
		}
	}
}
