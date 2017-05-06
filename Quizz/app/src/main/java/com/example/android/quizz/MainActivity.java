package com.example.android.quizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
        public void answerCheck(View view) {
            int Totalscore=5;
            int score =0;

            CheckBox isbox1= (CheckBox)findViewById(R.id.option_1c);
                    boolean isbox1Checked=isbox1.isChecked();
            if(isbox1Checked)
            {
                score+=1;
            }

            CheckBox isbox2= (CheckBox)findViewById(R.id.option_2a);
            boolean isbox2Checked=isbox2.isChecked();
            if(isbox2Checked)
            {
                score+=1;
            }

            RadioButton isbox3= (RadioButton) findViewById(R.id.option_3d);
            boolean isbox3Checked=isbox3.isChecked();
            if(isbox3Checked)
            {
                score+=1;
            }

            RadioButton isbox4= (RadioButton)findViewById(R.id.option_4b);
            boolean isbox4Checked=isbox4.isChecked();
            if(isbox4Checked)
            {
                score+=1;
            }

            RadioButton isbox5= (RadioButton) findViewById(R.id.option_5b);
            boolean isbox5Checked=isbox5.isChecked();
            if(isbox5Checked)
            {
                score+=1;
            }
                Toast.makeText(this,"you score "+ score +" out of " +   Totalscore, Toast.LENGTH_SHORT).show();




        }


    }




