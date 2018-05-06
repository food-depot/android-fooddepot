package com.fooddepot.activity.cook;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.fooddepot.BlankFragment;
import com.fooddepot.R;
import com.fooddepot.service.api.OrderService;
import com.fooddepot.service.impl.OrderServiceImpl;
import com.fooddepot.ui.api.UIOrderService;
import com.fooddepot.vo.Order;

import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class CookOrdersFragment extends Fragment implements UIOrderService {
    ListView orderList;
    String customer_names[]={"Rachel Green","Ross Gellar","Monica Gellar","Phoebe Buffay","Joe Tribiani"};
    String phonenos[]={"+1(345)345-3456","+1(345)345-3456","+1(345)345-3456","+1(345)345-3456","+1(345)345-3456"};
    String orderTime[]={"04/23/2018 14:35","04/21/2018 14:35","04/20/2018 14:35","04/19/2018 14:35","04/17/2018 14:35"};
    String items[]={"Pizza","Pasta","Burger","Sandwich","Cake"};
    String qntys[]={"1","1","3","2","1"};
    String prices[]={"$4.99","$6.99","$5.98","$4.89","$9.80"};
    int imgs[]={R.drawable.profile_pic,R.drawable.profile_pic,R.drawable.profile_pic,R.drawable.profile_pic,R.drawable.profile_pic};


    List<Order> orders;
    OrderService orderService;
    Order order;


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

        orderService = new OrderServiceImpl();
        orderService.readByCook("-LBcVcgEgfsmxlrMD4n8", this);

        orderList = (ListView) getView().findViewById(R.id.orderList);



    }

    @Override
    public void displayAllOrders(List<Order> orders) {
        this.orders=orders;

        CustomAdapter blankFragment = new CustomAdapter(orders);
        orderList.setAdapter(blankFragment);
    }

    @Override
    public void displayOrder(Order order) {

    }

    private class CustomAdapter extends BaseAdapter{

        List<Order> orders;
        CustomAdapter(List<Order> orders){
           this.orders = orders;
        }

        @Override
        public int getCount() {
            return orders.size();
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
                final Spinner order_status = (Spinner)view.findViewById(R.id.order_status);
//                RatingBar order_rating = (RatingBar)view.findViewById(R.id.order_rating);
                ImageView customer_img = (ImageView)view.findViewById(R.id.customer_img);

                final Order order = orders.get(i);

                customer_name.setText(orders.get(i).getUserName());
                phone_txtvw.setText(orders.get(i).getUserPhone());
                datetime_txtvw.setText(orders.get(i).getOrderDate()+" "+orders.get(i).getOrderTime());
                itemName.setText(orders.get(i).getItem().getName());
                qnty.setText(orders.get(i).getQuantity());
                price.setText(orders.get(i).getTotalPrice());
//                order_status.setText([i]);
//                order_rating.setText([i]);
                customer_img.setImageResource(imgs[i]);

            String orderStatus[]=getResources().getStringArray(R.array.order_status);
            int catPos=0;
            for(int t=0; i < orderStatus.length; i++)
                if(orderStatus[i].equals(order.getOrderStatus()))
                    catPos = i;

            order_status.setSelection(catPos);
            order_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {
                    Log.d("FoodDepot",order_status.getSelectedItem().toString());

                    Log.d("FoodDepot",order.getOrderStatus());
                    if(!order_status.getSelectedItem().toString().equals(order.getOrderStatus())){
                        order.setOrderStatus(order_status.getSelectedItem().toString());
                        orderService.update(order);}
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            return view;
        }
    }


}
