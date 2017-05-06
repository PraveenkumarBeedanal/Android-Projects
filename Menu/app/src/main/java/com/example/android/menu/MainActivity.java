package com.example.android.menu;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }



    public void printToLogs(View view) {

        // Find first menu item TextView and print the text to the logs
        TextView textView1 = (TextView) findViewById(R.id.menu_item_1);
        String menuItem1 =(String) textView1.getText();
        Log.w("MainActivity", menuItem1);


        // Find second menu item TextView and print the text to the logs
        TextView textView2 = (TextView) findViewById(R.id.menu_item_2);
        String menuItem2 =(String) textView2.getText();
        Log.w("MainActivity", menuItem2);


        // Find third menu item TextView and print the text to the logs
        TextView textView3 = (TextView) findViewById(R.id.menu_item_3);
        String menuItem3 =(String) textView3.getText();
        Log.w("MainActivity", menuItem3);


    }

}