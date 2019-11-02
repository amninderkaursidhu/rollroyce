package com.carrental.car_rental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome_Employee extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__employee);
        getSupportActionBar().setTitle("Welcome Employee");
        b1 = (Button) findViewById(R.id.listemp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome_Employee.this, listofemployee.class);
                startActivity(intent);
            }
        });
        b2 = (Button) findViewById(R.id.delemp);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome_Employee.this,deleteemployeelist
                        .class);
                startActivity(intent);
            }
        });
        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome_Employee.this,updateemplist
                        .class);
                startActivity(intent);
            }
        });
        b4 = (Button) findViewById(R.id.vadds);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome_Employee.this,AddVehicle
                        .class);
                startActivity(intent);
            }
        });
        b5 = (Button) findViewById(R.id.lstv);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome_Employee.this,carview.class);
                startActivity(intent);
            }
        });
        b6 = (Button) findViewById(R.id.logs);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Welcome_Employee.this,Login.class);


                startActivity(intent);
            }
        });
        b7=(Button) findViewById(R.id.cnclerervtn);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String sssr="All";

                Intent intent = new Intent(Welcome_Employee.this,cancelreservation2.class);
                intent.putExtra("umt",sssr);

                startActivity(intent);
            }
        });
        b8=(Button) findViewById(R.id.custadd);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Intent intent = new Intent(Welcome_Employee.this,andcustomerandemployye.class);


                startActivity(intent);
            }
        });

    }
}
