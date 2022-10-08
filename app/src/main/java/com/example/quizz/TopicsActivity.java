package com.example.quizz;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class TopicsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
    }

    public void question(android.view.View view) {
        Button topic1 = (Button) findViewById(R.id.topic1);
        topic1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), QuestionsActivity.class);
            startActivity(intent);
        });
    }

    public void question1(View view) {
        Button topic2 = (Button) findViewById(R.id.topic2);
        topic2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Questions1Activity.class);
            startActivity(intent);
        });

    }

    public void question2(View view) {
        Button topic3 = (Button) findViewById(R.id.topic3);
        topic3.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Questions2Activity.class);
            startActivity(intent);
        });
    }
}