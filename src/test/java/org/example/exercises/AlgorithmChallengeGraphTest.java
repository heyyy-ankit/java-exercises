package org.example.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AlgorithmChallengeGraph
 */
public class AlgorithmChallengeGraphTest {
    
    private AlgorithmChallengeGraph.SocialNetwork network;
    private AlgorithmChallengeGraph.User alice, bob, charlie, david, eve, frank, grace;
    
    @BeforeEach
    void setUp() {
        network = new AlgorithmChallengeGraph.SocialNetwork();
        
        // Create users
        alice = new AlgorithmChallengeGraph.User("U1", "Alice");
        bob = new AlgorithmChallengeGraph.User("U2", "Bob");
        charlie = new AlgorithmChallengeGraph.User("U3", "Charlie");
        david = new AlgorithmChallengeGraph.User("U4", "David");
        eve = new AlgorithmChallengeGraph.User("U5", "Eve");
        frank = new AlgorithmChallengeGraph.User("U6", "Frank");
        grace = new AlgorithmChallengeGraph.User("U7", "Grace");
        
        // Add users to network
        network.addUser(alice);
        network.addUser(bob);
        network.addUser(charlie);
        network.addUser(david);
        network.addUser(eve);
        network.addUser(frank);
        network.addUser(grace);
        
        // Create friendships
        network.addFriendship(alice, bob);    // Alice - Bob
        network.addFriendship(alice, charlie); // Alice - Charlie
        network.addFriendship(bob, david);    // Bob - David
        network.addFriendship(charlie, eve);  // Charlie - Eve
        network.addFriendship(david, frank);  // David - Frank
        network.addFriendship(eve, frank);    // Eve - Frank
        network.addFriendship(frank, grace);  // Frank - Grace
        
        // The network looks like:
        //      Alice --- Bob --- David
        //        |                |
        //     Charlie -- Eve      |
        //                  \     /
        //                   Frank -- Grace
    }
    
    @Test
    void testGetFriends() {
        List<AlgorithmChallengeGraph.User> aliceFriends = network.getFriends(alice);
        assertEquals(2, aliceFriends.size(), "Alice should have 2 friends");
        assertTrue(aliceFriends.contains(bob), "Alice should be friends with Bob");
        assertTrue(aliceFriends.contains(charlie), "Alice should be friends with Charlie");
        
        List<AlgorithmChallengeGraph.User> frankFriends = network.getFriends(frank);
        assertEquals(3, frankFriends.size(), "Frank should have 3 friends");
        assertTrue(frankFriends.contains(david), "Frank should be friends with David");
        assertTrue(frankFriends.contains(eve), "Frank should be friends with Eve");
        assertTrue(frankFriends.contains(grace), "Frank should be friends with Grace");
    }
    
    @Test
    void testGetFriendSuggestions() {
        List<AlgorithmChallengeGraph.User> aliceSuggestions = network.getFriendSuggestions(alice);
        assertEquals(2, aliceSuggestions.size(), "Alice should have 2 friend suggestions");
        assertTrue(aliceSuggestions.contains(david), "David should be suggested to Alice");
        assertTrue(aliceSuggestions.contains(eve), "Eve should be suggested to Alice");
        assertFalse(aliceSuggestions.contains(grace), "Grace should not be suggested to Alice (too distant)");
        
        List<AlgorithmChallengeGraph.User> eveSuggestions = network.getFriendSuggestions(eve);
        assertEquals(3, eveSuggestions.size(), "Eve should have 3 friend suggestions");
        assertTrue(eveSuggestions.contains(alice), "Alice should be suggested to Eve");
        assertTrue(eveSuggestions.contains(david), "David should be suggested to Eve");
        assertTrue(eveSuggestions.contains(grace), "Grace should be suggested to Eve");
    }
    
    @Test
    void testFindShortestPath() {
        List<AlgorithmChallengeGraph.User> path = network.findShortestPath(alice, grace);
        assertEquals(5, path.size(), "Path from Alice to Grace should have 5 nodes");
        assertEquals(alice, path.get(0), "Path should start with Alice");
        assertEquals(grace, path.get(path.size() - 1), "Path should end with Grace");
        
        // Verify path is Alice -> Charlie -> Eve -> Frank -> Grace (or other valid shortest path)
        // Since there are multiple valid paths, we'll check the length and endpoints
        
        // Test non-existent path (e.g., if we remove a node from the network)
        AlgorithmChallengeGraph.User isolated = new AlgorithmChallengeGraph.User("U8", "Isolated");
        network.addUser(isolated);
        
        List<AlgorithmChallengeGraph.User> noPath = network.findShortestPath(alice, isolated);
        assertTrue(noPath.isEmpty(), "Should return empty list when no path exists");
    }
    
    @Test
    void testGetUsersByDegree() {
        Map<Integer, List<AlgorithmChallengeGraph.User>> usersByDegree = network.getUsersByDegree(alice, 3);
        
        assertEquals(3, usersByDegree.size(), "Should have 3 degrees in the result");
        
        // Degree 1 - Direct friends of Alice: Bob, Charlie
        assertEquals(2, usersByDegree.get(1).size(), "Should have 2 users at degree 1");
        assertTrue(usersByDegree.get(1).contains(bob), "Bob should be at degree 1");
        assertTrue(usersByDegree.get(1).contains(charlie), "Charlie should be at degree 1");
        
        // Degree 2 - Friends of friends: David, Eve
        assertEquals(2, usersByDegree.get(2).size(), "Should have 2 users at degree 2");
        assertTrue(usersByDegree.get(2).contains(david), "David should be at degree 2");
        assertTrue(usersByDegree.get(2).contains(eve), "Eve should be at degree 2");
        
        // Degree 3 - Friends of friends of friends: Frank
        assertEquals(1, usersByDegree.get(3).size(), "Should have 1 users at degree 3");
        assertTrue(usersByDegree.get(3).contains(frank), "Frank should be at degree 3");
    }
}