package com.fooddepot.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fooddepot.R;

public class RoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
    }

    public void onClickCook(View view){
        Intent i = new Intent(this,CookActivity.class);
        startActivity(i);
    }

    public void onClickOrder(View view){
        Intent i = new Intent(this,OrderActivity.class);
        startActivity(i);
    }
}
