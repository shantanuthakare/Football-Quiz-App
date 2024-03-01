package com.example.footballquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions = {
            "Q. 1  Brazil has won the most World Cups?",
            "Q.2 Real Madrid is the club with the most Champions League titles?",
            "Q.3 Lionel Messi is the all-time top goalscorer in the Champions League?",
            "Q.4 Cristiano Ronaldo has won 7 Ballon d'Or awards?",
            "Q.5 The Super Ballon d'Or winner for 2029 has been announced?",
            "Q.6 The World Cup is held every three years?",
            "Q.7 Which player has won the most Champions League titles" +
                    "REALMADRID(YES) OR BARCELONA (NO)?",
            "Q.8 Which team has won the most UEFA Europa League titles" +
                    "MANCHESTER UNITED(YES) OR SEVILLA(NO)?",
            "Q.9 Which country has won the most Olympic football tournaments " +
                    "ARGENTINA(YES) OR BRAZIL(NO) ?",
            "Q.10 Who holds the record for the most goals scored in a single World Cup tournament" +
                    "DAVID BECKHAM (YES) OR Just Fontaine (NO)?"
    };
    private boolean[] answers = {
            false,
            true,
            false,
            true,
            true,
            false,
            true, // Real Madrid has won the most Champions League titles with 13 titles
            true, // Sevilla has won the most UEFA Europa League titles with 5 titles
            true, // Brazil has won the most Olympic football tournaments with 2 titles
            false // Just Fontaine holds the record for the most goals scored in a single World Cup tournament with 13 goals
    };
    private int score = 0;
    Button yes;
    Button no;
    TextView question;

    private int index= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the array is not going out of bounds
                if (index < questions.length) {
                    // If you have given correct answer
                    if(answers[index]){
                        score++;
                    }
                    // Go to the next question
                    index++;
                    if (index < questions.length) {
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }

        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the array is not going out of bounds
                if (index < questions.length) {
                    // If you have given correct answer
                    if(!answers[index]){
                        score++;
                    }
                    // Go to the next question
                    index++;
                    if (index < questions.length) {
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}