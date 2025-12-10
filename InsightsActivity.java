package com.example.canteenfeedbackapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * This is the code for our Insights page.
 * It gets data from the "Brain" (FeedbackManagement) and displays it.
 */
public class InsightsActivity extends AppCompatActivity {

    // --- 1. Declare our UI elements ---
    private TextView textViewAverageRating;
    private TextView textViewTopDishes;
    private TextView textViewTagFrequency;

    // --- 2. Declare our Backend "Brain" ---
    private FeedbackManagement feedbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insights); // Connects to activity_insights.xml

        // --- 3. Find the UI elements from the .xml file ---
        textViewAverageRating = findViewById(R.id.textViewAverageRating);
        textViewTopDishes = findViewById(R.id.textViewTopDishes);
        textViewTagFrequency = findViewById(R.id.textViewTagFrequency);

        // --- 4. Get the Singleton instance of our "Brain" ---
        feedbackManager = FeedbackManagement.getInstance();

        // --- 5. Load and display all the insights ---
        loadAverageRating();
        loadTopDishes();
        loadTagFrequency();
    }

    /**
     * Gets the average rating and displays it.
     */
    private void loadAverageRating() {
        double avg = feedbackManager.calculateAverageRating();
        // Format the number to 2 decimal places
        String avgText = String.format("%.2f / 5.0 Stars", avg);
        textViewAverageRating.setText(avgText);
    }

    /**
     * Gets the top 3 dishes and displays them.
     */
    private void loadTopDishes() {
        List<Feedback> topDishes = feedbackManager.getTopThreeFeedback();

        if (topDishes.isEmpty()) {
            textViewTopDishes.setText("No feedback submitted yet.");
            return;
        }

        StringBuilder topDishesText = new StringBuilder();
        int rank = 1;
        for (Feedback fb : topDishes) {
            topDishesText.append(rank + ". " + fb.getDishName() + " (" + fb.getRating() + " Stars)\n");
            rank++;
        }
        textViewTopDishes.setText(topDishesText.toString());
    }

    /**
     * Gets the tag frequency and displays it.
     */
    private void loadTagFrequency() {
        Map<String, Integer> tags = feedbackManager.getTagFrequency();

        if (tags.isEmpty()) {
            textViewTagFrequency.setText("No tags used yet.");
            return;
        }

        StringBuilder tagText = new StringBuilder();
        // Loop through each entry (e.g., "spicy", 5) in the map
        for (Map.Entry<String, Integer> entry : tags.entrySet()) {
            tagText.append(entry.getKey() + ": " + entry.getValue() + " times\n");
        }
        textViewTagFrequency.setText(tagText.toString());
    }
}