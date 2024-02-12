package com.example.gpa_adunooria1_calculator;

import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class gpaMain extends AppCompatActivity {

    private EditText editTextCourse1, editTextCourse2, editTextCourse3, editTextCourse4, editTextCourse5;
    private TextView textViewGPA;
    private Button buttonComputeGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_main);

        editTextCourse1 = findViewById(R.id.editTextCourse1);
        editTextCourse2 = findViewById(R.id.editTextCourse2);
        editTextCourse3 = findViewById(R.id.editTextCourse3);
        editTextCourse4 = findViewById(R.id.editTextCourse4);
        editTextCourse5 = findViewById(R.id.editTextCourse5);
        textViewGPA = findViewById(R.id.textViewGPA);
        buttonComputeGPA = findViewById(R.id.buttonComputeGPA);

        buttonComputeGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonComputeGPA.getText().equals("Clear Form")) {
                    clearForm();
                    buttonComputeGPA.setText("Compute GPA");
                } else {
                    computeGPA();
                    buttonComputeGPA.setText("Clear Form");
                }
            }
        });
    }

    private void computeGPA() {
        String course1 = editTextCourse1.getText().toString().trim();
        String course2 = editTextCourse2.getText().toString().trim();
        String course3 = editTextCourse3.getText().toString().trim();
        String course4 = editTextCourse4.getText().toString().trim();
        String course5 = editTextCourse5.getText().toString().trim();

        if (course1.isEmpty() || course2.isEmpty() || course3.isEmpty() || course4.isEmpty() || course5.isEmpty()) {
            textViewGPA.setText("Please fill in all fields.");
            return;
        }

        double grade1 = Double.parseDouble(course1);
        double grade2 = Double.parseDouble(course2);
        double grade3 = Double.parseDouble(course3);
        double grade4 = Double.parseDouble(course4);
        double grade5 = Double.parseDouble(course5);

        // Calculate GPA
        double gpa = (grade1 + grade2 + grade3 + grade4 + grade5) / 5.0;

        textViewGPA.setText("GPA: " + gpa);

        // Change background color based on GPA range
        if (gpa < 60) {
            textViewGPA.setBackgroundColor(Color.RED);
        } else if (gpa >= 60 && gpa <= 79) {
            textViewGPA.setBackgroundColor(Color.YELLOW);
        } else {
            textViewGPA.setBackgroundColor(Color.GREEN);
        }
    }

    private void clearForm() {
        editTextCourse1.setText("");
        editTextCourse2.setText("");
        editTextCourse3.setText("");
        editTextCourse4.setText("");
        editTextCourse5.setText("");
        textViewGPA.setText("");
        textViewGPA.setBackgroundColor(Color.TRANSPARENT);
    }
}
