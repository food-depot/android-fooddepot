package com.fooddepot.vo;

/**
 * Created by ravisha on 4/26/18.
 */

public class Cook {
    String uid;
    String name;
    String address;
    String email;
    String phoneNumber;
    String profilePicPath;

    public Cook(){

    }

    public Cook(String uid, String name, String address, String email, String phoneNumber, String profilePicPath) {
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profilePicPath = profilePicPath;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
