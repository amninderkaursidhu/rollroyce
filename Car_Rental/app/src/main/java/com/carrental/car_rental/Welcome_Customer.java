package com.carrental.car_rental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Welcome_Customer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__customer);
        getSupportActionBar().setTitle("Welcome Customer");
    }
}
