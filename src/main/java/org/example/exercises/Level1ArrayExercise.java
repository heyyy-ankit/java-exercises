package org.example.exercises;

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
        // Implementation goes here
        throw new UnsupportedOperationException("Method not implemented yet");
    }
    
    /**
     * TODO: Implement this method to calculate the average of values in an array.
     * 
     * @param numbers An array of integers
     * @return The average of the values in the array (as a double)
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static double calculateAverage(int[] numbers) {
        // Implementation goes here
        throw new UnsupportedOperationException("Method not implemented yet");
    }
    
    /**
     * TODO: Implement this method to reverse an array in-place.
     * The original array should be modified.
     * 
     * @param arr The array to reverse
     */
    public static void reverseArray(int[] arr) {
        // Implementation goes here
        throw new UnsupportedOperationException("Method not implemented yet");
    }
    
    /**
     * TODO: Implement this method to remove all occurrences of a specific value.
     * 
     * @param arr The original array
     * @param valueToRemove The value to remove
     * @return A new array with all occurrences of valueToRemove removed
     */
    public static int[] removeValue(int[] arr, int valueToRemove) {
        // Implementation goes here
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    /**
     * Main method with examples for manual testing
     */
    public static void main(String[] args) {
        // Test data
        int[] testArray = {5, 3, 9, 1, 7, 2, 8, 4, 6};
        
        // Uncomment these lines once you've implemented the methods
        /*
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
        */
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