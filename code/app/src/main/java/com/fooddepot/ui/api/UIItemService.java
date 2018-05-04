package com.fooddepot.ui.api;

import com.fooddepot.vo.Item;
import com.fooddepot.vo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by ravisha on 4/26/18.
 */

public interface UIItemService {
    void displayAllItems(List<Item> items);
    void displayItem(Item item);
//    void displayUser(User user);

}
