package com.example.canteenfeedbackapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the FINAL version of MainActivity.java
 * All 3 buttons are now working.
 */
public class MainActivity extends AppCompatActivity {

    // UI elements
    private EditText editTextDishName;
    private RatingBar ratingBarDish;
    private EditText editTextComments;
    private Button buttonSubmit;
    private Button buttonViewList;
    private Button buttonViewInsights; // <-- The final button
    private TextView textViewCurrentUser;
    private Button buttonLoginStudent;
    private Button buttonLoginLecturer;

    // Backend
    private FeedbackManagement feedbackManager;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feedbackManager = FeedbackManagement.getInstance();
        currentUser = null;

        // Find all UI elements
        editTextDishName = findViewById(R.id.editTextDishName);
        ratingBarDish = findViewById(R.id.ratingBarDish);
        editTextComments = findViewById(R.id.editTextComments);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonViewList = findViewById(R.id.buttonViewList);
        buttonViewInsights = findViewById(R.id.buttonViewInsights); // <-- Find the final button
        textViewCurrentUser = findViewById(R.id.textViewCurrentUser);
        buttonLoginStudent = findViewById(R.id.buttonLoginStudent);
        buttonLoginLecturer = findViewById(R.id.buttonLoginLecturer);

        // --- Login Button Listeners ---
        buttonLoginStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentUser = new Student(1, "testStudent", "pass123");
                textViewCurrentUser.setText("Current User: testStudent (Student)");
                Toast.makeText(MainActivity.this, "Logged in as Student", Toast.LENGTH_SHORT).show();
            }
        });

        buttonLoginLecturer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentUser = new Lecturer(2, "testLecturer", "pass456");
                textViewCurrentUser.setText("Current User: testLecturer (Lecturer)");
                Toast.makeText(MainActivity.this, "Logged in as Lecturer", Toast.LENGTH_SHORT).show();
            }
        });

        // --- Submit Button Listener ---
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFeedback();
            }
        });

        // --- "View List" Button Listener ---
        buttonViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FeedbackListActivity.class);
                startActivity(intent);
            }
        });

        // --- (NEW) "View Insights" Button Listener ---
        buttonViewInsights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open the InsightsActivity page
                Intent intent = new Intent(MainActivity.this, InsightsActivity.class);
                startActivity(intent); // This command opens the new page
            }
        });
    }

    /**
     * This method is called when the user clicks the submit button.
     */
    private void submitFeedback() {
        if (currentUser == null) {
            Toast.makeText(this, "Please select a user (Student or Lecturer) first", Toast.LENGTH_LONG).show();
            return;
        }

        String dishName = editTextDishName.getText().toString();
        int rating = (int) ratingBarDish.getRating();
        String comments = editTextComments.getText().toString();

        // --- UPDATED: Let's add some real tags! ---
        List<String> tags = new ArrayList<>();
        // Simple logic: if comments contain "spicy", add the tag
        if (comments.toLowerCase().contains("spicy")) {
            tags.add("spicy");
        }
        if (comments.toLowerCase().contains("healthy")) {
            tags.add("healthy");
        }
        if (tags.isEmpty()) {
            tags.add("general"); // Add a default tag if none found
        }

        if (dishName.isEmpty() || rating == 0) {
            Toast.makeText(this, "Please enter a dish name and rating", Toast.LENGTH_SHORT).show();
            return;
        }

        int feedbackID = feedbackManager.getFeedbackList().size() + 1;
        Feedback newFeedback = new Feedback(feedbackID, dishName, rating, comments, tags, currentUser);

        feedbackManager.addFeedback(newFeedback);

        Toast.makeText(this, "Feedback Submitted!", Toast.LENGTH_LONG).show();
        editTextDishName.setText("");
        ratingBarDish.setRating(0);
        editTextComments.setText("");
    }
}
