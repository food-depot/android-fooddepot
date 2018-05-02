package com.fooddepot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.fooddepot.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SimpleTimeZone;


public class SearchFragment extends Fragment {
    public static final String ITEM_NAME = "EXTRA_COUNTRY";
    public static final String IMAGE_NAME = "IMAGE_NAME";
    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        String[] menuItems = {"Apple Pie", "cheesecake", "Classic Burger", "Chef Salad"};
        // String [] addresslist = {"3932 Rivermark Plaza, Santa Clara, CA 95054","3932 Rivermark Plaza, Santa Clara, CA 95054","3932 Rivermark Plaza, Santa Clara, CA 95054","3932 Rivermark Plaza, Santa Clara, CA 95054"};
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


        ListView listView = (ListView) view.findViewById(R.id.restaurantList);

        /*ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>
                (getActivity(),android.R.layout.simple_list_item_1,menuItems);*/

        adapter = new SimpleAdapter(getActivity(), data, R.layout.model, from, to);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), data.get(position).get("Menu"), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ITEM_NAME, data.get(position).get("Menu"));
                bundle.putString(IMAGE_NAME, data.get(position).get("Image"));
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });

        return view;

    }



}