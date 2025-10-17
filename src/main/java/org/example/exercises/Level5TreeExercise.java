package org.example.exercises;

/**
 * Level 5 Exercise: File System Directory Tree
 * 
 * This exercise simulates a file system directory structure using a tree.
 * This is a real-world scenario where tree operations are commonly used
 * for navigating and managing hierarchical data.
 */
public class Level5TreeExercise {

    /**
     * Node class representing a file or directory
     */
    public static class FileNode {
        String name;
        boolean isDirectory;
        long size; // file size in bytes (0 for directories)
        FileNode parent;
        FileNode firstChild; // first child (file/subdirectory)
        FileNode nextSibling; // next sibling in the same directory
        
        public FileNode(String name, boolean isDirectory, long size) {
            this.name = name;
            this.isDirectory = isDirectory;
            this.size = size;
            this.parent = null;
            this.firstChild = null;
            this.nextSibling = null;
        }
        
        @Override
        public String toString() {
            if (isDirectory) {
                return "[DIR] " + name;
            } else {
                return "[FILE] " + name + " (" + size + " bytes)";
            }
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            FileNode fileNode = (FileNode) obj;
            return isDirectory == fileNode.isDirectory && 
                   size == fileNode.size && 
                   name.equals(fileNode.name);
        }
    }
    
    /**
     * File System Tree class
     */
    public static class FileSystemTree {
        private FileNode root;
        
        public FileSystemTree(String rootName) {
            this.root = new FileNode(rootName, true, 0);
        }
        
        /**
         * TODO: Add a file or directory to the specified parent directory
         * 
         * @param parentPath The path to the parent directory (e.g., "/home/user")
         * @param name The name of the new file/directory
         * @param isDirectory Whether it's a directory or file
         * @param size The size in bytes (0 for directories)
         * @return true if successfully added, false if parent not found
         */
        public boolean addFile(String parentPath, String name, boolean isDirectory, long size) {
            // Implementation goes here
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: Find a file or directory by its full path
         * 
         * @param path The full path to the file/directory (e.g., "/home/user/document.txt")
         * @return The FileNode if found, null otherwise
         */
        public FileNode findFile(String path) {
            // Implementation goes here
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: Delete a file or directory by path
         * For directories, only delete if empty
         * 
         * @param path The path to the file/directory to delete
         * @return true if successfully deleted, false otherwise
         */
        public boolean deleteFile(String path) {
            // Implementation goes here
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: List all direct children of a directory
         * 
         * @param directoryPath The path to the directory
         * @return Array of child names, or null if directory not found
         */
        public String[] listDirectory(String directoryPath) {
            // Implementation goes here
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: Calculate the total size of a directory (including all subdirectories)
         * 
         * @param directoryPath The path to the directory
         * @return Total size in bytes, or -1 if directory not found
         */
        public long getDirectorySize(String directoryPath) {
            // Implementation goes here
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: Count the total number of files in a directory (including subdirectories)
         * 
         * @param directoryPath The path to the directory
         * @return Number of files, or -1 if directory not found
         */
        public int countFiles(String directoryPath) {
            // Implementation goes here
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: Get the full path of a FileNode
         * 
         * @param node The FileNode
         * @return The full path string
         */
        public String getPath(FileNode node) {
            // Implementation goes here
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: Check if a directory is empty
         * 
         * @param directoryPath The path to the directory
         * @return true if empty, false if not empty or not a directory
         */
        public boolean isDirectoryEmpty(String directoryPath) {
            // Implementation goes here
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * Get the root node (for testing purposes)
         */
        public FileNode getRoot() {
            return root;
        }
    }
    
    /**
     * Main method to demonstrate the file system tree functionality
     * This shows how the Tree-based file system would work when implemented
     */
    public static void main(String[] args) {
        System.out.println("=== File System Tree Demo ===\n");
        
        try {
            FileSystemTree fileSystem = new FileSystemTree("root");
            
            System.out.println("Creating file system structure...");
            
            // Create directory structure
            fileSystem.addFile("/", "home", true, 0);
            fileSystem.addFile("/", "usr", true, 0);
            fileSystem.addFile("/", "var", true, 0);
            fileSystem.addFile("/", "config.txt", false, 1024);
            
            fileSystem.addFile("/home", "alice", true, 0);
            fileSystem.addFile("/home", "bob", true, 0);
            fileSystem.addFile("/home", "shared.txt", false, 2048);
            
            fileSystem.addFile("/home/alice", "documents", true, 0);
            fileSystem.addFile("/home/alice", "photos", true, 0);
            fileSystem.addFile("/home/alice", "profile.txt", false, 512);
            
            fileSystem.addFile("/home/alice/documents", "resume.pdf", false, 3072);
            fileSystem.addFile("/home/alice/documents", "notes.txt", false, 1536);
            fileSystem.addFile("/home/alice/photos", "vacation.jpg", false, 5120);
            
            System.out.println("File system created successfully!");
            System.out.println();
            
            System.out.println("Listing root directory contents:");
            String[] rootContents = fileSystem.listDirectory("/");
            for (String item : rootContents) {
                System.out.println("  " + item);
            }
            System.out.println();
            
            System.out.println("Listing /home directory contents:");
            String[] homeContents = fileSystem.listDirectory("/home");
            for (String item : homeContents) {
                System.out.println("  " + item);
            }
            System.out.println();
            
            System.out.println("Finding specific files:");
            FileNode resumeFile = fileSystem.findFile("/home/alice/documents/resume.pdf");
            if (resumeFile != null) {
                System.out.println("Found: " + resumeFile);
                System.out.println("Full path: " + fileSystem.getPath(resumeFile));
            }
            System.out.println();
            
            System.out.println("Directory size calculations:");
            long homeSize = fileSystem.getDirectorySize("/home");
            long aliceSize = fileSystem.getDirectorySize("/home/alice");
            System.out.println("/home total size: " + homeSize + " bytes");
            System.out.println("/home/alice total size: " + aliceSize + " bytes");
            System.out.println();
            
            System.out.println("File counting:");
            int totalFiles = fileSystem.countFiles("/");
            int homeFiles = fileSystem.countFiles("/home");
            System.out.println("Total files in system: " + totalFiles);
            System.out.println("Files in /home: " + homeFiles);
            System.out.println();
            
            System.out.println("Directory status checks:");
            System.out.println("/var is empty: " + fileSystem.isDirectoryEmpty("/var"));
            System.out.println("/home is empty: " + fileSystem.isDirectoryEmpty("/home"));
            System.out.println();
            
            System.out.println("Deleting a file:");
            boolean deleted = fileSystem.deleteFile("/home/alice/profile.txt");
            System.out.println("Deleted profile.txt: " + deleted);
            
            System.out.println("Trying to delete non-empty directory:");
            boolean deletedDir = fileSystem.deleteFile("/home/alice");
            System.out.println("Deleted /home/alice (should fail): " + deletedDir);
            
        } catch (UnsupportedOperationException e) {
            System.out.println("⚠️  Methods not implemented yet!");
            System.out.println("Please implement the TODO methods to see this demo in action.");
            System.out.println();
            System.out.println("Methods to implement:");
            System.out.println("- addFile()");
            System.out.println("- findFile()");
            System.out.println("- deleteFile()");
            System.out.println("- listDirectory()");
            System.out.println("- getDirectorySize()");
            System.out.println("- countFiles()");
            System.out.println("- getPath()");
            System.out.println("- isDirectoryEmpty()");
        }
    }
}