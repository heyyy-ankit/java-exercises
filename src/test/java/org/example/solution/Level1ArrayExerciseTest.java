package org.example.solution;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Level1ArrayExercise
 */
public class Level1ArrayExerciseTest {

    @Test
    void testFindMax() {
        // Test case 1: Normal array
        int[] numbers1 = {5, 3, 9, 1, 7};
        assertEquals(9, Level1ArrayExercise.findMax(numbers1));
        
        // Test case 2: Array with negative numbers
        int[] numbers2 = {-5, -3, -1, -10};
        assertEquals(-1, Level1ArrayExercise.findMax(numbers2));
        
        // Test case 3: Array with duplicate max value
        int[] numbers3 = {5, 9, 3, 9, 1};
        assertEquals(9, Level1ArrayExercise.findMax(numbers3));
        
        // Test case 4: Array with single element
        int[] numbers4 = {7};
        assertEquals(7, Level1ArrayExercise.findMax(numbers4));
        
    }
    
    @Test
    void testCalculateAverage() {
        // Test case 1: Normal array
        int[] numbers1 = {5, 10, 15, 20, 25};
        assertEquals(15.0, Level1ArrayExercise.calculateAverage(numbers1), 0.001);
        
        // Test case 2: Array with negative numbers
        int[] numbers2 = {-10, 0, 10};
        assertEquals(0.0, Level1ArrayExercise.calculateAverage(numbers2), 0.001);
        
        // Test case 3: Array with single element
        int[] numbers3 = {7};
        assertEquals(7.0, Level1ArrayExercise.calculateAverage(numbers3), 0.001);
        
    }
    
    @Test
    void testReverseArray() {
        // Test case 1: Normal array
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] expected1 = {5, 4, 3, 2, 1};
        Level1ArrayExercise.reverseArray(numbers1);
        assertArrayEquals(expected1, numbers1);
        
        // Test case 2: Array with duplicate elements
        int[] numbers2 = {1, 2, 2, 1};
        int[] expected2 = {1, 2, 2, 1};
        Level1ArrayExercise.reverseArray(numbers2);
        assertArrayEquals(expected2, numbers2);
        
        // Test case 3: Array with single element
        int[] numbers3 = {7};
        int[] expected3 = {7};
        Level1ArrayExercise.reverseArray(numbers3);
        assertArrayEquals(expected3, numbers3);
        
        // Test case 4: Empty array
        int[] numbers4 = {};
        int[] expected4 = {};
        Level1ArrayExercise.reverseArray(numbers4);
        assertArrayEquals(expected4, numbers4);
    }
    
    @Test
    void testRemoveValue() {
        // Test case 1: Remove existing value
        int[] numbers1 = {1, 2, 3, 2, 4, 2, 5};
        int[] expected1 = {1, 3, 4, 5};
        assertArrayEquals(expected1, Level1ArrayExercise.removeValue(numbers1, 2));
        
        // Test case 2: Remove non-existing value
        int[] numbers2 = {1, 2, 3, 4};
        int[] expected2 = {1, 2, 3, 4};
        assertArrayEquals(expected2, Level1ArrayExercise.removeValue(numbers2, 5));
        
        // Test case 3: Remove all values
        int[] numbers3 = {7, 7, 7};
        int[] expected3 = {};
        assertArrayEquals(expected3, Level1ArrayExercise.removeValue(numbers3, 7));
        
        // Test case 4: Empty array
        int[] numbers4 = {};
        int[] expected4 = {};
        assertArrayEquals(expected4, Level1ArrayExercise.removeValue(numbers4, 1));
    }
}