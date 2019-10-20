package com.carrental.car_rental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javacollections.customer;
import javacollections.customerobjectstore;

public class updaterecordemployees extends AppCompatActivity {
    EditText f,l,utr,p,cp;
    Button b1,b2;
    int postnns;

    String firstname,lastname,username,password,confirmpassword,role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updaterecordemployees);

        final Bundle bundle = getIntent().getExtras();
        postnns=bundle.getInt("pstn");
        f=(EditText) findViewById(R.id.istname);
        f.setText(bundle.getString("first"));
        firstname=f.getText().toString();
        l=(EditText) findViewById(R.id.iindname);
        l.setText(bundle.getString("lastname"));
        lastname=l.getText().toString();
        utr=(EditText) findViewById(R.id.usernm);
        utr.setText(bundle.getString("usr"));
        username=utr.getText().toString();
        p=(EditText) findViewById(R.id.passwrd);
        p.setText(bundle.getString("ps"));
        password=p.getText().toString();
        b2 = (Button) findViewById(R.id.adur);
        b1 = (Button) findViewById(R.id.bck);
        b1.setOnClickListener(new View.OnClickListener() {

                                  @Override
                                  public void onClick(View view) {
                                      Intent intent = new Intent(updaterecordemployees.this,updateemplist
                                              .class);
                                      startActivity(intent);
                                  }
                              });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                postnns=bundle.getInt("pstn");
                f=(EditText) findViewById(R.id.istname);

                firstname=f.getText().toString();
                l=(EditText) findViewById(R.id.iindname);

                lastname=l.getText().toString();
                utr=(EditText) findViewById(R.id.usernm);

                username=utr.getText().toString();
                p=(EditText) findViewById(R.id.passwrd);

                password=p.getText().toString();

                customer y=customerobjectstore.info.get(postnns);
                    y.setF(firstname);
                    y.setL(lastname);
                    y.setU(username);
                    y.setP(password);
                Toast.makeText(view.getContext(),"Record Updated",Toast.LENGTH_LONG).show();


            }
        });

    }
}
