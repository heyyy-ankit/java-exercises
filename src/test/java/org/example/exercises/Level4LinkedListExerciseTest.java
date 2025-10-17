package org.example.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Level4LinkedListExercise
 */
public class Level4LinkedListExerciseTest {

    private Level4LinkedListExercise.Playlist playlist;
    
    @BeforeEach
    void setUp() {
        playlist = new Level4LinkedListExercise.Playlist();
    }
    
    @Test
    void testAddSong() {
        // Test adding songs to empty playlist
        playlist.addSong("Bohemian Rhapsody", "Queen", 355);
        assertEquals(1, playlist.getSize());
        assertFalse(playlist.isEmpty());
        
        // Test adding multiple songs
        playlist.addSong("Stairway to Heaven", "Led Zeppelin", 482);
        playlist.addSong("Hotel California", "Eagles", 391);
        assertEquals(3, playlist.getSize());
        
        // Test finding added songs
        Level4LinkedListExercise.Song song = playlist.findSong("Bohemian Rhapsody");
        assertNotNull(song);
        assertEquals("Bohemian Rhapsody", song.title);
        assertEquals("Queen", song.artist);
        assertEquals(355, song.duration);
    }
    
    @Test
    void testEmptyPlaylist() {
        // Test empty playlist
        assertTrue(playlist.isEmpty());
        assertEquals(0, playlist.getSize());
        assertNull(playlist.getCurrentSong());
        assertNull(playlist.play());
        assertNull(playlist.nextSong());
        assertEquals(0, playlist.getTotalDuration());
    }
    
    @Test
    void testRemoveSong() {
        // Add some songs
        playlist.addSong("Song 1", "Artist 1", 200);
        playlist.addSong("Song 2", "Artist 2", 250);
        playlist.addSong("Song 3", "Artist 3", 180);
        
        // Test removing existing song
        assertTrue(playlist.removeSong("Song 2"));
        assertEquals(2, playlist.getSize());
        assertNull(playlist.findSong("Song 2"));
        
        // Test removing non-existing song
        assertFalse(playlist.removeSong("Non-existing Song"));
        assertEquals(2, playlist.getSize());
        
        // Test removing first song
        assertTrue(playlist.removeSong("Song 1"));
        assertEquals(1, playlist.getSize());
        
        // Test removing last song
        assertTrue(playlist.removeSong("Song 3"));
        assertEquals(0, playlist.getSize());
        assertTrue(playlist.isEmpty());
    }
    
    @Test
    void testPlayAndNavigation() {
        // Add songs
        playlist.addSong("First Song", "Artist A", 200);
        playlist.addSong("Second Song", "Artist B", 250);
        playlist.addSong("Third Song", "Artist C", 180);
        
        // Test starting playback
        Level4LinkedListExercise.Song currentSong = playlist.play();
        assertNotNull(currentSong);
        assertEquals("First Song", currentSong.title);
        assertEquals(currentSong, playlist.getCurrentSong());
        
        // Test navigation
        Level4LinkedListExercise.Song nextSong = playlist.nextSong();
        assertEquals("Second Song", nextSong.title);
        assertEquals(nextSong, playlist.getCurrentSong());
        
        // Continue navigation
        nextSong = playlist.nextSong();
        assertEquals("Third Song", nextSong.title);
        
        // Test wrapping around
        nextSong = playlist.nextSong();
        assertEquals("First Song", nextSong.title);
    }
    
    @Test
    void testTotalDuration() {
        // Empty playlist
        assertEquals(0, playlist.getTotalDuration());
        
        // Add songs with known durations
        playlist.addSong("Song 1", "Artist 1", 200);
        playlist.addSong("Song 2", "Artist 2", 300);
        playlist.addSong("Song 3", "Artist 3", 150);
        
        assertEquals(650, playlist.getTotalDuration());
    }
    
    @Test
    void testFindSong() {
        playlist.addSong("Imagine", "John Lennon", 183);
        playlist.addSong("Yesterday", "The Beatles", 125);
        
        // Test finding existing songs
        Level4LinkedListExercise.Song song = playlist.findSong("Imagine");
        assertNotNull(song);
        assertEquals("Imagine", song.title);
        assertEquals("John Lennon", song.artist);
        
        // Test finding non-existing song
        assertNull(playlist.findSong("Non-existing"));
        
        // Test case sensitivity
        assertNull(playlist.findSong("imagine")); // lowercase
    }
    
    @Test
    void testSingleSongPlaylist() {
        playlist.addSong("Only Song", "Solo Artist", 240);
        
        Level4LinkedListExercise.Song song = playlist.play();
        assertEquals("Only Song", song.title);
        
        // Next song should wrap to the same song
        Level4LinkedListExercise.Song nextSong = playlist.nextSong();
        assertEquals("Only Song", nextSong.title);
        
        // Remove the only song
        assertTrue(playlist.removeSong("Only Song"));
        assertTrue(playlist.isEmpty());
        assertNull(playlist.getCurrentSong());
    }
    
    @Test
    void testSongEquality() {
        Level4LinkedListExercise.Song song1 = new Level4LinkedListExercise.Song("Test", "Artist", 200);
        Level4LinkedListExercise.Song song2 = new Level4LinkedListExercise.Song("Test", "Artist", 200);
        Level4LinkedListExercise.Song song3 = new Level4LinkedListExercise.Song("Different", "Artist", 200);
        
        assertEquals(song1, song2);
        assertNotEquals(song1, song3);
        assertEquals("Test by Artist (200s)", song1.toString());
    }
}