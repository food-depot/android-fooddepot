package com.fooddepot.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.fooddepot.R;
import com.fooddepot.service.api.CookService;
import com.fooddepot.service.api.ItemService;
import com.fooddepot.service.api.OrderService;
import com.fooddepot.service.impl.CookServiceImpl;
import com.fooddepot.service.impl.ItemServiceImpl;
import com.fooddepot.service.impl.OrderServiceImpl;
import com.fooddepot.ui.api.UICookService;
import com.fooddepot.ui.api.UIItemService;
import com.fooddepot.ui.api.UIOrderService;
import com.fooddepot.vo.Cook;
import com.fooddepot.vo.Item;
import com.fooddepot.vo.Order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DetailActivity extends AppCompatActivity implements UIItemService,UICookService {

    private TextView tvName, tvDescription, tvPrice,address,contactnumber;
    private ImageView itemImage;
    private Button buy;
    private Spinner spinner;
    ItemService itemService = null;
    CookService cookService = null;
    OrderService orderService = null;
    String itemID,cookID;
    Item item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tvName = (TextView) findViewById(R.id.tvItemName);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        itemImage = (ImageView) findViewById(R.id.itemImage);
        address=(TextView)findViewById(R.id.address);
        contactnumber=(TextView)findViewById(R.id.contactnumber);
        buy=(Button)findViewById(R.id.buy);
        spinner=(Spinner) findViewById(R.id.spinner);
//        tvName.setText("CheeseCake");
//        tvDescription.setText("As the name implies, the recipe for Junior's famous original cheesecake" +
//                " has been baked the very same way since the 1950s. And for good reason. It's simply " +
//                "The Best cheesecake you can find. \"There will never be a better cheesecake than the cheesecake they serve at " +
//                "Junior's on Flatbush Avenue... it's the best ... ");

        ImageView getdirection = (ImageView) findViewById(R.id.drivingdirection) ;
        getdirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView address = (TextView) findViewById(R.id.address);

                String url = "http://maps.google.com/maps?daddr="+address.getText().toString();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
                startActivity(intent);
            }
        });


        //id of RING image
        ImageView callImg = (ImageView) findViewById(R.id.contacticon);
        callImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //id of phone text box
                if (ContextCompat.checkSelfPermission(DetailActivity.this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    TextView editphone = (TextView) findViewById(R.id.contactnumber);
                    Uri phone_number= Uri.parse("tel:" + editphone.getText().toString());
                    Intent callIntent= new Intent(Intent.ACTION_DIAL);
                    //  startActivity( new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + PhoneNumber)));
                    callIntent.setData(phone_number);
                    startActivity(callIntent);
                } else
                {
                    Toast.makeText(DetailActivity.this,"Permission denied to make a call",Toast.LENGTH_SHORT).show();
                }


            }
        });


        Intent intent = getIntent();
        if(intent.hasExtra("ITEM_ID")){
            itemService = new ItemServiceImpl();
            cookService =new CookServiceImpl() ;
            itemID= intent.getStringExtra("ITEM_ID");
            cookID=intent.getStringExtra("COOK_ID");
            Log.d("Id received",itemID);
            Log.d("cookId received",cookID);
            itemService.read(itemID, this);
            cookService.read(cookID,this);

        }

    }

    public void onBuy(View view){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String orderDate = formatter.format(date);
        formatter= new SimpleDateFormat("HH:mm");
        String orderTime = formatter.format(date);
        float totalPrice = Integer.parseInt(spinner.getSelectedItem().toString())*item.getPrice();
        orderService=new OrderServiceImpl();

        Order order = new Order(getResources().getStringArray(R.array.order_status)[0],orderDate,
                orderTime,spinner.getSelectedItem()+"",totalPrice+"",true,item,
                "userID","userName","userPhone");

        orderService.add(order);
    }

    @Override
    public void displayAllItems(List<Item> items) {

    }

    @Override
    public void displayItem(Item item) {
        this.item=item;
        tvName.setText(item.getName());
        tvPrice.setText("$"+item.getPrice()+"/unit");
        tvDescription.setText(item.getDescription());
    }

    @Override
    public void displayItemsList(Map<String, Item> items) {

    }

    @Override
    public void displayAllCooks(List<Cook> cook) {

    }

    @Override
    public void displayCook(Cook cook) {
        address.setText(cook.getAddressLine1()+", "+cook.getAddressLine2()+", "+cook.getState()+", "+cook.getCountry()+", "+cook.getZipcode());
        contactnumber.setText(cook.getPhoneNumber());
    }
}
