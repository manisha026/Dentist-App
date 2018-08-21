package com.rethinkux.dentistapp;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class ServiceTypeActivity extends AppCompatActivity implements View.OnClickListener,RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    FloatingActionButton fabAdd;
    ImageView backIcon;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    ServiceDemoAdapter demoAdapter;
    ArrayList<ServiceModelClass> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_type);

        fabAdd=findViewById(R.id.fabAdd);
        recyclerView = findViewById(R.id.recyclerView);
        backIcon=findViewById(R.id.backIcon);
        relativeLayout=findViewById(R.id.relativeLyout);

        fabAdd.setOnClickListener(this);
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ServiceTypeActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        ServiceModelClass modelClass = new ServiceModelClass();
        ServiceModelClass modelClass1 = new ServiceModelClass();
        ServiceModelClass modelClass2 = new ServiceModelClass();
        ServiceModelClass modelClass3 = new ServiceModelClass();
        ServiceModelClass modelClass4 = new ServiceModelClass();
        ServiceModelClass modelClass5 = new ServiceModelClass();
        ServiceModelClass modelClass6 = new ServiceModelClass();
        ServiceModelClass modelClass7 = new ServiceModelClass();
        ServiceModelClass modelClass8 = new ServiceModelClass();
        ServiceModelClass modelClass9 = new ServiceModelClass();
        ServiceModelClass modelClass10 = new ServiceModelClass();
        ServiceModelClass modelClass11 = new ServiceModelClass();

        modelClass.setTvServiceName("RCT");
        modelClass.setTvServiceCostSymbol("");
        modelClass.setTvServiceCost("4000");

        modelClass1.setTvServiceName("RCT");
        modelClass1.setTvServiceCostSymbol("");
        modelClass1.setTvServiceCost("4000");

        modelClass2.setTvServiceName("RCT");
        modelClass2.setTvServiceCostSymbol("");
        modelClass2.setTvServiceCost("4000");

        modelClass3.setTvServiceName("RCT");
        modelClass3.setTvServiceCostSymbol("");
        modelClass3.setTvServiceCost("4000");

        modelClass4.setTvServiceName("RCT");
        modelClass4.setTvServiceCostSymbol("");
        modelClass4.setTvServiceCost("4000");

        modelClass5.setTvServiceName("RCT");
        modelClass5.setTvServiceCostSymbol("");
        modelClass5.setTvServiceCost("4000");

        modelClass6.setTvServiceName("RCT");
        modelClass6.setTvServiceCostSymbol("");
        modelClass6.setTvServiceCost("4000");

        modelClass7.setTvServiceName("RCT");
        modelClass7.setTvServiceCostSymbol("");
        modelClass7.setTvServiceCost("4000");

        modelClass8.setTvServiceName("RCT");
        modelClass8.setTvServiceCostSymbol("");
        modelClass8.setTvServiceCost("4000");

        modelClass9.setTvServiceName("RCT");
        modelClass9.setTvServiceCostSymbol("");
        modelClass9.setTvServiceCost("4000");

        modelClass10.setTvServiceName("RCT");
        modelClass10.setTvServiceCostSymbol("");
        modelClass10.setTvServiceCost("4000");

        modelClass11.setTvServiceName("RCT");
        modelClass11.setTvServiceCostSymbol("");
        modelClass11.setTvServiceCost("4000");

        data.add(modelClass);
        data.add(modelClass1);
        data.add(modelClass2);
        data.add(modelClass3);
        data.add(modelClass4);
        data.add(modelClass5);
        data.add(modelClass6);
        data.add(modelClass7);
        data.add(modelClass8);
        data.add(modelClass9);
        data.add(modelClass10);
        data.add(modelClass11);

        demoAdapter=new ServiceDemoAdapter(ServiceTypeActivity.this,data);
        recyclerView.setAdapter(demoAdapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);


        // making http call and fetching menu json

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback1 = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.UP) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // Row is swiped from recycler view
                // remove it from adapter
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };

        // attaching the touch helper to recycler view
        new ItemTouchHelper(itemTouchHelperCallback1).attachToRecyclerView(recyclerView);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof ServiceDemoAdapter.MyViewHolder) {
            // get the removed item name to display it in snack bar
            String name = data.get(viewHolder.getAdapterPosition()).getTvServiceName();

            // backup of removed item for undo purpose
            final ServiceModelClass deletedItem = data.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            demoAdapter.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(relativeLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    demoAdapter.restoreItem(deletedItem, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }

    @Override
    public void onClick(View view) {

        Intent intent=new Intent(ServiceTypeActivity.this,ServiceNameChargeActivity.class);
        startActivity(intent);

    }


}
