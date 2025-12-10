package com.example.canteenfeedbackapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

/**
 *  FeedbackListActivity.java
 * This class calls "getInstance()".
 */
public class FeedbackListActivity extends AppCompatActivity {

    private TextView textViewFeedbackList;
    private FeedbackManagement feedbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_list);

        textViewFeedbackList = findViewById(R.id.textViewFeedbackList);

        // Get the Singleton instance of our "Brain"
        feedbackManager = FeedbackManagement.getInstance();

        loadAndDisplayFeedback();
    }

    private void loadAndDisplayFeedback() {
        List<Feedback> allFeedback = feedbackManager.getFeedbackList();

        if (allFeedback.isEmpty()) {
            textViewFeedbackList.setText("No feedback submitted yet.");
            return;
        }

        StringBuilder feedbackText = new StringBuilder();
        for (Feedback fb : allFeedback) {
            feedbackText.append("Dish: " + fb.getDishName() + "\n");
            feedbackText.append("Rating: " + fb.getRating() + " / 5 Stars\n");
            feedbackText.append("Comments: " + fb.getComments() + "\n");
            feedbackText.append("Submitted by: " + fb.getPoster().getUsername() + "\n");
            feedbackText.append("-----------------------------\n\n");
        }
        textViewFeedbackList.setText(feedbackText.toString());
    }
}