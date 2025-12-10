package com.example.canteenfeedbackapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class MUST contain the "getInstance()" method.
 */
public class FeedbackManagement {

    // --- Start of Singleton Code ---
    private static FeedbackManagement instance;

    private FeedbackManagement() {
        this.allFeedbackList = new ArrayList<>();
    }

    // This is the "getInstance()" method that was missing
    public static FeedbackManagement getInstance() {
        if (instance == null) {
            instance = new FeedbackManagement();
        }
        return instance;
    }
    // --- End of Singleton Code ---

    private List<Feedback> allFeedbackList;

    // --- Core Methods ---
    public void addFeedback(Feedback feedback) {
        this.allFeedbackList.add(feedback);
    }

    public List<Feedback> getFeedbackList() {
        return this.allFeedbackList;
    }

    public double calculateAverageRating() {
        if (allFeedbackList.isEmpty()) {
            return 0.0;
        }
        double totalRating = 0;
        for (Feedback fb : allFeedbackList) {
            totalRating += fb.getRating();
        }
        return totalRating / allFeedbackList.size();
    }

    public Map<String, Integer> getTagFrequency() {
        Map<String, Integer> tagCounts = new HashMap<>();
        for (Feedback fb : allFeedbackList) {
            for (String tag : fb.getTags()) {
                int currentCount = tagCounts.getOrDefault(tag, 0);
                tagCounts.put(tag, currentCount + 1);
            }
        }
        return tagCounts;
    }

    public List<Feedback> getTopThreeFeedback() {
        List<Feedback> sortedList = new ArrayList<>(allFeedbackList);
        Collections.sort(sortedList, new Comparator<Feedback>() {
            @Override
            public int compare(Feedback f1, Feedback f2) {
                return Integer.compare(f2.getRating(), f1.getRating());
            }
        });
        int max = Math.min(sortedList.size(), 3);
        return sortedList.subList(0, max);
    }
}