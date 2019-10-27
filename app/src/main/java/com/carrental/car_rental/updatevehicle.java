package com.carrental.car_rental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import javacollections.vehcile;
import javacollections.vehicleobjectstore;

public class updatevehicle extends AppCompatActivity {

    String vtype,vcolor,vyear,vimage,vlicenplate,vmodel,vbrand;
    Button b1,b2;
    Spinner ims;
    EditText vtyp,vyr,vcol,licpl,vmod,vbn;
    int postnns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatevehicle);

        final Bundle bundle = getIntent().getExtras();
        postnns=bundle.getInt("pstn");
        vtyp=(EditText) findViewById(R.id.vtype);
        vtyp.setText(bundle.getString("type"));

        vcol=(EditText) findViewById(R.id.vcolor);
        vcol.setText(bundle.getString("color"));

        vyr=(EditText) findViewById(R.id.vyear);
        vyr.setText(bundle.getString("Year"));

        licpl=(EditText) findViewById(R.id.licenseplate);
        licpl.setText(bundle.getString("plate"));


        vmod=(EditText) findViewById(R.id.vmodel);
        vmod.setText(bundle.getString("model"));

        vbn=(EditText) findViewById(R.id.vbrandname);
        vbn.setText(bundle.getString("brand"));

        ims=(Spinner) findViewById(R.id.spinner1);
        vimage=ims.getSelectedItem().toString();

        b2 = (Button) findViewById(R.id.upvch);
        b1 = (Button) findViewById(R.id.bck);

           b2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   vtyp=(EditText) findViewById(R.id.vtype);
                    vtype=vtyp.getText().toString();

                   vcol=(EditText) findViewById(R.id.vcolor);

                    vcolor=vcol.getText().toString();

                   vyr=(EditText) findViewById(R.id.vyear);
                   vyear=vyr.getText().toString();

                   licpl=(EditText) findViewById(R.id.licenseplate);
                   vlicenplate=licpl.getText().toString();

                   vmod=(EditText) findViewById(R.id.vmodel);
                   vmodel=vmod.getText().toString();

                   vbn=(EditText) findViewById(R.id.vbrandname);
                   vbrand=vbn.getText().toString();

                   ims=(Spinner) findViewById(R.id.spinner1);
                   vimage=ims.getSelectedItem().toString();

                   vehicleobjectstore addvehcile=vehicleobjectstore.getInstance();  // singleton call

                   postnns=bundle.getInt("pstn");
                   vehcile w=addvehcile.vehcileslist.get(postnns);

                      w.setType(vtype);
                      w.setBrand(vbrand);
                      w.setColor(vcolor);
                      w.setYear(vyear);
                      w.setLicenceplate(vlicenplate);
                      w.setImage(vimage);
                      w.setModel(vmodel);
                   Toast.makeText(view.getContext(),"Vehicle Updated SuccessFully",Toast.LENGTH_LONG).show();

               }
           });

           b1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(updatevehicle.this,Welcome_Employee.class);
                   startActivity(intent);
               }
           });


    }
}
