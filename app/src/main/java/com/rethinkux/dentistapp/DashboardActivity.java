package com.rethinkux.dentistapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final String TAG = DashboardActivity.class.getSimpleName();
    ImageView ivDrawer;
    DrawerLayout drawerLayout;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

        init();

        navView.setNavigationItemSelectedListener(this);
        ivDrawer.setOnClickListener(this);
    }

    private void init(){
        ivDrawer=findViewById(R.id.ivDrawer);
        drawerLayout=findViewById(R.id.drawerLayout);
        navView=findViewById(R.id.navView);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.service:
            Intent intent=new Intent(DashboardActivity.this,ServiceTypeActivity.class);
            startActivity(intent);
            break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: " + "Clicked");
        drawerLayout.openDrawer(GravityCompat.START);

    }
}
