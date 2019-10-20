package com.carrental.car_rental;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javacollections.customerobjectstore;

public class customeradpaterdelete extends RecyclerView.Adapter<customeradpaterdelete.customerviewholder> { // main class error k liya same alt +enter

       Context mctx;

    public customeradpaterdelete(Context mctx, List<customerinformation> customerinformationList) {
        this.mctx = mctx;
        this.customerinformationList = customerinformationList;
    }

    List<customerinformation> customerinformationList;
    @NonNull
    @Override
    public customerviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mctx).inflate(R.layout.customer_delete_list_layout,viewGroup,false);
        customerviewholder custmerviewholder=new customerviewholder(view);

        return custmerviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final customerviewholder customerviewholder, int i) {
       final int pp=i;
          final customerinformation valueofinfo=customerinformationList.get(i);
          customerviewholder.firstname.setText(valueofinfo.getFirstname());
          customerviewholder.lastname.setText(valueofinfo.getLastname());
        customerviewholder.username.setText(valueofinfo.getUsername());
          customerviewholder.password.setText(valueofinfo.getPassword());
          customerviewholder.role.setText(valueofinfo.getRole());
          customerviewholder.relativeLayout.setOnClickListener(new View.OnClickListener()
                                                               {

                                                                   @Override
                                                                   public void onClick(View view) {

                                                                       customerobjectstore.info.remove(pp);
                                                                    //     int passwordindex=customerobjectstore.info.size();
                                                                    //   int position = (int) view.getTag();
                                                                      Toast.makeText(view.getContext(),"Record Remove:"+pp,Toast.LENGTH_LONG).show();

                                                                   }
                                                               });
        //  customerviewholder.imageView.setImageDrawable(mctx.getResources().getDrawable(valueofinfo.getImage(),null));
    }

    @Override
    public int getItemCount() {
        return customerinformationList.size();
    }

    class customerviewholder extends  RecyclerView.ViewHolder // error vali line pe cursor rakho or alt+enter karo error hat jae ga
      {
                ImageView imageView;
                TextView firstname,lastname,username,password,role;
          public RelativeLayout relativeLayout;
          public customerviewholder(@NonNull View itemView) {
              super(itemView);
           //   imageView=itemView.findViewById(R.id.imageview);
              firstname=itemView.findViewById(R.id.textviewfirstname);
              lastname=itemView.findViewById(R.id.textviewlastname);
              username=itemView.findViewById(R.id.textviewusername);
              password=itemView.findViewById(R.id.textviewpassword);
              role=itemView.findViewById(R.id.textviewrole);
              relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relt);
          }
      }
}
