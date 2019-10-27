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

import javacollections.vehicleobjectstore;

public class custvechileadpater extends RecyclerView.Adapter<custvechileadpater.vehicleviewholder> {

    Context mctx;
    String persndt;

    public custvechileadpater(Context mctx, List<vehcileinformation> vehcilesList,String personaldata) {
        this.mctx = mctx;
        this.vehcilesList = vehcilesList;
        persndt=personaldata;
        System.out.println("Value Pass  2nd phase Succussfully........."+persndt);
    }


    List<vehcileinformation> vehcilesList;
    @NonNull
    @Override
    public vehicleviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mctx).inflate(R.layout.custvehcileviewlistlayout,viewGroup,false);
        vehicleviewholder vehicleviewholder=new vehicleviewholder(view);

        return vehicleviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final vehicleviewholder vehicleviewholder, int i) {
        final int pp=i;
        final vehcileinformation valueofinfo=vehcilesList.get(i);
        vehicleviewholder.type.setText(valueofinfo.getType());
       vehicleviewholder.brand.setText(valueofinfo.getBrand());
         final  String username=persndt;
       // System.out.println("Value Pass  3rd phase Succussfully........."+persndt);
            final String imagename=valueofinfo.getImage();

        System.out.println("Your Image Name is "+imagename);
       int resourceId = mctx.getResources().getIdentifier(imagename,"drawable", mctx.getApplicationContext().getPackageName());
        System.out.println("Your Image Name is "+resourceId);
       vehicleviewholder.imageView.setImageResource(resourceId);


        vehicleviewholder.delts.setOnClickListener(new View.OnClickListener() {
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
                mctx.startActivity(new Intent(mctx, vehicledetails.class).putExtra("type",ty).putExtra("model",md).putExtra("plate",plt).putExtra("color",col).putExtra("brand",brnd).putExtra("Year",yer).putExtra("pstn",pp).putExtra("imgs",imagename).putExtra("user",username));


             //   Toast.makeText(view.getContext(),"Record",Toast.LENGTH_LONG).show();

            }
        });
        vehicleviewholder.resvnow.setOnClickListener(new View.OnClickListener() {
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
                mctx.startActivity(new Intent(mctx, reservevehicledetails.class).putExtra("type",ty).putExtra("model",md).putExtra("plate",plt).putExtra("color",col).putExtra("brand",brnd).putExtra("Year",yer).putExtra("pstn",pp).putExtra("imgs",imagename).putExtra("user",username));


                Toast.makeText(view.getContext(),"Record",Toast.LENGTH_LONG).show();

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
        Button remv,delts,resvnow;
        TextView type,model,year,plate,color,brand;
        public RelativeLayout relativeLayout;
        public vehicleviewholder(@NonNull View itemView) {
            super(itemView);
            //   imageView=itemView.findViewById(R.id.imageview);
            type=itemView.findViewById(R.id.type);

           imageView=itemView.findViewById(R.id.imageview);

            brand=itemView.findViewById(R.id.brand);

            delts=itemView.findViewById(R.id.detls);
            resvnow=itemView.findViewById(R.id.resvnow);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relt);
        }
    }

}