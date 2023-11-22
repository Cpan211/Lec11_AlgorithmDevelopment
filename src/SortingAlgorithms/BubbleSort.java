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
public class BubbleSort {

    // This function performs a bubble sort on an array of integers.
    public static void bubbleSort(int[] array) {

        // Get the length of the array
        int n = array.length;

        // Temporary variable to hold values during the swap
        int temp = 0;

        // Outer loop iterates over each element in the array
        for (int i = 0; i < n; i++) {

            // Inner loop compares adjacent elements and swaps them if they are in the wrong order
            for (int j = 1; j < (n - i); j++) {

                // Check if the current element is greater than the next element
                if (array[j - 1] > array[j]) {

                    // Swap the elements if they are in the wrong order
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                }
            }
        }
    }

    public static void main(String[] args) {

        // TODO code application logic here
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(testArray));

        // Call the bubbleSort function to sort the array
        bubbleSort(testArray);

        System.out.println("Sorted array: " + Arrays.toString(testArray));

    }

}
