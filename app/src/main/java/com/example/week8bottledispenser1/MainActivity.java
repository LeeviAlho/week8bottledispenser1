package com.example.week8bottledispenser1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    BottleDispenser bottles;
    TextView text;
    TextView money;
    TextView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottles = BottleDispenser.getInstance();
        text = (TextView) findViewById(R.id.textView);
        money = (TextView) findViewById(R.id.moneyView);
        list = (TextView) findViewById(R.id.listView);
        setMoney();
        setList();

    }

    private void setMoney(){
        money.setText("Money: " + bottles.getMoney());
    }

    private void setList(){
        list.setText((bottles.listBottles()));
    }

    public void bottleDispensing (View v) {
        text.setText(bottles.buyBottle());
        setMoney();
        setList();
    }
    public void takeMoney (View v) {
        text.setText(bottles.addMoney());
        setMoney();
            }
    public void dispenseMoney(View v) {
        text.setText(bottles.returnMoney());
        setMoney();
        //bottles.listBottles();
    }

}