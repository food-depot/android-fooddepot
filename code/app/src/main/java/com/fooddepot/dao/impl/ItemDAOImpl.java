package com.fooddepot.dao.impl;

import android.util.Log;

import com.fooddepot.dao.api.ItemDAO;
import com.fooddepot.exception.ItemException;
import com.fooddepot.ui.api.UIItemService;
import com.fooddepot.util.DAOUtil;
import com.fooddepot.util.PathUtil;
import com.fooddepot.vo.Item;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Map;

/**
 * Created by ravisha on 4/26/18.
 */

public class ItemDAOImpl implements ItemDAO {

    String TAG = "ItemDAOImpl";

    String itemPath =  PathUtil.getItemPath();

    @Override
    public void add(Item item) throws ItemException{
        try{
            DAOUtil.getDatabaseReference().child(itemPath).child(DAOUtil.getDatabaseReference().push().getKey()).setValue(item);
            //DAOUtil.getDatabaseReference().child(itemPath).child(DAOUtil.getDatabaseReference().push().getKey()).setValue(item);
        }catch(Exception exception){
            Log.e(TAG,"Error adding item",exception);
            throw new ItemException("Error",exception);
        }
    }

    @Override
    public void read(String itemId, final UIItemService uiItemService) throws ItemException {

        try{
            System.out.println("Lis of all items..");

            DAOUtil.getDatabaseReference().child(itemPath).addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            GenericTypeIndicator< Map<String,Item>> genericTypeIndicator = new GenericTypeIndicator< Map<String,Item>>() {
                            };
                            Map<String,Item> attendanceInfo = dataSnapshot.getValue(genericTypeIndicator);
                            System.out.println("Lis of all items.."+attendanceInfo);
                            //uiItemService.displayAllItems(attendanceInfo);


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }catch(Exception exception){
            Log.e(TAG,"Error getting attendance",exception);
            throw new ItemException("Error",exception);

        }




    }

    @Override
    public void delete(String id) throws Exception {
        String itemIDPath =  PathUtil.getItemIdPath(id);
        DAOUtil.getDatabaseReference().child(itemIDPath).removeValue();
    }

    @Override
    public void update(String id, Item item) throws ItemException{
        try{
            DAOUtil.getDatabaseReference().child(PathUtil.getItemIdPath(id)).setValue(item);
            //DAOUtil.getDatabaseReference().child(itemPath).child(DAOUtil.getDatabaseReference().push().getKey()).setValue(item);
        }catch(Exception exception){
            Log.e(TAG,"Error adding item",exception);
            throw new ItemException("Error",exception);
        }
    }
}
