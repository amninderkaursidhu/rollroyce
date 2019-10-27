package com.carrental.car_rental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import javacollections.customer;
import javacollections.customerobjectstore;
import javacollections.employee;
import javacollections.employeeobjectstore;

public class andcustomerandemployye extends AppCompatActivity {

    String firstname,lastname,username,password,confirmpassword,role;
    Button b1,b2;
    EditText f,l,utr,p,cp;
    RadioButton chk;
    RadioGroup gp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andcustomerandemployye);

        getSupportActionBar().setTitle("Create User");
        b1 = (Button) findViewById(R.id.bck);
        b2 = (Button) findViewById(R.id.adur);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(andcustomerandemployye.this,Welcome_Employee.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                f=(EditText) findViewById(R.id.istname);
                firstname=f.getText().toString();
                l=(EditText) findViewById(R.id.iindname);
                lastname=l.getText().toString();
                utr=(EditText) findViewById(R.id.usernm);
                username=utr.getText().toString();
                p=(EditText) findViewById(R.id.passwrd);
                password=p.getText().toString();
                cp=(EditText) findViewById(R.id.cnfrmpawrd);
                confirmpassword=cp.getText().toString();
                gp = (RadioGroup) findViewById(R.id.rg);

                int selectedId = gp.getCheckedRadioButtonId();

                chk=(RadioButton) findViewById(selectedId);
                role=chk.getText().toString();

                if(password.equals(confirmpassword))
                {


                    if(role.equals("Customer"))
                    {

                        final customer cusstore=new customer(firstname,lastname,username,password,role);

                        String chk;
                        int i,k=0;
                        System.out.println("dddddddddddddddd is "+ customerobjectstore.info.size());
                        System.out.println("Username is "+cusstore.u);
                        for(customer gt:customerobjectstore.info)
                        {

                            //
                            if(gt.u.equals(username))
                            {
                                k++;
                                break;


                            }
                        }

                        if(k==0) {
                            customerobjectstore.info.add(cusstore);
                            Toast toast=Toast.makeText(getApplicationContext(),"Add Customer Successfully",Toast.LENGTH_SHORT);
                            toast.setMargin(25,25);
                            toast.show();
                        }
                        else
                        {

                            Toast toast=Toast.makeText(getApplicationContext(),"Enter Diff Customer Username",Toast.LENGTH_SHORT);
                            toast.setMargin(25,25);
                            toast.show();
                        }


                    }
                    else
                    {

                        final employee empstore=new employee(firstname,lastname,username,password,role);

                        String chk;
                        int i,k=0;
                        for(employee gt: employeeobjectstore.info2)
                        {

                            //
                            if(gt.u.equals(username))
                            {
                                k++;
                                break;


                            }
                        }

                        if(k==0) {
                            employeeobjectstore.info2.add(empstore);
                            Toast toast=Toast.makeText(getApplicationContext(),"Add Employee Successfully",Toast.LENGTH_SHORT);
                            toast.setMargin(25,25);
                            toast.show();
                        }
                        else
                        {

                            Toast toast=Toast.makeText(getApplicationContext(),"Enter Diff Employee Username",Toast.LENGTH_SHORT);
                            toast.setMargin(25,25);
                            toast.show();
                        }
                    }




                }
                else
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Confirm Password Mismatch",Toast.LENGTH_SHORT);
                    toast.setMargin(25,25);
                    toast.show();
                }

            }
        });

    }
}
