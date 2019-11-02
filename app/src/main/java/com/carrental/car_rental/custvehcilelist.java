package com.carrental.car_rental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javacollections.vehicleobjectstore;

public class custvehcilelist extends AppCompatActivity {

      TextView zm;
    RecyclerView recyclerView;
    custvechileadpater vehadpt;
    List<vehcileinformation> vehcilesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custvehcilelist);

        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        final Bundle bundle = getIntent().getExtras();
         String urwr=bundle.getString("umt");
        System.out.println("Ist Phase Value Pass"+urwr);

        vehicleobjectstore addvehcile=vehicleobjectstore.getInstance();
        vehcilesList=new ArrayList();
        for(javacollections.vehcile chku:addvehcile.vehcileslist)
            vehcilesList.add(new vehcileinformation(
                    chku.getType(),
                    chku.getBrand(),
                    chku.getColor(),
                    chku.getYear(),
                    chku.getModel(),
                    chku.getLicenceplate(),
                    chku.getImage()

            ));


        vehadpt= new custvechileadpater(this,vehcilesList,urwr);


        recyclerView.setAdapter(vehadpt);

    }
}
