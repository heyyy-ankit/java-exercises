package org.example.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the fixed Level3BuggyLibraryExercise
 * Note: These tests will only pass once the bugs have been fixed
 */
public class Level3BuggyLibraryExerciseTest {
    
    private Level3BuggyLibraryExercise.Library library;
    private Level3BuggyLibraryExercise.Book book1, book2, book3;
    
    @BeforeEach
    void setUp() {
        library = new Level3BuggyLibraryExercise.Library();
        
        book1 = new Level3BuggyLibraryExercise.Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        book2 = new Level3BuggyLibraryExercise.Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        book3 = new Level3BuggyLibraryExercise.Book("1984", "George Orwell", "978-0451524935");
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }
    
    @Test
    void testFindBookByIsbn() {
        // This will pass once isbnLookup is properly initialized and populated
        Level3BuggyLibraryExercise.Book found = library.findBookByIsbn("978-0061120084");
        assertNotNull(found, "Should find book by ISBN");
        assertEquals("To Kill a Mockingbird", found.getTitle());
    }
    
    @Test
    void testDisplayBooks() {
        // This will pass once the off-by-one error is fixed
        // We can't directly test console output, but we can verify the method runs without exception
        assertDoesNotThrow(() -> library.displayBooks(), "displayBooks should not throw an exception");
    }
    
    @Test
    void testSearchBooks() {
        // This will pass once case-insensitive search is implemented
        List<Level3BuggyLibraryExercise.Book> results = library.searchBooks("gatsby");
        assertEquals(1, results.size(), "Case-insensitive search should find one result");
        assertEquals("The Great Gatsby", results.get(0).getTitle());
    }
    
    @Test
    void testBookEquality() {
        // This will pass once equals is fixed to consider ISBN
        Level3BuggyLibraryExercise.Book duplicateWithDifferentIsbn = 
                new Level3BuggyLibraryExercise.Book("The Great Gatsby", "F. Scott Fitzgerald", "978-1234567890");
        
        assertNotEquals(book1, duplicateWithDifferentIsbn, 
                "Books with same title/author but different ISBN should not be equal");
    }
    
    @Test
    void testRemoveBook() {
        // Create a book with the same values
        Level3BuggyLibraryExercise.Book bookToRemove = 
                new Level3BuggyLibraryExercise.Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        
        // This will pass once equals properly considers all fields
        boolean removed = library.removeBook(bookToRemove);
        assertTrue(removed, "Book should be removed successfully");
    }
    
    @Test
    void testHashCodeConsistency() {
        // This will pass once hashCode is implemented consistent with equals
        Level3BuggyLibraryExercise.Book sameBook = 
                new Level3BuggyLibraryExercise.Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        
        assertEquals(book1.hashCode(), sameBook.hashCode(), 
                "Equal objects should have the same hash code");
    }
}