package com.carrental.car_rental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Welcome_Customer extends AppCompatActivity {

      Button b1,b2,b3,b4,b5,b6,b7;
      TextView eds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__customer);
        getSupportActionBar().setTitle("Welcome Customer");
        final Bundle bundle = getIntent().getExtras();
       final String urr=bundle.getString("um");
        System.out.println("Your Name is "+urr);
       eds=(TextView)findViewById(R.id.welcome);
       eds.setText("User :- Welcome "+urr);

        b1=(Button)findViewById(R.id.listveh);
        b2=(Button)findViewById(R.id.cancelreservation);
        b3=(Button)findViewById(R.id.logout);
        b4=(Button)findViewById(R.id.b34);
        b5=(Button)findViewById(R.id.retunvehicle);
        b6=(Button)findViewById(R.id.trans);
        b7=(Button)findViewById(R.id.listvehss);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  String sssr=bundle.getString("um");
                Intent intent = new Intent(Welcome_Customer.this,custvehcilelist.class);
                intent.putExtra("umt",sssr);

                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sssr=bundle.getString("um");
                Intent intent = new Intent(Welcome_Customer.this,cancelreservation.class);
                intent.putExtra("umt",sssr);

                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Welcome_Customer.this,Login.class);


                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sssr=bundle.getString("um");

                Intent intent = new Intent(Welcome_Customer.this,cancelreservation2.class);
                intent.putExtra("umt",sssr);

                startActivity(intent);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sssr=bundle.getString("um");

                Intent intent = new Intent(Welcome_Customer.this,returnreservation.class);
                intent.putExtra("umt",sssr);

                startActivity(intent);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sssr=bundle.getString("um");

                Intent intent = new Intent(Welcome_Customer.this,transactionlist.class);
                intent.putExtra("umt",sssr);

                startActivity(intent);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sssr=bundle.getString("um");

                Intent intent = new Intent(Welcome_Customer.this,availablebetween.class);
                intent.putExtra("umt",sssr);

                startActivity(intent);
            }
        });
    }
}
