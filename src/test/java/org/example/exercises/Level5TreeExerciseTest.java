package org.example.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Level5TreeExercise
 */
public class Level5TreeExerciseTest {

    private Level5TreeExercise.FileSystemTree fileSystem;
    
    @BeforeEach
    void setUp() {
        fileSystem = new Level5TreeExercise.FileSystemTree("root");
    }
    
    @Test
    void testBasicFileOperations() {
        // Test adding files to root
        assertTrue(fileSystem.addFile("/", "home", true, 0));
        assertTrue(fileSystem.addFile("/", "usr", true, 0));
        assertTrue(fileSystem.addFile("/", "readme.txt", false, 1024));
        
        // Test finding files
        Level5TreeExercise.FileNode homeDir = fileSystem.findFile("/home");
        assertNotNull(homeDir);
        assertTrue(homeDir.isDirectory);
        assertEquals("home", homeDir.name);
        
        Level5TreeExercise.FileNode readmeFile = fileSystem.findFile("/readme.txt");
        assertNotNull(readmeFile);
        assertFalse(readmeFile.isDirectory);
        assertEquals(1024, readmeFile.size);
    }
    
    @Test
    void testNestedDirectories() {
        // Create nested directory structure
        assertTrue(fileSystem.addFile("/", "home", true, 0));
        assertTrue(fileSystem.addFile("/home", "user", true, 0));
        assertTrue(fileSystem.addFile("/home/user", "documents", true, 0));
        assertTrue(fileSystem.addFile("/home/user/documents", "report.pdf", false, 2048));
        
        // Test finding nested files
        Level5TreeExercise.FileNode reportFile = fileSystem.findFile("/home/user/documents/report.pdf");
        assertNotNull(reportFile);
        assertEquals("report.pdf", reportFile.name);
        assertEquals(2048, reportFile.size);
        
        // Test finding intermediate directories
        Level5TreeExercise.FileNode userDir = fileSystem.findFile("/home/user");
        assertNotNull(userDir);
        assertTrue(userDir.isDirectory);
    }
    
    @Test
    void testListDirectory() {
        // Setup directory structure
        fileSystem.addFile("/", "home", true, 0);
        fileSystem.addFile("/", "usr", true, 0);
        fileSystem.addFile("/", "config.txt", false, 512);
        
        fileSystem.addFile("/home", "user1", true, 0);
        fileSystem.addFile("/home", "user2", true, 0);
        fileSystem.addFile("/home", "shared.txt", false, 256);
        
        // Test listing root directory
        String[] rootContents = fileSystem.listDirectory("/");
        assertNotNull(rootContents);
        assertEquals(3, rootContents.length);
        // Note: Order might vary based on implementation
        assertTrue(containsAll(rootContents, "home", "usr", "config.txt"));
        
        // Test listing home directory
        String[] homeContents = fileSystem.listDirectory("/home");
        assertNotNull(homeContents);
        assertEquals(3, homeContents.length);
        assertTrue(containsAll(homeContents, "user1", "user2", "shared.txt"));
        
        // Test listing non-existent directory
        assertNull(fileSystem.listDirectory("/nonexistent"));
    }
    
    @Test
    void testDirectorySize() {
        // Setup files with known sizes
        fileSystem.addFile("/", "home", true, 0);
        fileSystem.addFile("/home", "user", true, 0);
        fileSystem.addFile("/home/user", "file1.txt", false, 1000);
        fileSystem.addFile("/home/user", "file2.txt", false, 2000);
        fileSystem.addFile("/home", "shared.txt", false, 500);
        
        // Test directory size calculation
        assertEquals(3500, fileSystem.getDirectorySize("/home")); // 1000 + 2000 + 500
        assertEquals(3000, fileSystem.getDirectorySize("/home/user")); // 1000 + 2000
        
        // Test non-existent directory
        assertEquals(-1, fileSystem.getDirectorySize("/nonexistent"));
    }
    
