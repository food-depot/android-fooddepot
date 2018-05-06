package com.fooddepot.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fooddepot.R;
import com.fooddepot.service.api.CookService;
import com.fooddepot.service.api.UserService;
import com.fooddepot.service.impl.CookServiceImpl;
import com.fooddepot.service.impl.UserServiceImpl;
import com.fooddepot.ui.api.UICookService;
import com.fooddepot.ui.api.UIUserService;
import com.fooddepot.vo.Cook;
import com.fooddepot.vo.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class RoleActivity extends AppCompatActivity implements UIUserService,UICookService{

    private FirebaseAuth mAuth;
    private UserService userService;
    private CookService cookService;
    private String TAG="RoleActivity";
    private FirebaseUser currentUser;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        mAuth= FirebaseAuth.getInstance();
    }

    public void onClickCook(View view){

        Log.d(TAG,"cook button clicked");
        userService=new UserServiceImpl();
        userService.read(currentUser.getUid(),RoleActivity.this);

    }

    public void onClickOrder(View view){
        Intent i = new Intent(this,OrderActivity.class);
        startActivity(i);
    }

    @Override
    public void onStart(){
        super.onStart();
        currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            Intent i = new Intent(RoleActivity.this,RegisterActivity.class);
            startActivity(i);
            finish();
        }


    }

    @Override
    public void displayAllUsers(List<User> user) {

    }

    @Override
    public void displayUser(User user) {
        this.user=user;
        Log.d(TAG,"displayUser uid: "+user.getUid());
        cookService=new CookServiceImpl();
        cookService.read(user.getUid(),RoleActivity.this);
        Intent i = new Intent(this,CookActivity.class);
        startActivity(i);

    }

    @Override
    public void displayAllCooks(List<Cook> cook) {

    }

    @Override
    public void displayCook(Cook cook) {
    if(cook==null){
        Cook newcook=new Cook(user.getUid(),user.getName(),user.getPhoneNumber(),
                user.getAddressLine1(),user.getAddressLine2(),user.getState(),user.getCountry()
                ,user.getZipcode(),user.getProfilePicPath(),user.getEmail());
        cookService.add(newcook);
    }
    }
}
