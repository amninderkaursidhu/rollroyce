package com.carrental.car_rental;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class availablebetween extends AppCompatActivity {
    String vtp,vcl,vbrn,vmod,vlipl,vims;
    int pstions;
    ImageView zz;
    private int mYear, mMonth, mDay, mHour, mMinute;
    Button bts,bts2,bts3;
    TextView type,color,brand,year,model,licenplate;
    EditText sd,sd2;
       Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablebetween);
        final Bundle bundle = getIntent().getExtras();
        final String urr=bundle.getString("um");
        b1=(Button) findViewById(R.id.rentnow1);
        sd=(EditText)findViewById(R.id.dterent);
        sd2=(EditText)findViewById(R.id.dterentend);
        bts=(Button)findViewById(R.id.btn_date);
        bts3=(Button)findViewById(R.id.btn_end_date);
        bts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(availablebetween.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                sd.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        bts3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(availablebetween.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                sd2.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sssr=bundle.getString("um");


                Intent intent = new Intent(availablebetween.this,availbalenow.class);
                intent.putExtra("umt",sssr);

                startActivity(intent);
            }
        });
    }
}
