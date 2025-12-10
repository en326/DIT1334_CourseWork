package com.example.canteenfeedbackapp; // Make sure this package name matches


public class Vote {

    // --- Attributes ---
    private int voteID;
    private User voter; // The User who cast this vote
    private Feedback feedback; // The Feedback that this vote is for

    // --- Constructor ---
    public Vote(int voteID, User voter, Feedback feedback) {
        this.voteID = voteID;
        this.voter = voter;
        this.feedback = feedback;
    }

    // --- Getters and Setters ---

    public int getVoteID() {
        return voteID;
    }

    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}