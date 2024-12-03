package malanc.realestateapp.DataStore;

import malanc.realestateapp.UserType.CustomerUser;
import malanc.realestateapp.Models.User;
import malanc.realestateapp.UserType.AgentUser;
import malanc.realestateapp.UserType.OwnerUser;
import malanc.realestateapp.UserType.AdminUser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStoreUser {
    // List to store all users in the system
    public static List<User> users = new ArrayList<>();

    static {
        // Sample users added directly to the list
        users.add(new AdminUser("John", "Doe", "1234567890", "admin", "adminpass", "admin@example.com"));
        users.add(new CustomerUser("Jane", "Smith", "0987654321", "customer1", "custpass", "customer1@example.com"));
        users.add(new CustomerUser("Emily", "Johnson", "5678901234", "customer2", "custpass2", "customer2@example.com"));
        users.add(new OwnerUser("Michael", "Brown", "2345678901", "owner1", "ownerpass", "owner1@example.com"));
        users.add(new OwnerUser("Sarah", "Davis", "6789012345", "owner2", "ownerpass2", "owner2@example.com"));
        users.add(new AgentUser("Daniel", "Wilson", "3456789012", "agent1", "agentpass", "agent1@example.com"));
        users.add(new AgentUser("Emma", "Taylor", "7890123456", "agent2", "agentpass2", "agent2@example.com"));
        // Add more sample users as needed...
    }

    
    // Method to add a user to the list
    public static void addUser(User user) {
        users.add(user);
    }

    // Method to find a user by username
    public static User findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null); // Return null if no user with the given username is found
    }

    // Method to get all users (for display or administrative purposes)
    public static List<User> getAllUsers() {
        return users;
    }

    // Method to get a list of agent real names
    public static List<String> getAgentRealNames() {
        return users.stream()
                .filter(user -> user instanceof AgentUser) // Filter to get only agents
                .map(user -> user.getFirstName() + " " + user.getLastName()) // Map to full names (first and last name)
                .collect(Collectors.toList()); // Collect to list
    }

    // Method to remove a user (optional, for admin management)
    public static boolean removeUser(String username) {
        return users.removeIf(user -> user.getUsername().equalsIgnoreCase(username));
    }
    
    // Method to authenticate a user by username and password
    public static User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Return the user if credentials match
            }
        }
        return null; // Return null if no match is found
    }
}
