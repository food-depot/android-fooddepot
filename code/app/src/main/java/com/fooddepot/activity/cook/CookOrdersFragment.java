package com.fooddepot.activity.cook;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.fooddepot.BlankFragment;
import com.fooddepot.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CookOrdersFragment extends Fragment {
    ListView orderList;
    String customer_names[]={"Rachel Green","Ross Gellar","Monica Gellar","Phoebe Buffay","Joe Tribiani"};
    String phonenos[]={"+1(345)345-3456","+1(345)345-3456","+1(345)345-3456","+1(345)345-3456","+1(345)345-3456"};
    String orderTime[]={"04/23/2018 14:35","04/21/2018 14:35","04/20/2018 14:35","04/19/2018 14:35","04/17/2018 14:35"};
    String items[]={"Pizza","Pasta","Burger","Sandwich","Cake"};
    String qntys[]={"1","1","3","2","1"};
    String prices[]={"$4.99","$6.99","$5.98","$4.89","$9.80"};
    int imgs[]={R.drawable.profile_pic,R.drawable.profile_pic,R.drawable.profile_pic,R.drawable.profile_pic,R.drawable.profile_pic};


    public CookOrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cook_orders, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        orderList = (ListView) getView().findViewById(R.id.orderList);

        CustomAdapter blankFragment = new CustomAdapter();
        orderList.setAdapter(blankFragment);

    }

    private class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return customer_names.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.fragment_order_adapter,null);
                TextView customer_name = (TextView)view.findViewById(R.id.name_txtvw);
                TextView phone_txtvw = (TextView)view.findViewById(R.id.phone_txtvw);
                TextView datetime_txtvw = (TextView)view.findViewById(R.id.datetime_txtvw);
                TextView itemName = (TextView)view.findViewById(R.id.itemName);
                TextView qnty = (TextView)view.findViewById(R.id.qnty);
                TextView price = (TextView)view.findViewById(R.id.price);
//                Spinner order_status = (Spinner)view.findViewById(R.id.order_status);
//                RatingBar order_rating = (RatingBar)view.findViewById(R.id.order_rating);
                ImageView customer_img = (ImageView)view.findViewById(R.id.customer_img);

                customer_name.setText(customer_names[i]);
                phone_txtvw.setText(phonenos[i]);
                datetime_txtvw.setText(orderTime[i]);
                itemName.setText(items[i]);
                qnty.setText(qntys[i]);
                price.setText(prices[i]);
//                order_status.setText([i]);
//                order_rating.setText([i]);
                customer_img.setImageResource(imgs[i]);
            return view;
        }
    }


}
