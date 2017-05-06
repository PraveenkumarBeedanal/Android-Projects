package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox hasChecked = (CheckBox) findViewById(R.id.WhippedCream_id);
        boolean hasWhippedCream = hasChecked.isChecked();
        CheckBox hasChecked1 = (CheckBox) findViewById(R.id.Chocalate_id);
        boolean hasChocalate = hasChecked1.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocalate);
        EditText nameWritten = (EditText) findViewById(R.id.name);
        String name = nameWritten.getText().toString();
        Log.v("MainActivity", "name" + name);
         creteOrderSummary(price, hasWhippedCream, hasChocalate, name);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    public void increment(View view) {


        if (quantity >= 100) {
            Context context = getApplicationContext();
            CharSequence text = "can not order more than 100";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;

        }
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {

        if (quantity <= 1) {
            Context context = getApplicationContext();
            CharSequence text = "can not order less than 1";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;

        }
        quantity = quantity - 1;
        displayQuantity(quantity);

    }


    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean whippedCreamTrack, boolean chocalateTrack) {
        int pricePerCup = 5;
        int whippedCreamPrice = 1;
        int chocolatePrice = 2;
        int baseFair = 0;
        if (whippedCreamTrack == true && chocalateTrack == true) {
            baseFair = pricePerCup + whippedCreamPrice + chocolatePrice;
        } else if (whippedCreamTrack == true && chocalateTrack == false) {
            baseFair = pricePerCup + whippedCreamPrice;
        } else if (whippedCreamTrack == false && chocalateTrack == true) {
            baseFair = pricePerCup + chocolatePrice;
        } else {
            baseFair = pricePerCup;
        }

        int price = quantity * baseFair;
        return price;
    }

    private void creteOrderSummary(int price, boolean addWhippedCream, boolean addChocalate, String name) {
        String Summary = getString(R.string.order_name,name);
        Summary += "\n Add whipped Cream ?" + addWhippedCream;
        Summary += "\n Add chacolate ?" + addChocalate;
        Summary = Summary + "\n Quantity :" + quantity;
        Summary = Summary + "\n Total :$" + price;
        Summary = Summary + "\n"+ getString(R.string.thank_you) ;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "order summary ");
        intent.putExtra(Intent.EXTRA_TEXT, Summary);// only email apps should handle this
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);


        }


    }
}