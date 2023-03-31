package com.example.myapplication777;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainActivity1 {
    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;

    private final Question question = new Question();
    private int questionNumer = 0;
    private String answer;
    public int scor = 0;
    private final int questionLength = question.questions.length;

    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_question.setText(question.questions[0]);
        random = new Random();


        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNumer ++;
                scor += 3;
                if(questionNumer < questionLength) {
                    tv_question.setText(question.questions[questionNumer]);
                } else {
                    tv_question.setText("Ai terminat cu scorul de:" + scor);
                }


            }
        });
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNumer ++;
                scor += 2;
                if(questionNumer < questionLength) {
                    tv_question.setText(question.questions[questionNumer]);
                } else {
                    tv_question.setText("Ai terminat cu scorul de:" + scor);
                }


            }
        });
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionNumer ++;
                scor += 1;
                if(questionNumer < questionLength) {
                    tv_question.setText(question.questions[questionNumer]);
                } else {
                    tv_question.setText("Ai terminat cu scorul de:" + scor);
                }


            }
        });
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener((View.OnClickListener) this);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener((View.OnClickListener) this);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_four.setOnClickListener((View.OnClickListener) this);

        tv_question = (TextView)findViewById(R.id.tv_question);

        //NextQuestion(random.nextInt(questionLength));
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                if(btn_one.getText() == answer){
                    Toast.makeText(MainActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionLength));
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_two:
                if(btn_two.getText() == answer){
                    Toast.makeText(MainActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionLength));
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_three:
                if(btn_three.getText() == answer){
                    Toast.makeText(MainActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionLength));
                }else{
                    GameOver();
                }

                break;

            case R.id.btn_four:
                if(btn_four.getText() == answer){
                    Toast.makeText(MainActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    NextQuestion(random.nextInt(questionLength));
                }else{
                    GameOver();
                }

                break;
        }
    }

    private void GameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over")
                .setCancelable(false)
                .setPositiveButton("New Game", (dialog, which) -> startActivity(new Intent(getApplicationContext(), MainActivity.class)))
                .setNegativeButton("Exit", (dialog, which) -> System.exit(0));
        alertDialogBuilder.show();

    }

    private void NextQuestion(int num){
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));

        answer = question.getCorrectAnswer(num);
    }
}