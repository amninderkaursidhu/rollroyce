package com.carrental.car_rental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javacollections.customer;
import javacollections.customerobjectstore;

public class deleteemployeelist extends AppCompatActivity {

    RecyclerView recyclerView;
    customeradpaterdelete Custadpt;
    List<customerinformation> customerinformationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteemployeelist);

        getSupportActionBar().setTitle("Remove  Customer");
        setContentView(R.layout.activity_deleteemployeelist);
        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        customerinformationList=new ArrayList<>();

        for(customer chku: customerobjectstore.info) {
            customerinformationList.add(new customerinformation(

                    R.drawable.customer,
                    chku.f,
                    chku.l,
                    chku.u,
                    chku.p,
                    chku.rle

            ));
        }


        Custadpt=new customeradpaterdelete(this,customerinformationList);
        recyclerView.setAdapter(Custadpt);
    }
}
