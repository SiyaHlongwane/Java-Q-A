package com.example.javaqa;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Quiz extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionTxt, questionTxt;
    RadioButton optionA, optionB, optionC, optionD;
    Button next;
    int score = 0;
    int total_question = questionAnswer.question.length;
    int currentIndex = 0;
    String selectedAnswer = "";


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitvity_quiz);

        totalQuestionTxt = findViewById(R.id.totalQuestions);
        questionTxt = findViewById(R.id.question);
        optionA = findViewById(R.id.Answer_A);
        optionB = findViewById(R.id.Answer_B);
        optionC = findViewById(R.id.Answer_C);
        optionD = findViewById(R.id.Answer_D);
        next = findViewById(R.id.submit_btn);

        optionA.setOnClickListener(this);
        optionB.setOnClickListener(this);
        optionC.setOnClickListener(this);
        optionD.setOnClickListener(this);
        next.setOnClickListener(this);

        totalQuestionTxt.setText("Total Questions: " + total_question);

        loadNewQuestion();
    }


    void loadNewQuestion() {
        if (currentIndex == total_question) {
            finishQuiz();
            return;
        }

        questionTxt.setText(questionAnswer.question[currentIndex]);
        optionA.setText(questionAnswer.options[currentIndex][0]);
        optionB.setText(questionAnswer.options[currentIndex][1]);
        optionC.setText(questionAnswer.options[currentIndex][2]);
        optionD.setText(questionAnswer.options[currentIndex][3]);

        optionA.setChecked(false);
        optionB.setChecked(false);
        optionC.setChecked(false);
        optionD.setChecked(false);
    }


    private void finishQuiz() {
        String grade = (score >= total_question * 0.5) ? "You Passed!!" : "Oops, Failed!";

        new AlertDialog.Builder(this)
                .setTitle(grade)
                .setMessage("Your score is " + score + " out of " + total_question)
                .setPositiveButton("Restart Quiz", (dialogInterface, i) -> restartQuiz())
                .show();  // Show the alert dialog
    }

    private void restartQuiz() {
        score = 0;
        currentIndex = 0;
        next.setText("Next");
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {
        if (view instanceof RadioButton) {
            RadioButton clickedRadioButton = (RadioButton) view;
            selectedAnswer = clickedRadioButton.getText().toString();

        } else if (view.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(questionAnswer.correctAnswer[currentIndex])) {
                score++;
            }

            currentIndex++;

            if (currentIndex < total_question) {
                loadNewQuestion();
            } else {
                finishQuiz();
            }
            if(currentIndex == total_question-1){
                next.setText("Submit");
            }
        }
    }
}
