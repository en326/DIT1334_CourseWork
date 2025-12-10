package com.example.canteenfeedbackapp; // Make sure this package name matches

// Using the "extends" keyword to implement Inheritance
public class Student extends User {

    // Constructor
    public Student(int userID, String username, String password) {
        // "super()" calls the constructor of the parent class (User)
        super(userID, username, password);
    }


}
