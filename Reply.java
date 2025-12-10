package com.example.canteenfeedbackapp; // Make sure this package name matches


import java.util.Date;


public class Reply {

    // --- Attributes ---
    private int replyID;
    private String replyText;
    private User poster; // The user who wrote this reply
    private Date timestamp; // The time this reply was posted

    // --- Constructor ---
    public Reply(int replyID, String replyText, User poster) {
        this.replyID = replyID;
        this.replyText = replyText;
        this.poster = poster;
        this.timestamp = new Date(); // Automatically set the post time to "now"
    }

    // --- Getters and Setters ---

    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}