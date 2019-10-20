package com.carrental.car_rental;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import javacollections.customer;
import javacollections.customer;
import javacollections.vehcile;
import javacollections.vehicleobjectstore;
public class AddVehicle extends AppCompatActivity {

    String vtype,vcolor,vyear,vimage,vlicenplate,vmodel,vbrand;
    Button b1,b2;
    Spinner ims;
    EditText vtyp,vyr,vcol,licpl,vmod,vbn,vims;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        b1=(Button)findViewById(R.id.advch);

        b1.setOnClickListener(new View.OnClickListener() {
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
                final vehcile vstore=new vehcile(vtype,vbrand,vmodel,vyear,vcolor,vlicenplate,vimage);
                vehicleobjectstore addvehcile=vehicleobjectstore.getInstance();  // singleton call
                  int k=0;
                    for(vehcile chk:addvehcile.vehcileslist)
                    {
                        if(chk.getLicenceplate().equals(vlicenplate))
                        {
                            k++;
                            break;


                        }
                    }
                      if(k==0)
                      {
                          addvehcile.vehcileslist.add(vstore);
                          Toast toast=Toast.makeText(getApplicationContext()," Vehicle Add  Successfully",Toast.LENGTH_SHORT);
                          toast.setMargin(25,25);
                          toast.show();
                      }
                      else
                      {

                          Toast toast=Toast.makeText(getApplicationContext(),"Vehicle  Licenece Plate Already Exits",Toast.LENGTH_SHORT);
                          toast.setMargin(25,25);
                          toast.show();
                      }



            }
        });
        b2=(Button)findViewById(R.id.bck);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddVehicle.this,Welcome_Employee.class);
                startActivity(intent);
            }
        });
    }
}
