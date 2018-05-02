package com.fooddepot.activity.cook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fooddepot.R;
import com.fooddepot.activity.DetailActivity;
import com.fooddepot.activity.RoleActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CookMenuListFragment extends Fragment {

    ListView menuList;
    FloatingActionButton addMenu;
    String item_names[]={"Pizza","Pasta","Burger","Salad","Biriyani"};
    String qntys[]={"1","1","3","2","1"};
    String prices[]={"$4.99","$6.99","$5.98","$4.89","$9.80"};
    String avlbltil[]={"04/23/2018 14:35","04/21/2018 14:35","04/20/2018 14:35","04/19/2018 14:35","04/17/2018 14:35"};
    String desc[]={"servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings","servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings","servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings","servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings","servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings"};
    int imgs[]={R.drawable.food_default,R.drawable.food_default,R.drawable.food_default,R.drawable.food_default,R.drawable.food_default};
    float ratings[] ={2.0f,3.5f,4f,4.5f,5f};




    public CookMenuListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cook_menu_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menuList = (ListView) getView().findViewById(R.id.menuList);

        CustomAdapter menuFragment = new CustomAdapter();
        menuList.setAdapter(menuFragment);

        addMenu();

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(), AddMenuActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString(ITEM_NAME, data.get(position).get("Menu"));
//                bundle.putString(IMAGE_NAME, data.get(position).get("Image"));
//                intent.putExtras(bundle);
                startActivity(intent);


            }
        });

    }

    public void addMenu(){
        addMenu =(FloatingActionButton)getView().findViewById(R.id.addMenu);
        addMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),AddMenuActivity.class);
                startActivity(i);
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return item_names.length;
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
            view = getLayoutInflater().inflate(R.layout.fragment_cook_menu_adapter,null);
            TextView itemName_txtvw = (TextView)view.findViewById(R.id.itemName_txtvw);
            TextView qnty_txtvw = (TextView)view.findViewById(R.id.qnty_txtvw);
            TextView price_txtvw = (TextView)view.findViewById(R.id.price_txtvw);
            TextView availableuntil_txtvw = (TextView)view.findViewById(R.id.availableuntil_txtvw);
            TextView itemdesc = (TextView)view.findViewById(R.id.itemdesc);
            RatingBar item_rating = (RatingBar)view.findViewById(R.id.item_rating);
            ImageView food_img = (ImageView)view.findViewById(R.id.food_img);
            itemName_txtvw.setText(item_names[i]);
            qnty_txtvw.setText(qntys[i]);
            price_txtvw.setText(prices[i]+"/unit");
            availableuntil_txtvw.setText(avlbltil[i]);
            itemdesc.setText(desc[i]);

            item_rating.setRating(ratings[i]);
            food_img.setImageResource(imgs[i]);
            return view;
        }
    }


}
