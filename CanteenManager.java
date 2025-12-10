package com.example.canteenfeedbackapp; // Make sure this package name matches

// CanteenManager also inherits from User
public class CanteenManager extends User {

    // Constructor
    public CanteenManager(int userID, String username, String password) {
        // "super()" calls the constructor of the parent class (User)
        super(userID, username, password);
    }


    /**
     * Updates the status of a specific feedback item.
     * (We will create the Feedback class in the next step)
     */
    public void markFeedbackStatus(Feedback feedback, String newStatus) {
        //  add logic here later, after we create the Feedback class.
        System.out.println("Feedback " + feedback.getFeedbackID() + " status updated to " + newStatus);
    }


    public void generateReports() {
        // Logic for generating reports goes here.
        System.out.println("Generating reports...");
    }
}