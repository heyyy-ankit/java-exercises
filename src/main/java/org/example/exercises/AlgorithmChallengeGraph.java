package org.example.exercises;

import java.util.*;

/**
 * Algorithm Challenge: Graph Traversal
 * 
 * This exercise focuses on implementing graph algorithms for a social network.
 * You'll need to implement methods for finding friends, suggesting connections,
 * and finding the shortest path between users.
 */
public class AlgorithmChallengeGraph {

    /**
     * Class representing a user in the social network
     */
    static class User {
        private String id;
        private String name;
        
        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }
        
        public String getId() {
            return id;
        }
        
        public String getName() {
            return name;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(id, user.id);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
        
        @Override
        public String toString() {
            return name + " (" + id + ")";
        }
    }
    
    /**
     * Class representing the social network
     */
    static class SocialNetwork {
        // Map of users to their friends list
        private Map<User, List<User>> friendships;
        
        public SocialNetwork() {
            friendships = new HashMap<>();
        }
        
        /**
         * Add a user to the network
         */
        public void addUser(User user) {
            friendships.putIfAbsent(user, new ArrayList<>());
        }
        
        /**
         * Add a friendship connection (bidirectional)
         */
        public void addFriendship(User user1, User user2) {
            friendships.get(user1).add(user2);
            friendships.get(user2).add(user1);
        }
        
        /**
         * TODO: Implement this method to get all friends of a user
         * @param user The user to get friends for
         * @return A list of the user's friends
         */
        public List<User> getFriends(User user) {
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: Implement this method to get friends of friends of a user
         * (who are not already direct friends and not the user themselves)
         * 
         * @param user The user to find friend suggestions for
         * @return A list of suggested friends (friends of friends)
         */
        public List<User> getFriendSuggestions(User user) {
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: Implement Breadth-First Search to find the shortest path between users
         * 
         * @param start The starting user
         * @param end The target user
         * @return List of users representing the path from start to end, or empty list if no path exists
         */
        public List<User> findShortestPath(User start, User end) {
            throw new UnsupportedOperationException("Method not implemented yet");
        }
        
        /**
         * TODO: Implement this method to find users within a certain degree of separation
         * 
         * @param user The reference user
         * @param maxDegree Maximum degrees of separation
         * @return A map where the key is the degree (1, 2, ...) and the value is the list of users at that degree
         */
        public Map<Integer, List<User>> getUsersByDegree(User user, int maxDegree) {
            throw new UnsupportedOperationException("Method not implemented yet");
        }
    }
    
    public static void main(String[] args) {
        // Create a social network
        SocialNetwork network = new SocialNetwork();
        
        // Create users
        User alice = new User("U1", "Alice");
        User bob = new User("U2", "Bob");
        User charlie = new User("U3", "Charlie");
        User david = new User("U4", "David");
        User eve = new User("U5", "Eve");
        User frank = new User("U6", "Frank");
        User grace = new User("U7", "Grace");
        
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
        
        // Test your implementations
        /*
        // Test getFriends
        System.out.println("Alice's friends:");
        List<User> aliceFriends = network.getFriends(alice);
        for (User friend : aliceFriends) {
            System.out.println("- " + friend);
        }
        
        // Test getFriendSuggestions
        System.out.println("\nFriend suggestions for Alice:");
        List<User> suggestions = network.getFriendSuggestions(alice);
        for (User suggestion : suggestions) {
            System.out.println("- " + suggestion);
        }
        
        // Test findShortestPath
        System.out.println("\nShortest path from Alice to Grace:");
        List<User> path = network.findShortestPath(alice, grace);
        if (path.isEmpty()) {
            System.out.println("No path exists");
        } else {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
        
        // Test getUsersByDegree
        System.out.println("\nUsers by degree of separation from Alice:");
        Map<Integer, List<User>> usersByDegree = network.getUsersByDegree(alice, 3);
        for (Map.Entry<Integer, List<User>> entry : usersByDegree.entrySet()) {
            System.out.println("Degree " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println("- " + user);
            }
        }
        */
    }
}