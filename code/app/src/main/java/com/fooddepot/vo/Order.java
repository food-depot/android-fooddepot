package com.fooddepot.vo;

/**
 * Created by mudrita on 5/3/18.
 */

public class Order {
    private String orderId;
    private String orderStatus;
    private String orderDate;
    private String orderTime;
    private String quantity;
    private String totalPrice;
    private boolean isPaid;
    private Item item;
    private User user;

    public Order(){

    }

    public Order(String orderStatus, String orderDate, String orderTime,
                 String quantity, String totalPrice, boolean isPaid, Item item, User user) {
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.isPaid = isPaid;
        this.item = item;
        this.user = user;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
