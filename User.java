package com.example.canteenfeedbackapp; // Make sure this package name matches


public class User {

    // 1. Attributes - using private for Encapsulation
    private int userID;
    private String username;
    private String password;

    // 2. Constructor - used to create new User objects
    public User(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    // 3. Methods
    public void login() {
        // Code for login logic goes here
        System.out.println(username + " has logged in.");
    }

    public void logout() {
        // Code for logout logic goes here
        System.out.println(username + " has logged out.");
    }

    // 4. Getters and Setters - allows safe external access to private attributes
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // (We usually don't provide a getter for password for security)
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
