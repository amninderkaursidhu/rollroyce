package com.carrental.car_rental;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javacollections.*;
public class vehicledetails extends AppCompatActivity {

       String vtp,vcl,vbrn,vmod,vlipl,vims,usss;
       int pstions;
       ImageView zz;
    private int mYear, mMonth, mDay, mHour, mMinute;
       Button bts,bts2;
      TextView type,color,brand,year,model,licenplate;
      EditText sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicledetails);
        bts=(Button)findViewById(R.id.btn_date);
        bts2=(Button)findViewById(R.id.rentnow);
        final Bundle bundle = getIntent().getExtras();
        pstions=bundle.getInt("pstn");
        type=(TextView)findViewById(R.id.dtype);
        type.setText(bundle.getString("type"));

        color=(TextView)findViewById(R.id.dcolor);
        color.setText(bundle.getString("color"));

        brand=(TextView)findViewById(R.id.dbrand);
        brand.setText(bundle.getString("brand"));

        year=(TextView)findViewById(R.id.dyear);
        year.setText(bundle.getString("Year"));

        model=(TextView)findViewById(R.id.dmodel);
        model.setText(bundle.getString("model"));

        licenplate=(TextView)findViewById(R.id.dplate);

        licenplate.setText(bundle.getString("plate"));
        sd=(EditText)findViewById(R.id.dterent);

        zz=(ImageView)findViewById(R.id.imageview);
         vims=bundle.getString("imgs");
        int resourceId = this.getResources().getIdentifier(vims,"drawable",this.getApplicationContext().getPackageName());
        System.out.println("Your Image Name is "+resourceId);
        zz.setImageResource(resourceId);

        bts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(vehicledetails.this,
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

        bts2.setOnClickListener(new View.OnClickListener() {
              customer ch=null;
            @Override
            public void onClick(View view) {
                usss=bundle.getString("user");
                System.out.println("Targer value thr "+usss);
                for(customer chku: customerobjectstore.info) {


                          if(chku.getU().equals(usss))
                    {
                          this.ch=chku;
                    }



                }
                  int ry=0;

                   transactionobjectstore trobj=transactionobjectstore.getInstance();

                vehicleobjectstore addvehcile=vehicleobjectstore.getInstance();
                        for(Transaction s:trobj.carrentdetails)
                        {
                            vehcile wm=addvehcile.vehcileslist.get(pstions);
                              vehcile mk=s.getVes();

                             if(mk.getLicenceplate().equals(licenplate.getText().toString()))
                             {
                                 ry++;
                             }

                        }
                        if(ry==0)
                        {
                            String duedt=sd.getText().toString();

                            DateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                            String de= dateFormat2.format(new Date());

                            Rental rnss=new Rental(de,duedt);
                            Return retdt=new Return(de);

                            Reservation res=new Reservation("na","na");


                            pstions=bundle.getInt("pstn");

                            vehcile w=addvehcile.vehcileslist.get(pstions);
                            Transaction k=new Transaction(ch ,w,rnss,res,retdt,"book");
                            trobj.carrentdetails.add(k);
                            System.out.println("Your Due Date is "+duedt);
                            Toast toast=Toast.makeText(getApplicationContext()," Vehicle booked",Toast.LENGTH_SHORT);
                            toast.setMargin(25,25);
                            toast.show();
                        }
                        else
                        {
                            Toast toast=Toast.makeText(getApplicationContext(),"Someone Already booked",Toast.LENGTH_SHORT);
                            toast.setMargin(25,25);
                            toast.show();
                        }



            }
        });

    }
}
