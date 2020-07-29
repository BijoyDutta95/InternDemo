package com.example.intdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class regActivity extends AppCompatActivity {
    private Button btnProceed;
    EditText strEmail,strName,strPass,strPassCnf;
    DBHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        strEmail=findViewById(R.id.idMail);
        strName=findViewById(R.id.idName);
        strPass=findViewById(R.id.idPass1);
        strPassCnf=findViewById(R.id.idPass2);
        btnProceed=(Button)findViewById(R.id.proceed);
        DB=new DBHandler(this);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);
                String valEmail=strEmail.getText().toString();
                String valName=strName.getText().toString();
                String pass1=strPass.getText().toString();
                String pass2=strPassCnf.getText().toString();
                if(valEmail.equals("")||valName.equals("")||pass1.equals("")||pass2.equals("")){
                    Snackbar snackbarE= Snackbar.make(view,"EMPTY FIELDS",Snackbar.LENGTH_SHORT);
                    snackbarE.show();
                }
                else if (isEmailValid(strEmail.getText().toString()) == false) {
                    strEmail.setError("Invalid Email Format");
                }
                else{
                    if(pass1.equals(pass2)){
                        Boolean insert=DB.onInsert(valEmail,valName,pass1);
                        if(insert==true) {
                            Snackbar snackbarS = Snackbar.make(view, "Signed Up Successfully", Snackbar.LENGTH_LONG);
                            snackbarS.show();
                            Intent intent =new Intent(regActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                    else{
                        Snackbar snackbarM = Snackbar.make(view, "Passwords Does Not Match", Snackbar.LENGTH_SHORT);
                        snackbarM.show();
                    }


                }

            }
            boolean isEmailValid(CharSequence email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches();
            }
        });
    }
}