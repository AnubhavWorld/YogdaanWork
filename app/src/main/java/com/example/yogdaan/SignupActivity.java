package com.example.yogdaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Date;

public class SignupActivity extends AppCompatActivity {

    private Button login_button;
    private Button create_account_button;
    private EditText username_text;
    private EditText password_text;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        create_account_button = findViewById(R.id.create_button);
        username_text = findViewById(R.id.signup_username);
        password_text = findViewById(R.id.signup_password);
        create_account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mAuth.createUserWithEmailAndPassword(username_text.getText().toString(),password_text.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(SignupActivity.this,MainActivity.class
                                ));
                                finish();
                            }
                            else
                            {
                                Toast.makeText(SignupActivity.this,"failed",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
            }
        });
    }
}


