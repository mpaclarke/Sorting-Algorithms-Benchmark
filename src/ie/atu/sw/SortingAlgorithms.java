package ie.atu.sw;

import java.util.Arrays;

/**
 * @author Michael Clarke
 * @version 1.0
 * @since JavaSE-19
 *
 *        This class contains all of the sorting algorithms.
 *
 */
public class SortingAlgorithms {

	/**
	 * 1) Bubble Sort
	 * 
	 * Cited from:
	 * 
	 * Carr, D. (2023) Simple Sorts, 46887 Computational Thinking with Algorithms
	 * available:
	 * https://vlegalwaymayo.atu.ie/pluginfile.php/917614/mod_resource/content/0/CTA___Week_9___Simple_Sorts.pdf
	 * [accessed 13 April 2023].
	 * 
	 * @param array of random numbers.
	 * @return: sorted array.
	 */
	public int[] bubbleSort(int[] arr) {
		int n = arr.length;
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 1; i < n; i++) {
				// Checks if a pair are out of order
				if (arr[i - 1] > arr[i]) {
					// Swapping process.
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
					swapped = true;
				}
			}
		} while (swapped);
		return arr;
	}

	/**
	 * 2) Selection Sort
	 * 
	 * Cited from:
	 * 
	 * Carr, D. (2023) Simple Sorts, 46887 Computational Thinking with Algorithms
	 * available:
	 * https://vlegalwaymayo.atu.ie/pluginfile.php/917614/mod_resource/content/0/CTA___Week_9___Simple_Sorts.pdf
	 * [accessed 13 April 2023].
	 * 
	 * @param array of random numbers.
	 * @return: sorted array.
	 */
	public int[] selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				// Checks the size of the data.
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			// Swapping process.
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	/**
	 * 3) Insertion Sort
	 * 
	 * Cited from:
	 * 
	 * Carr, D. (2023) Simple Sorts, 46887 Computational Thinking with Algorithms
	 * available:
	 * https://vlegalwaymayo.atu.ie/pluginfile.php/917614/mod_resource/content/0/CTA___Week_9___Simple_Sorts.pdf
	 * [accessed 13 April 2023].
	 * 
	 * @param array of random numbers.
	 * @return: sorted array.
	 */
	public int[] insertionSort(int[] arr) {
		int i = 1;
		while (i < arr.length) {
			int j = i;
			// Checks the size of the data
			while (j > 0 && (arr[j - 1] > arr[j])) {
				// Swapping process.
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j--;
			}
			i++;
		}
		return arr;
	}

	/**
	 * 4) Counting Sort
	 * 
	 * Cited from:
	 * 
	 * Geekific (2021) ‘Counting Sort Explained and Implemented with Examples in
	 * Java’, Sorting Algorithms [Video] available:
	 * https://www.youtube.com/watch?v=YEabFTMDczQ&ab_channel=Geekific [accessed 08
	 * April 2023].
	 * 
	 * @param array of random numbers.
	 * @return: sorted array.
	 */
	public int[] countingSort(int[] arr) {
		int min = Arrays.stream(arr).min().orElse(0);
		int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

		// Creates an array that keep track of the count of each element in the input
		// array.
		int[] countArray = new int[max - min + 1];
		for (int value : arr) {
			countArray[value - min]++;
		}
		// Iterates over the input array and sorts the data.
		int arrayIndex = 0;
		for (int i = 0; i < max - min + 1; i++) {
			while (countArray[i] > 0) {
				arr[arrayIndex] = i + min;
				countArray[i]--;
				arrayIndex++;
			}
		}
		return arr;
	}

	/**
	 * 5) Merge Sort
	 * 
	 * Cited from:
	 * 
	 * Merge Sort Algorithm (2023) Geeks for Geeks, available:
	 * https://www.geeksforgeeks.org/merge-sort/ [accessed 03 April 2023].
	 * 
	 * @param array of random numbers.
	 * @return: sorted array.
	 */
	public int[] mergeSort(int[] arr) {
		this.sort(arr, 0, arr.length - 1);
		return arr;
	}

	/**
	 * Sorts the data in relation to the merge method.
	 * 
	 * @param arr: the array of data.
	 * @param l:   size of the left side of the array.
	 * @param r:   size of the right side of the array.
	 */
	private void sort(int arr[], int l, int r) {
		// Base case.
		if (l < r) {
			// Finds the middle point.
			int m = l + (r - l) / 2;
			// Sorts both the sides.
			sort(arr, l, m);
			sort(arr, m + 1, r);
			// calls to merge the sorted sides.
			this.merge(arr, l, m, r);
		}
	}

	/**
	 * Merges the data.
	 * 
	 * @param arr: the array of data.
	 * @param l:   size of the left side of the array.
	 * @param m:   calculated middle point.
	 * @param r:   size of the right side of the array.
	 */
	private void merge(int arr[], int l, int m, int r) {
		// Finds the sizes of the sub arrays.
		int n1 = m - l + 1;
		int n2 = r - m;
		// Temporary arrays to store data.
		int L[] = new int[n1];
		int R[] = new int[n2];
		// Copy the data to the temporary arrays.
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		// Merging process.
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
