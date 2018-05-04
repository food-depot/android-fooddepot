package com.fooddepot.vo;

import java.util.List;

/**
 * Created by ravisha on 4/26/18.
 */

public class Cook {
    String uid;
    String name;
    String email;
    String phoneNumber;
    String profilePicPath;
    String nickName;
    String addressLine1;
    String addressLine2;
    String state;
    String country;
    String zipcode;
    String desc;


    List<Item> items;

    public Cook(){

    }

    public Cook(String uid, String nickName, String addressLine1, String addressLine2,String state,
                String country,String zipcode,String desc,String name,String email, String phoneNumber, String profilePicPath) {
        this.uid = uid;
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2=addressLine2;
        this.state=state;
        this.country=country;
        this.zipcode=zipcode;
        this.desc=desc;
        this.nickName=nickName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profilePicPath = profilePicPath;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }




    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePicPath() {
        return profilePicPath;
    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
