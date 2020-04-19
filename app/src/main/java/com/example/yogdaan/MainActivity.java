package com.example.yogdaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    DrawerLayout d;
    Toolbar t;
    private FirebaseAuth mAuth;
    private FirebaseFirestore ff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        ff=FirebaseFirestore.getInstance();
        setuptoolbarnow();
        CardView v1= findViewById(R.id.logout);
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
                Map<String,Object> map=new HashMap<>();
                map.put("date",new Date());
                Random r=new Random();
                final int randomid=r.nextInt(1000000+1);
                ff.collection("Username").document(mAuth.getCurrentUser().getUid()).collection("Transaction").document(String.valueOf(randomid)).set(map);
            }
        });

        CardView v3= findViewById(R.id.volunteer);
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VolunteerActivity.class));

            }
        });

        CardView v4= findViewById(R.id.help);
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HelpPage.class));
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
        NavigationView navigationView= findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.logout: mAuth.signOut(); startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    break;
                    case R.id.z2:
                        Toast.makeText(MainActivity.this,"MENU 2",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.volunteer:
                        Toast.makeText(MainActivity.this,"MENU 3",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.z4:
                        Toast.makeText(MainActivity.this,"MENU 4",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.z5:
                        Toast.makeText(MainActivity.this,"MENU 5",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.z6:
                        Toast.makeText(MainActivity.this,"MENU 6",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.z7:
                        Toast.makeText(MainActivity.this,"MENU 7",Toast.LENGTH_SHORT).show();
                        break;

                }

                return false;
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


    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }
    }

}
