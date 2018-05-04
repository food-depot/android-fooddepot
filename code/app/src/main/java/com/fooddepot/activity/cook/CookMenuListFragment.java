package com.fooddepot.activity.cook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.fooddepot.service.api.ItemService;
import com.fooddepot.service.impl.ItemServiceImpl;
import com.fooddepot.ui.api.UIItemService;
import com.fooddepot.vo.Item;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CookMenuListFragment extends Fragment implements UIItemService {

    ListView menuList;
    FloatingActionButton addMenu;
    String ids[]={"-LBV6OZmf8fs7mm0Oiq7","-LBEghqc2TUEUajMCpvq","-LBEh2mBpGksQC1cEbsU","-LBEh8zC0TkyanZ6hMPQ","-LBHG4uwj5RPulChO1Wx"};
    String item_names[]={"Pizza","Pasta","Burger","Salad","Biriyani"};
    String qntys[]={"1","1","3","2","1"};
    String prices[]={"$4.99","$6.99","$5.98","$4.89","$9.80"};
    String avlbltil[]={"04/23/2018 14:35","04/21/2018 14:35","04/20/2018 14:35","04/19/2018 14:35","04/17/2018 14:35"};
    String desc[]={"servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings","servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings","servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings","servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings","servers 2, comes with pepperoni, mushrooms, onions, black olives, green peppers toppings"};
    int imgs[]={R.drawable.food_default,R.drawable.food_default,R.drawable.food_default,R.drawable.food_default,R.drawable.food_default};
    float ratings[] ={2.0f,3.5f,4f,4.5f,5f};
    List<Item> itemList;

    ItemService itemService = null;
    int itemSize=0;




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


        itemService = new ItemServiceImpl();
        itemService.readAll("-LBcVcgEgfsmxlrMD4n8", this);



        addMenu();

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(), AddMenuActivity.class);
                intent.putExtra("ITEM_ID", ids[position]);
                Log.d("position passed",position+"");
                Log.d("id passed",ids[position]);

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

    @Override
    public void displayAllItems(List<Item> items) {
        itemList=items;
        itemSize=itemList.size();
        System.out.println("Lis of all item in menu list fragment..");
        for(Item i:items){
            Log.d("Menu list",i.getName());
           Log.d("Menu list",i.getDescription());
        }

//        CustomAdapter menuFragment = new CustomAdapter();
//        menuList.setAdapter(menuFragment);
    }

    @Override
    public void displayItem(Item item) {


    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return
                    item_names.length;
                    
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

//            itemName_txtvw.setText(itemList.get(i).getName());
//            qnty_txtvw.setText(itemList.get(i).getQuantity());
//            price_txtvw.setText(itemList.get(i).getPrice()+"/unit");
//            availableuntil_txtvw.setText(itemList.get(i).getDateEnd() + " "+ itemList.get(i).getTimeEnd());
//            itemdesc.setText(itemList.get(i).getDescription());



            itemName_txtvw.setText(item_names[i]);
            qnty_txtvw.setText(qntys[i]);
            price_txtvw.setText(prices[i]+"/unit");
            availableuntil_txtvw.setText(avlbltil[i]);
            itemdesc.setText(desc[i]);

            item_rating.setRating(4F);
            food_img.setImageResource(R.drawable.food_default);
            return view;
        }
    }


}
