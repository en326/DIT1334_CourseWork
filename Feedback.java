package com.example.canteenfeedbackapp; // Make sure this package name matches

// We need these imports to use Lists
import java.util.ArrayList;
import java.util.List;


public class Feedback {

    // --- Attributes ---
    private int feedbackID;
    private String dishName;
    private int rating; // Rating from 1 to 5
    private String comments;
    private List<String> tags; // e.g., "spicy", "healthy"
    private String status; // e.g., "Pending", "Resolved"

    // --- Associations (from our Class Diagram) ---
    private User poster; // The User who submitted this feedback
    private List<Reply> replies; // A list to hold all replies to this feedback

    // --- Constructor ---
    public Feedback(int feedbackID, String dishName, int rating, String comments, List<String> tags, User poster) {
        this.feedbackID = feedbackID;
        this.dishName = dishName;
        this.rating = rating;
        this.comments = comments;
        this.tags = tags;
        this.poster = poster;

        this.status = "Pending"; // Default status
        this.replies = new ArrayList<>(); // Initialize an empty list for replies
    }

    // --- Methods ---


    public void addReply(Reply newReply) {
        this.replies.add(newReply);
    }

    // --- Getters and Setters ---


    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}