package com.rethinkux.dentistapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceDemoAdapter extends RecyclerView.Adapter{

    Context context;
    ArrayList<ServiceModelClass>data;

    public ServiceDemoAdapter(Context context, ArrayList<ServiceModelClass>data) {
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_services_item, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final ServiceModelClass item = data.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.tvServiceName.setText(data.get(position).getTvServiceName());
        myViewHolder.tvServiceCostSymbol.setText(data.get(position).getTvServiceCostSymbol());
        myViewHolder.tvServiceCost.setText(data.get(position).getTvServiceCost());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvServiceName,tvServiceCostSymbol,tvServiceCost;
        RelativeLayout viewForeground;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvServiceName=itemView.findViewById(R.id.tvServiceName);
            tvServiceCostSymbol=itemView.findViewById(R.id.tvServiceCostSymbol);
            tvServiceCost=itemView.findViewById(R.id.tvServiceCost);
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

    public void restoreItem(ServiceModelClass item, int position) {
        data.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }

}
