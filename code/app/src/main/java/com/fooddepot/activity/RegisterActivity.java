package com.fooddepot.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.fooddepot.R;

public class RegisterActivity extends AppCompatActivity {
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        phone =(EditText)findViewById(R.id.phone_editxt);
    }

    public void getVerificationCode(View view){
        Intent i = new Intent(this,OTPVerificationActivity.class);
        startActivity(i);

    }
}




