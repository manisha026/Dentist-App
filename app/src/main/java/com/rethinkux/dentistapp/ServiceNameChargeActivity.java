package com.rethinkux.dentistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ServiceNameChargeActivity extends AppCompatActivity {

    ImageView backIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_name_charge);
        backIcon=findViewById(R.id.backIcon);


        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ServiceNameChargeActivity.this,ServiceTypeActivity.class);
                startActivity(intent);
            }
        });

    }
}
