package com.example.quizz;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Result1Activity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button btnRestart, btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = findViewById(R.id.tvres);
        tv2 = findViewById(R.id.tvres2);
        tv3 = findViewById(R.id.tvres3);
        btnRestart = findViewById(R.id.btnRestart);
        btnlogout = findViewById(R.id.btnlogout);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: ").append(Questions1Activity.correct).append("\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: ").append(Questions1Activity.wrong).append("\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: ").append(Questions1Activity.correct).append("\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);

        Questions1Activity.correct=0;
        Questions1Activity.wrong=0;

        btnRestart.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(),TopicsActivity.class);
            startActivity(in);
        });
        btnlogout.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });
    }

}