    @Test
    void testCountFiles() {
        // Setup directory structure
        fileSystem.addFile("/", "home", true, 0);
        fileSystem.addFile("/", "config.txt", false, 100);
        fileSystem.addFile("/home", "user", true, 0);
        fileSystem.addFile("/home", "readme.txt", false, 200);
        fileSystem.addFile("/home/user", "document.pdf", false, 300);
        fileSystem.addFile("/home/user", "photo.jpg", false, 400);
        
        // Test file counting
        assertEquals(4, fileSystem.countFiles("/")); // config.txt, readme.txt, document.pdf, photo.jpg
        assertEquals(3, fileSystem.countFiles("/home")); // readme.txt, document.pdf, photo.jpg
        assertEquals(2, fileSystem.countFiles("/home/user")); // document.pdf, photo.jpg
        
        // Test non-existent directory
        assertEquals(-1, fileSystem.countFiles("/nonexistent"));
    }
    
    @Test
    void testDeleteFile() {
        // Setup files
        fileSystem.addFile("/", "home", true, 0);
        fileSystem.addFile("/", "temp.txt", false, 100);
        fileSystem.addFile("/home", "user", true, 0);
        fileSystem.addFile("/home/user", "document.txt", false, 200);
        
        // Test deleting a file
        assertTrue(fileSystem.deleteFile("/temp.txt"));
        assertNull(fileSystem.findFile("/temp.txt"));
        
        // Test deleting a file in subdirectory
        assertTrue(fileSystem.deleteFile("/home/user/document.txt"));
        assertNull(fileSystem.findFile("/home/user/document.txt"));
        
        // Test deleting empty directory
        assertTrue(fileSystem.deleteFile("/home/user"));
        assertNull(fileSystem.findFile("/home/user"));
        
        // Test deleting non-empty directory (should fail)
        fileSystem.addFile("/home", "newfile.txt", false, 50);
        assertFalse(fileSystem.deleteFile("/home")); // Should fail because it's not empty
        assertNotNull(fileSystem.findFile("/home"));
        
        // Test deleting non-existent file
        assertFalse(fileSystem.deleteFile("/nonexistent.txt"));
    }
    
    @Test
    void testIsDirectoryEmpty() {
        // Setup directories
        fileSystem.addFile("/", "empty", true, 0);
        fileSystem.addFile("/", "nonempty", true, 0);
        fileSystem.addFile("/nonempty", "file.txt", false, 100);
        
        // Test empty directory
        assertTrue(fileSystem.isDirectoryEmpty("/empty"));
        
        // Test non-empty directory
        assertFalse(fileSystem.isDirectoryEmpty("/nonempty"));
        
        // Test non-existent directory
        assertFalse(fileSystem.isDirectoryEmpty("/nonexistent"));
        
        // Test file (not directory)
        assertFalse(fileSystem.isDirectoryEmpty("/nonempty/file.txt"));
    }
    
    @Test
    void testGetPath() {
        // Setup nested structure
        fileSystem.addFile("/", "home", true, 0);
        fileSystem.addFile("/home", "user", true, 0);
        fileSystem.addFile("/home/user", "document.txt", false, 100);
        
        Level5TreeExercise.FileNode rootNode = fileSystem.getRoot();
        Level5TreeExercise.FileNode documentNode = fileSystem.findFile("/home/user/document.txt");
        
        assertEquals("/", fileSystem.getPath(rootNode));
        assertEquals("/home/user/document.txt", fileSystem.getPath(documentNode));
    }
    
    @Test
    void testAddFileToNonExistentParent() {
        // Test adding file to non-existent parent
        assertFalse(fileSystem.addFile("/nonexistent", "file.txt", false, 100));
    }
    
    @Test
    void testFileNodeEquality() {
        Level5TreeExercise.FileNode file1 = new Level5TreeExercise.FileNode("test.txt", false, 100);
        Level5TreeExercise.FileNode file2 = new Level5TreeExercise.FileNode("test.txt", false, 100);
        Level5TreeExercise.FileNode file3 = new Level5TreeExercise.FileNode("different.txt", false, 100);
        Level5TreeExercise.FileNode dir1 = new Level5TreeExercise.FileNode("test", true, 0);
        
        assertEquals(file1, file2);
        assertNotEquals(file1, file3);
        assertNotEquals(file1, dir1);
        
        assertEquals("[FILE] test.txt (100 bytes)", file1.toString());
        assertEquals("[DIR] test", dir1.toString());
    }
    
    // Helper method to check if array contains all expected values
    private boolean containsAll(String[] array, String... expected) {
        if (array.length != expected.length) return false;
        for (String exp : expected) {
            boolean found = false;
            for (String actual : array) {
                if (exp.equals(actual)) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}