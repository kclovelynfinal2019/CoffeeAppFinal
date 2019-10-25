package com.example.user.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity;
    private Boolean latte;
    private Boolean whipped;
    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayquantity(quantity);

    }

    private void displayquantity(int quantity) {
        TextView quantity1 = (TextView) findViewById(R.id.quantityTxts);
        quantity1.setText("" + quantity);


    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayquantity(quantity);

    }

    private void displayMessage(String finalMessage) {
        TextView Message = (TextView) findViewById(R.id.resultTxt);
        Message.setText("" + finalMessage);


    }


    private String createFinalMessage(Boolean latte, Boolean whipped, int price) {
        String Message = "CreamyLatte ordered :" + latte + "\n" + "CoffeeDelight ordered  :" + whipped + "\n" + " Total Price Php: " + price;
        return Message;


    }

    private int calculatePrice1(Boolean latte, Boolean whipped) {

        int price = 90;
        int lattes = 100;
        int whip = 110;

        if (latte) {
            price = price + 10;
        }
        if (whipped) {
            price = price + 20;
        }

        if (latte && whipped) {
            price = lattes + whip;
        }
        return price * quantity;
    }

    public void orderButton(View view){
        CheckBox creamylatte = (CheckBox) findViewById(R.id.creamylatte_checkbox);
        Boolean latte = creamylatte.isChecked();
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean whipped = whippedCream.isChecked();

        int price = calculatePrice1(latte, whipped);
        String finalMessage = createFinalMessage(latte, whipped, price);
        displayMessage(finalMessage);
    }

}
