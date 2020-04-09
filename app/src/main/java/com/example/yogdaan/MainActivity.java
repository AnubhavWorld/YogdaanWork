package com.example.yogdaan;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout d;
    Toolbar t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setuptoolbarnow();
        CardView v1= findViewById(R.id.i1);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,donationActivity.class);
                startActivity(intent);

            }
        });


        CardView v2= findViewById(R.id.i2);
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Have a cup of coffee,bud!", Toast.LENGTH_SHORT).show();
            }
        });

        CardView v3= findViewById(R.id.volunteer);
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VolunteerActivity.class));
                Toast.makeText(MainActivity.this, "Welcome to my favorite place!", Toast.LENGTH_SHORT).show();
            }
        });

        CardView v4= findViewById(R.id.a1);
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hold my beer", Toast.LENGTH_SHORT).show();
            }
        });

        CardView v5= findViewById(R.id.a2);
        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "LUBBBBB", Toast.LENGTH_SHORT).show();
            }
        });

        CardView v6= findViewById(R.id.a3);
        v6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "HELLO", Toast.LENGTH_SHORT).show();
            }
        });









    }

    private void setuptoolbarnow() {
        d=  findViewById(R.id.d1);
        t=  findViewById(R.id.t1);

        ActionBarDrawerToggle ac= new ActionBarDrawerToggle(this,d,t,R.string.app_name,R.string.app_name);
        d.addDrawerListener(ac);
        ac.syncState();




    }


}
