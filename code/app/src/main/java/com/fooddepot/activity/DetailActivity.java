package com.fooddepot.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fooddepot.R;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvDescription, tvPrice;
    private ImageView itemImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String ItemName= bundle.getString("ITEM_NAME");
        String Image = bundle.getString("IMAGE_NAME");
        setContentView(R.layout.activity_detail);


        tvName = (TextView) findViewById(R.id.tvItemName);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        itemImage = (ImageView) findViewById(R.id.itemImage);

        tvName.setText("CheeseCake");
        tvDescription.setText("As the name implies, the recipe for Junior's famous original cheesecake" +
                " has been baked the very same way since the 1950s. And for good reason. It's simply " +
                "The Best cheesecake you can find. \"There will never be a better cheesecake than the cheesecake they serve at " +
                "Junior's on Flatbush Avenue... it's the best ... ");

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

    }

}
