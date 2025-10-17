package org.example.solution;

import java.util.Arrays;

/**
 * Level 1 Exercise: Basic Array Operations
 * 
 * This exercise focuses on implementing basic array operations.
 */
public class Level1ArrayExercise {

    /**
     * TODO: Implement this method to find the maximum value in an array.
     * 
     * @param numbers An array of integers
     * @return The maximum value in the array
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static int findMax(int[] numbers) {
      int max = Integer.MIN_VALUE;
      for (int num : numbers) { // is loop ko enhanced for loop khete hain
        max = Math.max(max, num);
      }
      return max;
    }
    
    /**
     * TODO: Implement this method to calculate the average of values in an array.
     * 
     * @param numbers An array of integers
     * @return The average of the values in the array (as a double)
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static double calculateAverage(int[] numbers) {
        int totalNumbers = numbers.length;
        if (totalNumbers == 0) {
          throw new IllegalStateException("Array size should be greater than 0");
        }
        long sum = 0;
        for (int num : numbers) { // normal loop bhi use kar sakte ho yha par for(int i = 0; i < totalNumbers; i++) {} ye wala
          sum += num;
        }

        double average = (sum / (totalNumbers * 1.0d)); // totalNumbers * 1.0d ==> ye isliye kiya hai so that integer division na ho, kyuki average decimal me bhi aa sakta hai
        return average;
    }
    
    /**
     * TODO: Implement this method to reverse an array in-place.
     * The original array should be modified.
     * 
     * @param arr The array to reverse
     */
    public static void reverseArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
          i++;
          j--;
        }
    }
    
    /**
     * TODO: Implement this method to remove all occurrences of a specific value.
     * 
     * @param arr The original array
     * @param valueToRemove The value to remove
     * @return A new array with all occurrences of valueToRemove removed
     */
    public static int[] removeValue(int[] arr, int valueToRemove) {
      // return Arrays.stream(arr) // Ye Streams ka concept hai Collections framework me
      //         .filter(num -> num != valueToRemove)
      //         .toArray();

      // Is tarike se bhi kar sakte hai agar stream use nahi karna hai to, but learning Collections framework, Streams is important
      int count = 0;
      for (int num : arr) {
        if (num == valueToRemove) {
          count++;
        }
      }
      int[] result = new int[arr.length - count];
      int k = 0;
      for (int num : arr) {
        if (num == valueToRemove) {
          continue;
        }
        result[k++] = num;
      }
      return result;
    }

    /**
     * Main method with examples for manual testing
     */
    public static void main(String[] args) {
        // Test data
        int[] testArray = {5, 3, 9, 1, 7, 2, 8, 4, 6};
        
        // Uncomment these lines once you've implemented the methods
        
        System.out.println("Max value: " + findMax(testArray));
        System.out.println("Average: " + calculateAverage(testArray));
        
        System.out.println("Original array:");
        printArray(testArray);
        
        reverseArray(testArray);
        System.out.println("After reverse:");
        printArray(testArray);
        
        int[] filteredArray = removeValue(testArray, 7);
        System.out.println("After removing 7:");
        printArray(filteredArray);
        
    }
    
    /**
     * Helper method to print arrays
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}