package com.example.intdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class signinActivity extends AppCompatActivity {
    private Button btnProceed;
    EditText strEmail,strPass;
    private static String userEmail;
    DBHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        strEmail=findViewById(R.id.idEmail);
        strPass=findViewById(R.id.idPass);
        btnProceed=findViewById(R.id.btnSignIn);
        DB=new DBHandler(this);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=strEmail.getText().toString();
                String pass=strPass.getText().toString();
                Boolean flagValidate=DB.verifyCredentials(email,pass);
                if(flagValidate==true) {
                    userEmail=email;
                    Intent intent=new Intent(signinActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                else{
                    Snackbar snackbar = Snackbar.make(view, "Invalid Credentials", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }

        });
    }

    public static String getUserEmail(){
        return userEmail;
    }
}