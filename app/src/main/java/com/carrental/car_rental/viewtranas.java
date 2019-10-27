package com.carrental.car_rental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import javacollections.Transaction;
import javacollections.transactionobjectstore;

public class viewtranas extends AppCompatActivity {

    String vtp,vcl,vbrn,vmod,vlipl,vims;
    int pstions;
    ImageView zz;
    private int mYear, mMonth, mDay, mHour, mMinute;
    Button bts,bts2,bts3;
    TextView type,color,brand,year,model,licenplate,sd2;
    EditText sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtranas);
        bts2=(Button)findViewById(R.id.rentcancelnow);

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

        sd2=(TextView)findViewById(R.id.dtem);
        zz=(ImageView)findViewById(R.id.imageview);
        vims=bundle.getString("imgs");
        int resourceId = this.getResources().getIdentifier(vims,"drawable",this.getApplicationContext().getPackageName());
        System.out.println("Your Image Name is "+resourceId);
        zz.setImageResource(resourceId);

        final transactionobjectstore trobj1=transactionobjectstore.getInstance();

        Transaction k=trobj1.returncarrentdetails.get(pstions);
        String mystartdate= k.getRetn().getReturndate();
      //  String myenddate=k.getRs().getDuedate();

        sd2.setText(mystartdate);





    }
}
