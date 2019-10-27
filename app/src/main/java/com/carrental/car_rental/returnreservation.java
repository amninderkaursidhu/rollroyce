package com.carrental.car_rental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javacollections.transactionobjectstore;

public class returnreservation extends AppCompatActivity {

    TextView zm;
    RecyclerView recyclerView;
    return_managecustvechileadpater vehadpt;
    String bookdate;
    List<vehcileinformation> vehcilesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returnreservation);
        recyclerView=findViewById(R.id.recy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        final Bundle bundle = getIntent().getExtras();
        String urwr=bundle.getString("umt");
        transactionobjectstore addvehcile=transactionobjectstore.getInstance();
        vehcilesList=new ArrayList();
        for(javacollections.Transaction chku:addvehcile.carrentdetails) {
            if (chku.getCus().getU().equals(urwr)) {
                vehcilesList.add(new vehcileinformation(
                        chku.getVes().getType(),
                        chku.getVes().getBrand(),
                        chku.getVes().getColor(),
                        chku.getVes().getYear(),
                        chku.getVes().getModel(),
                        chku.getVes().getLicenceplate(),
                        chku.getVes().getImage()

                ));
            }
        }
        vehadpt= new return_managecustvechileadpater(this,vehcilesList,urwr);


        recyclerView.setAdapter(vehadpt);

    }
}
