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

public class Questions2Activity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String []questions = {
            "Which one of the following river flows between Vindhyan and Satpura ranges?",
            "Who among the following wrote Sanskrit grammar?",
            "Tsunamis are not caused by",
            "The language spoken by the people by Pakistan is ?",
            "The World Largest desert is ?",
            "Mount Everest is located in ?",
            "Black soils are best suited for the cultivation of ?",
            "The Gate way of India is ?",
            "The largest river in India is ?",
            "The hottest planet in the solar system ?"
    };
    String []answers = {"Narmada","Panini","Hurricanes","Sindhi","Sahara","Nepal","Cotton","Mumbai","Ganga","Venus"};
    String [] opt = {
            "Narmada","Mahanadi","Son","Netravati",
            "Kalidasa","Charak","Panini","Aryabhatt",
            "Hurricanes","Earthquakes","Undersea landslides","Volcanic eruptions",
            "Hindi","Palauan","Sindhi","Nauruan",
            "Thar","Kalahari","Sahara","Sonoran",
            "India","Nepal","Tibet","China",
            "Cotton","Rice","Cereals","Sugarcane",
            "Chennai","Mumbai","Kolkata","New Delhi”",
            "Yamuna","Kaveri","Ganga","Bramaputra",
            "Earth","Venus","Mars","Jupiter"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions2);

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
                Intent in = new Intent(getApplicationContext(),Result2Activity.class);
                startActivity(in);
            }
            radio_g.clearCheck();
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 =new Intent(getApplicationContext(),Result2Activity.class);
            startActivity(intent1);
        });
    }

}