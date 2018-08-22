package com.rethinkux.dentistapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.rethinkux.dentistapp.R;

public class AddServiceActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backIcon;
    Button btnAddService;
    EditText etServiceName,etServiceCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);

        init();

        btnAddService.setOnClickListener(this);


        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddServiceActivity.this,ServicesActivity.class);
                startActivity(intent);
            }
        });

        if (getIntent() .hasExtra("service name") && getIntent().hasExtra("service cost")){

            String serviceName=getIntent().getStringExtra("service name");
            String serviceCost=getIntent().getStringExtra("service cost");

            setNameCost(serviceName,serviceCost);
        }

    }

    private void setNameCost(String serviceName, String serviceCost){
        etServiceName.setText(serviceName);
        etServiceCost.setText(serviceCost);
    }

    private void init(){
        backIcon=findViewById(R.id.backIcon);
        btnAddService=findViewById(R.id.btnAddService);
        etServiceName=findViewById(R.id.etServiceName);
        etServiceCost=findViewById(R.id.etServiceCost);
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(AddServiceActivity.this,ServicesActivity.class);
        startActivity(intent);
    }

}
