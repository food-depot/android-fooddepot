package com.fooddepot.dao.api;

import com.fooddepot.exception.ItemException;
import com.fooddepot.ui.api.UIItemService;
import com.fooddepot.vo.User;

/**
 * Created by mudrita on 5/3/18.
 */

public interface UserDAO {
    void add(User user) throws ItemException;
    void read(String userID,UIItemService uiItemService) throws ItemException;
    void delete(String userID) throws Exception;
    void update (String userID, User user) throws ItemException;

}
