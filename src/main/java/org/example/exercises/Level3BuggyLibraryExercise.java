package org.example.exercises;

import java.util.*;

/**
 * Debug Challenge: Library Management System
 * 
 * This exercise contains a library management system with several bugs.
 * Your task is to identify and fix ALL bugs in this system without changing
 * the core functionality. Run the main method to see the error messages.
 * 
 * Hint: There are 6-7 bugs in this code. Look for issues with:
 * - Object equality
 * - Collection usage
 * - Initialization
 * - Indexing
 * - String operations
 */
public class Level3BuggyLibraryExercise {

    static class Book {
        private String title;
        private String author;
        private String isbn;
        
        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            
            Book other = (Book) obj;
            return title.equals(other.title) && 
                   author.equals(other.author);
        }
        
        // Missing hashCode implementation
        
        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", isbn='" + isbn + '\'' +
                    '}';
        }
        
        public String getTitle() {
            return title;
        }
        
        public String getAuthor() {
            return author;
        }
        
        public String getIsbn() {
            return isbn;
        }
    }
    
    static class Library {
        private List<Book> books;
        private Map<String, Book> isbnLookup;
        
        public Library() {
            books = new ArrayList<>();
        }
        
        public void addBook(Book book) {
            books.add(book);
        }
        
        public void displayBooks() {
            System.out.println("Library Catalog:");
            for (int i = 1; i <= books.size(); i++) {
                System.out.println(i + ". " + books.get(i));
            }
        }
        
        public Book findBookByIsbn(String isbn) {
            return isbnLookup.get(isbn);
        }
        
        public List<Book> searchBooks(String keyword) {
            List<Book> results = new ArrayList<>();
            
            for (Book book : books) {
                if (book.getTitle().contains(keyword) || 
                    book.getAuthor().contains(keyword)) {
                    results.add(book);
                }
            }
            
            return results;
        }
        public boolean removeBook(Book book) {
            return books.remove(book);
        }
    }
    
    public static void main(String[] args) {
        Library library = new Library();
        
        // Add some books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
        library.addBook(new Book("1984", "George Orwell", "978-0451524935"));
        
        try {
            Book found = library.findBookByIsbn("978-0061120084");
            System.out.println("Found book: " + found);
        } catch (Exception e) {
            System.out.println("Error finding book by ISBN: " + e.getMessage());
        }
        
        try {
            library.displayBooks();
        } catch (Exception e) {
            System.out.println("Error displaying books: " + e.getMessage());
        }
        
        // Search for a book
        List<Book> searchResults = library.searchBooks("gatsby");
        System.out.println("Search results: " + searchResults.size());
        
        // Add two books with same title and author but different ISBN
        library.addBook(new Book("Duplicate", "Same Author", "978-1111111111"));
        library.addBook(new Book("Duplicate", "Same Author", "978-2222222222"));
        
        // Try to remove the second book
        Book toRemove = new Book("Duplicate", "Same Author", "978-2222222222");
        boolean removed = library.removeBook(toRemove);
        System.out.println("Book removed: " + removed);
    }
}