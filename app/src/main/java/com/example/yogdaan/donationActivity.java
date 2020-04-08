package com.example.yogdaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class donationActivity extends AppCompatActivity {
    private Button donateMoneyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        donateMoneyBtn =(Button)findViewById(R.id.donate_money_btn);

        donateMoneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(donationActivity.this,paymentActivity.class);
                startActivity(intent);
            }
        });
    }
}
