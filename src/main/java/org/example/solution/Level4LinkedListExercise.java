package org.example.solution;

/**
 * Level 4 Exercise: Playlist Management using LinkedList
 * 
 * This exercise simulates a music playlist where songs can be added, removed, 
 * and navigated through. This is a real-world scenario where LinkedList 
 * operations are commonly used.
 */
public class Level4LinkedListExercise {

    /**
     * Node class representing a song in the playlist
     */
    public static class Song {
        String title;
        String artist;
        int duration; // in seconds
        Song next;
        
        public Song(String title, String artist, int duration) {
            this.title = title;
            this.artist = artist;
            this.duration = duration;
            this.next = null;
        }
        
        @Override
        public String toString() {
            return title + " by " + artist + " (" + duration + "s)";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Song song = (Song) obj;
            return duration == song.duration && 
                   title.equals(song.title) && 
                   artist.equals(song.artist);
        }
    }
    
    /**
     * Simple Playlist class using LinkedList implementation
     */
    public static class Playlist {
        private Song head;
        private Song current; // currently playing song
        private int size;
        
        public Playlist() {
            this.head = null;
            this.current = null;
            this.size = 0;
        }
        
        /**
         * TODO: Add a song to the end of the playlist
         * 
         * @param title The song title
         * @param artist The artist name
         * @param duration The song duration in seconds
         */
        public void addSong(String title, String artist, int duration) {
          Song newSong = new Song(title, artist, duration);
          if (this.head == null) { // Matlab playlist abhi empty hai
            this.head = newSong;
          } else {
            Song temp = this.head;
            while (temp.next != null) {
              temp = temp.next;
            }
            temp.next = newSong;
          }
          this.size++;
        }
        
        /**
         * TODO: Remove the first occurrence of a song with the given title
         * 
         * @param title The title of the song to remove
         * @return true if song was found and removed, false otherwise
         */
        public boolean removeSong(String title) {
          if (this.head == null) { // Playlist empty wala case
            return false;
          }

          Song prev = null;
          Song temp = this.head;
          while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            prev = temp;
            temp = temp.next;
          }
          if (temp == null) {
            return false; // song playlist me available nahi hai 
          }
          if (prev == null) { // matlab phela wala song hi hai jisko remove karna hai
            if (this.head == this.current) {
              this.current = this.current.next;
            }
            this.head = this.head.next;
            this.size--;
            return true;
          }
          if (this.current == temp) { // matlab jo song remove kar rahe, wohi play ho rha hai
            this.current = nextSong();
          }
          prev.next = temp.next; // temp jisko point kar rha hai remove kardo wo wale song ko
          this.size--;
          return true;
        }
        
        /**
         * TODO: Get the currently playing song
         * 
         * @return The current song, or null if no song is playing
         */
        public Song getCurrentSong() {
          return this.current;
        }
        
        /**
         * TODO: Move to the next song in the playlist
         * If at the end, wrap around to the beginning
         * 
         * @return The next song, or null if playlist is empty
         */
        public Song nextSong() {
          if (this.head == null) { // playlist empty hai
            return this.head;
          }
          if (this.current == null) { // koi sa bhi song play nahi ho rha hai
            this.current = this.head;
            return this.current;
          }
          if (this.current.next == null) { // last song play ho rha hai
            this.current = this.head;
          } else {
            this.current = this.current.next; // normal case koi beech wala song hai
          }
          return this.current;
        }
        
        /**
         * TODO: Calculate the total duration of all songs in the playlist
         * 
         * @return Total duration in seconds
         */
        public int getTotalDuration() {
          if (this.head == null) {
            return 0;
          }
          Song temp = this.head;
          int duration = 0;
          while (temp != null) {
            duration += temp.duration;
            temp = temp.next;
          }
          return duration;
        }
        
        /**
         * TODO: Find a song by title
         * 
         * @param title The title to search for
         * @return The song if found, null otherwise
         */
        public Song findSong(String title) {
          if (this.head == null) { // Playlist empty wala case
            return null;
          }
          Song temp = this.head;
          while (temp != null && !temp.title.contains(title)) {
            temp = temp.next;
          }
          return temp;
        }
        
        /**
         * TODO: Get the number of songs in the playlist
         * 
         * @return The size of the playlist
         */
        public int getSize() {
          return this.size;
        }
        
        /**
         * TODO: Check if the playlist is empty
         * 
         * @return true if empty, false otherwise
         */
        public boolean isEmpty() {
          return this.size == 0;
        }
        
        /**
         * TODO: Start playing from the first song
         * 
         * @return The first song, or null if playlist is empty
         */
        public Song play() {
          if (this.head == null) {
            return null;
          }
          this.current = this.head;
          return this.current;
        }
    }
    
    /**
     * Main method to demonstrate the playlist functionality
     * This shows how the LinkedList-based playlist would work when implemented
     */
    public static void main(String[] args) {
        System.out.println("=== Music Playlist Demo ===\n");
        
        try {
            Playlist myPlaylist = new Playlist();
            
            System.out.println("Creating empty playlist...");
            System.out.println("Is empty: " + myPlaylist.isEmpty());
            System.out.println("Size: " + myPlaylist.getSize());
            System.out.println();
            
            System.out.println("Adding songs to playlist...");
            myPlaylist.addSong("Bohemian Rhapsody", "Queen", 355);
            myPlaylist.addSong("Stairway to Heaven", "Led Zeppelin", 482);
            myPlaylist.addSong("Hotel California", "Eagles", 391);
            myPlaylist.addSong("Imagine", "John Lennon", 183);
            
            System.out.println("Playlist size: " + myPlaylist.getSize());
            System.out.println("Total duration: " + myPlaylist.getTotalDuration() + " seconds");
            System.out.println();
            
            System.out.println("Starting playback...");
            Song currentSong = myPlaylist.play();
            System.out.println("Now playing: " + currentSong);
            System.out.println();
            
            System.out.println("Navigating through playlist...");
            for (int i = 0; i < 5; i++) {
                Song nextSong = myPlaylist.nextSong();
                System.out.println("Next song: " + nextSong);
            }
            System.out.println();
            
            System.out.println("Searching for a song...");
            Song found = myPlaylist.findSong("Imagine");
            if (found != null) {
                System.out.println("Found: " + found);
            } else {
                System.out.println("Song not found");
            }
            System.out.println();
            
            System.out.println("Removing a song...");
            boolean removed = myPlaylist.removeSong("Hotel California");
            System.out.println("Removed Hotel California: " + removed);
            System.out.println("New playlist size: " + myPlaylist.getSize());
            System.out.println("New total duration: " + myPlaylist.getTotalDuration() + " seconds");
            
        } catch (UnsupportedOperationException e) {
            System.out.println("⚠️  Methods not implemented yet!");
            System.out.println("Please implement the TODO methods to see this demo in action.");
            System.out.println();
            System.out.println("Methods to implement:");
            System.out.println("- addSong()");
            System.out.println("- removeSong()");
            System.out.println("- getCurrentSong()");
            System.out.println("- nextSong()");
            System.out.println("- getTotalDuration()");
            System.out.println("- findSong()");
            System.out.println("- getSize()");
            System.out.println("- isEmpty()");
            System.out.println("- play()");
        }
    }
}