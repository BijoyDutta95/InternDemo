package com.example.intdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSignUp, btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignUp=(Button)findViewById(R.id.buttonSignUp);
        btnSignIn=(Button)findViewById(R.id.buttonSignIn);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegActivity();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignInActivity();
            }
        });
    }
    public void openRegActivity(){
        Intent intent=new Intent(this, regActivity.class);
        startActivity(intent);
    }
    public void openSignInActivity(){
        Intent intent=new Intent(MainActivity.this, signinActivity.class);
        startActivity(intent);

    }
}