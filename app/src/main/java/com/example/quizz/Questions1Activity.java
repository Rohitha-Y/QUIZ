package com.example.quizz;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questions1Activity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String []questions = {
            "The Satapatha Brahmana and Taitriya Brahmana are the Brahmana texts of _",
            "Who among the following was the author of Abhidhamma treatise Kathavatthu?",
            "The last Mauryan ruler, who was killed by his Commander-in-Chief was __?",
            "As per the officials mentioned in the Arthashastra, the duties related to Crown lands was performed by whom ?",
            "Which of the following is / are the 9 gems of Chandragupta Vikramaditya?",
            "The last ruler of the Mauryan Dynasty, who was assassinated by Pushyamitra Sunga, his commander-in-chief was __ ?",
            "The word ” Vihara” in Buddhism means______?",
            "Which among the following philosophy deals with Logic?",
    };
    String []answers = {"Yajurveda","Moggaliputta Tissa","Brihadratha","Sitadhyaksha","All of the above","Brihadrata","Residence of Monks","Nyaya"};
    String [] opt = {
            "Rigveda","Yajurveda","Samaveda","Atharavaveda",
            "Mah-a kassapa","Mahinda","Milinda","Moggaliputta Tissa",
            "Dasaratha","Kun-ala","Samprati","Brihadratha",
            "Kosadhyaksha","Hastyadhyaksha","Lohadhyaksha","Sitadhyaksha",
            "Amarsimha","Harisena","Kahapanaka","All of the above",
            "Bindusara","Chandragupta","Brihadrata","Ashokavardhan",
            "Residence of Monks","Hall of Worship","Congregation Hall","Garden",
            "Yoga","Samkhya","Nyaya","None of the above"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions1);

        final TextView score = (TextView)findViewById(R.id.textView4);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");


        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(v -> {


            if(radio_g.getCheckedRadioButtonId()==-1)
            {
                Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
            String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
            if(ansText.equals(answers[flag])) {
                correct++;
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            }
            else {
                wrong++;
                Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
            }

            flag++;

            if (score != null)
                score.setText(""+correct);

            if(flag<questions.length)
            {
                tv.setText(questions[flag]);
                rb1.setText(opt[flag*4]);
                rb2.setText(opt[flag*4 +1]);
                rb3.setText(opt[flag*4 +2]);
                rb4.setText(opt[flag*4 +3]);
            }
            else
            {
                marks=correct;
                Intent in = new Intent(getApplicationContext(),Result1Activity.class);
                startActivity(in);
            }
            radio_g.clearCheck();
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),Result1Activity.class);
            startActivity(intent1);
        });
    }

}