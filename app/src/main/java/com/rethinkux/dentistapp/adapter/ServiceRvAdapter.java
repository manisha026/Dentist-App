package com.rethinkux.dentistapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rethinkux.dentistapp.R;
import com.rethinkux.dentistapp.models.ServiceModel;
import com.rethinkux.dentistapp.activity.AddServiceActivity;

import java.util.ArrayList;

public class ServiceRvAdapter extends RecyclerView.Adapter{

    Context context;
    ArrayList<ServiceModel> data;

    public ServiceRvAdapter(Context context, ArrayList<ServiceModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_services, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        final ServiceModel item = data.get(position);
        final MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.tvServiceName.setText(data.get(position).getTvServiceName());
        myViewHolder.tvServiceCostSymbol.setText(data.get(position).getTvServiceCostSymbol());
        myViewHolder.tvServiceCost.setText(data.get(position).getTvServiceCost());

        ((MyViewHolder) holder).viewForeground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String serviceName = myViewHolder.tvServiceName.getText().toString();
                String serviceCost = myViewHolder.tvServiceCost.getText().toString();
                Intent intent=new Intent(context,AddServiceActivity.class);
                intent.putExtra("service name",serviceName);
                intent.putExtra("service cost",serviceCost);
//                intent.putExtra("serviceName",);

                context.startActivity(intent);
            }



        });

//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClick(View v, int pos) {
//
//                //INTENT OBJ
//                Intent i=new Intent(ServiceRvAdapter.this,AddServiceActivity.class);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

     public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvServiceName,tvServiceCostSymbol,tvServiceCost;
        public RelativeLayout viewForeground;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvServiceName = itemView.findViewById(R.id.tvServiceName);
            tvServiceCostSymbol = itemView.findViewById(R.id.tvServiceCostSymbol);
            tvServiceCost = itemView.findViewById(R.id.tvServiceCost);
            viewForeground = itemView.findViewById(R.id.viewForeground);

        }
    }

    public void removeItem(int position) {
        data.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreItem(ServiceModel item, int position) {
        data.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }

}
