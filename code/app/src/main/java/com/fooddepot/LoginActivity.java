package com.fooddepot;


import android.app.Activity;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.fooddepot.service.api.ItemService;
import com.fooddepot.service.impl.ItemServiceImpl;
import com.fooddepot.ui.api.UIItemService;
import com.fooddepot.vo.Cook;
import com.fooddepot.vo.Item;

import java.util.Date;
import java.util.List;


/**
 * Screen used for validating the services.
 */
public class LoginActivity extends Activity implements OnClickListener, UIItemService {


    private ImageView profileImage = null;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button serviceButton = (Button) findViewById(R.id.email_sign_in_button);
        profileImage = (ImageView) findViewById(R.id.profileImage);
        serviceButton.setOnClickListener(this);
    }


    /**
     * This method will be called, when the user clicks on registration button.
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        ItemService itemService = new ItemServiceImpl();

        Cook cook = new Cook("uid1", "name1", "address1", "email1", "phoneNumber1", "profilePicPath1");

        Item item = new Item("name1", "cat1", "desc1", 2, 1, "path1", "class1", "12345", "sched1", cook);
        itemService.add(item);
        //itemService.read("aa",this);
        //itemService.delete("-LB9BnyyxTnBCraMou9r");


    }


    @Override
    public void displayAllItems(List<Item> items) {
        System.out.print(items);
    }
}

