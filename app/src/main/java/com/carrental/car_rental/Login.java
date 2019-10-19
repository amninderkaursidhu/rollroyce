package com.carrental.car_rental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import javacollections.customer;
import javacollections.customerobjectstore;
import javacollections.employee;
import javacollections.employeeobjectstore;
public class Login extends AppCompatActivity {

     String username,password,role;
     Button b1,b2;
    EditText us,ps;
    RadioButton chk;
    RadioGroup gp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        b1 = (Button) findViewById(R.id.sinp);
        b2=(Button)findViewById(R.id.lg);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
            us=(EditText)findViewById(R.id.ur);
            username=us.getText().toString();
            ps=(EditText)findViewById(R.id.pr);
            password=ps.getText().toString();
                gp = (RadioGroup) findViewById(R.id.rg);

                int selectedId = gp.getCheckedRadioButtonId();

                chk=(RadioButton) findViewById(selectedId);
                role=chk.getText().toString();

                    int urr=0,pssw=0;

                if(role.equals("Customer"))
                {

                   for(customer chku:customerobjectstore.info) {
                       if (chku.u.equals(username)) {
                            urr++;
                            break;

                       }
                   }
                    for(customer chku:customerobjectstore.info) {
                        if (chku.p.equals(password)) {
                            pssw++;
                            break;

                        }
                    }
                       if(urr!=0 && pssw!=0)
                       {
                           Intent intent = new Intent(Login.this, Welcome_Customer.class);
                           startActivity(intent);
                       }
                       else
                       {
                           Toast toast = Toast.makeText(getApplicationContext(), "Wrong UserName & Password", Toast.LENGTH_SHORT);
                           toast.setMargin(25, 25);
                           toast.show();
                       }
                }
                else
                {
                    for(employee chku:employeeobjectstore.info2) {
                        if (chku.u.equals(username)) {
                            urr++;
                            break;

                        }
                    }
                    for(employee chku:employeeobjectstore.info2) {
                        if (chku.p.equals(password)) {
                            pssw++;
                            break;

                        }
                    }
                    if(urr!=0 && pssw!=0)
                    {
                        Intent intent = new Intent(Login.this,Welcome_Employee.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "Wrong UserName & Password", Toast.LENGTH_SHORT);
                        toast.setMargin(25, 25);
                        toast.show();
                    }
                }



            }

    });
}
}
