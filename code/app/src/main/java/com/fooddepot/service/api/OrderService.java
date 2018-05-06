package com.fooddepot.service.api;

import com.fooddepot.ui.api.UIItemService;
import com.fooddepot.ui.api.UIOrderService;
import com.fooddepot.vo.Item;
import com.fooddepot.vo.Order;

public interface OrderService {
    void add(Order order);
    void delete(String id);
    void readByCook(String cookId,UIOrderService uiOrderService);
    void readByUser(String userId,UIOrderService uiOrderService);
    void update(Order order);

}
