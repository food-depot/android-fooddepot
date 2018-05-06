package com.fooddepot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.fooddepot.R;
import com.fooddepot.activity.cook.CookMenuListFragment;
import com.fooddepot.service.api.ItemService;
import com.fooddepot.service.impl.ItemServiceImpl;
import com.fooddepot.ui.api.UIItemService;
import com.fooddepot.vo.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;


public class SearchFragment extends Fragment implements UIItemService {
    public static final String ITEM_NAME = "EXTRA_COUNTRY";
    public static final String IMAGE_NAME = "IMAGE_NAME";
    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;


    ItemService itemService = null;
    List<Item> itemList;
    ListView listView;
    ImageView imageView;
    TextView address,distancetext,nameTxt;

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        itemService=new ItemServiceImpl();
        itemService.readAll(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        String[] menuItems = {"Apple Pie", "cheesecake", "Classic Burger", "Chef Salad"};

        // String [] addresslist = {"3932 Rivermark Plaza, Santa Clara, CA 95054","3932 Rivermark Plaza, Santa Clara,
        // CA 95054","3932 Rivermark Plaza, Santa Clara, CA 95054","3932 Rivermark Plaza, Santa Clara, CA 95054"};
        // int[] price = {};

        int[] images = {R.drawable.apple_pie, R.drawable.cheesecake, R.drawable.classic_burger, R.drawable.chef_salad};
        HashMap<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < menuItems.length; i++) {
            map = new HashMap<String, String>();
            map.put("Menu", menuItems[i]);
            map.put("Image", Integer.toString(images[i]));

            data.add(map);
        }

        String[] from = {"Menu", "Image", "Price", "Address", "phone", "description"};
        int[] to = {R.id.nameTxt, R.id.imageView};


        listView = (ListView) view.findViewById(R.id.restaurantList);

        /*ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>
                (getActivity(),android.R.layout.simple_list_item_1,menuItems);*/

//        adapter = new SimpleAdapter(getActivity(), data, R.layout.model, from, to);
//
//        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), data.get(position).get("Menu"), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("ITEM_ID", itemList.get(position).getItemId());
                intent.putExtra("COOK_ID", itemList.get(position).getCookId());
                Log.d("position passed",position+"");
                Log.d("id passed",itemList.get(position).getItemId());
                Log.d("cook id passed",itemList.get(position).getCookId());

                startActivity(intent);
//                Bundle bundle = new Bundle();

//                bundle.putString(ITEM_NAME, data.get(position).get("Menu"));
//                bundle.putString(IMAGE_NAME, data.get(position).get("Image"));
//                intent.putExtras(bundle);
//                startActivity(intent);


            }
        });

        return view;

    }


    @Override
    public void displayAllItems(List<Item> items) {
        this.itemList=items;
        for(Item item:items){
            Log.d("Item in search",item.getName());
        }

        CustomAdapter itemFragment = new CustomAdapter(itemList);
        listView.setAdapter(itemFragment);



    }

    @Override
    public void displayItem(Item item) {

    }

    @Override
    public void displayItemsList(Map<String, Item> items) {

    }


    private class CustomAdapter extends BaseAdapter {
        List<Item> itemList;
        CustomAdapter(List<Item> itemList){
            this.itemList = itemList;
        }

        @Override
        public int getCount() {
            return itemList.size();
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



            view = getLayoutInflater().inflate(R.layout.model,null);

            imageView = (ImageView)view.findViewById(R.id.imageView);
            address=(TextView)view.findViewById(R.id.address);
            distancetext = (TextView)view.findViewById(R.id.distancetext);
            nameTxt = (TextView)view.findViewById(R.id.nameTxt);

            address.setText(itemList.get(i).getAddress());
            nameTxt.setText(itemList.get(i).getName());


            return view;
        }
    }
}