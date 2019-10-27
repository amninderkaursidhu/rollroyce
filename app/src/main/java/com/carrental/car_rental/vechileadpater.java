package com.carrental.car_rental;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javacollections.*;
import javacollections.transactionobjectstore;
import javacollections.vehicleobjectstore;

public class vechileadpater extends RecyclerView.Adapter<vechileadpater.vehicleviewholder> {

    Context mctx;

    public vechileadpater(Context mctx, List<vehcileinformation> vehcilesList) {
        this.mctx = mctx;
        this.vehcilesList = vehcilesList;
    }

    List<vehcileinformation> vehcilesList;
    @NonNull
    @Override
    public vehicleviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mctx).inflate(R.layout.vehcileviewlistlayout,viewGroup,false);
        vehicleviewholder vehicleviewholder=new vehicleviewholder(view);

        return vehicleviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final vehicleviewholder vehicleviewholder, int i) {
        final int pp=i;
        final vehcileinformation valueofinfo=vehcilesList.get(i);
        vehicleviewholder.type.setText(valueofinfo.getType());
       vehicleviewholder.model.setText(valueofinfo.getModel());
        vehicleviewholder.color.setText(valueofinfo.getColor());
        vehicleviewholder.year.setText(valueofinfo.getYear());
        vehicleviewholder.brand.setText(valueofinfo.getBrand());
        vehicleviewholder.plate.setText(valueofinfo.getLicenceplate());

            String imagename=valueofinfo.getImage();

        System.out.println("Your Image Name is "+imagename);
       int resourceId = mctx.getResources().getIdentifier(imagename,"drawable", mctx.getApplicationContext().getPackageName());
        System.out.println("Your Image Name is "+resourceId);
       vehicleviewholder.imageView.setImageResource(resourceId);








        vehicleviewholder.remv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int op=0;
                vehicleobjectstore addvehcile=vehicleobjectstore.getInstance();
                String liceplte=valueofinfo.getLicenceplate();
                transactionobjectstore dm= transactionobjectstore.getInstance();
                for(Transaction kmp:dm.carrentdetails)
                {
                     if(kmp.getVes().getLicenceplate().equals(liceplte))
                     {
                         op++;
                     }
                }
                if(op==0) {
                    addvehcile.vehcileslist.remove(pp);
                    //     int passwordindex=customerobjectstore.info.size();
                    //   int position = (int) view.getTag();
                    Toast.makeText(view.getContext(), "Vehicle Remove SuccessFully:" + pp, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(view.getContext(), "Vehicle Cannot Remove Because Someonebooked " + pp, Toast.LENGTH_LONG).show();
                }

            }
        });
        vehicleviewholder.edts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent;
                String ty,md,col,brnd,yer,plt;
                ty= valueofinfo.getType();
                brnd=valueofinfo.getBrand();
                plt=valueofinfo.getLicenceplate();
                col=valueofinfo.getModel();
                md=valueofinfo.getColor();
                yer=valueofinfo.getYear();
                mctx.startActivity(new Intent(mctx, updatevehicle.class).putExtra("type",ty).putExtra("model",md).putExtra("plate",plt).putExtra("color",col).putExtra("brand",brnd).putExtra("Year",yer).putExtra("pstn",pp));


                Toast.makeText(view.getContext(),"Record",Toast.LENGTH_LONG).show();

            }
        });
        vehicleviewholder.relativeLayout.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {


            }
        });
        //  customerviewholder.imageView.setImageDrawq2 1`  able(mctx.getResources().getDrawable(valueofinfo.getImage(),null));
    }

    @Override
    public int getItemCount() {
        return vehcilesList.size();
    }

    class vehicleviewholder extends  RecyclerView.ViewHolder // error vali line pe cursor rakho or alt+enter karo error hat jae ga
    {
        ImageView imageView;
        Button remv,edts;
        TextView type,model,year,plate,color,brand;
        public RelativeLayout relativeLayout;
        public vehicleviewholder(@NonNull View itemView) {
            super(itemView);
            //   imageView=itemView.findViewById(R.id.imageview);
            type=itemView.findViewById(R.id.type);
            plate=itemView.findViewById(R.id.plate);
            model=itemView.findViewById(R.id.models);
             year=itemView.findViewById(R.id.years);
           imageView=itemView.findViewById(R.id.imageview);
            color=itemView.findViewById(R.id.color);
            brand=itemView.findViewById(R.id.brand);
            remv=itemView.findViewById(R.id.buttonremove);
            edts=itemView.findViewById(R.id.edtsv);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relt);
        }
    }
}