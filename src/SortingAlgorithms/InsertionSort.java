/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SortingAlgorithms;

import java.util.Arrays;

/**
 *
 * @author chris
 */
public class InsertionSort {

    // This function performs an insertion sort on an array of integers.
    public static void insertionSort(int[] list) {

        // Iterate over each element in the array starting from the second element (index 1)
        for (int i = 1; i < list.length; i++) {

            // Store the current element to be inserted into the sorted sublist
            int current = list[i];

            // Initialize a variable to traverse the sorted sublist in reverse order
            int k;

            // Traverse the sorted sublist in reverse order and shift elements to make space for the current element
            for (k = i - 1; k >= 0 && list[k] > current; k--) {
                list[k + 1] = list[k];
            }

            // Insert the current element into its correct position in the sorted sublist
            list[k + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] testArray = {64, 34, 25, 1, 22, 11, 2};
        System.out.println("Original array: " + Arrays.toString(testArray));

        // Call the insertionSort function to sort the array
        insertionSort(testArray);

        System.out.println("Sorted array: " + Arrays.toString(testArray));
    }

}
