package com.fooddepot.util;


import com.fooddepot.constants.CommonConstants;


public class PathUtil {

    public static  String getItemPath(){
        StringBuffer itemPath = getRootPath();
        itemPath.append(CommonConstants.ITEMS_PATH);
        itemPath.append(CommonConstants.SEPARATOR);
        return itemPath.toString();
    }

    public static  String getItemIdPath(String itemId){
        StringBuffer itemPath = getRootPath();
        itemPath.append(CommonConstants.ITEMS_PATH);
        itemPath.append(CommonConstants.SEPARATOR);
        itemPath.append(itemId);
        itemPath.append(CommonConstants.SEPARATOR);

        return itemPath.toString();
    }


    public  static StringBuffer getRootPath(){

        StringBuffer rootPath = new StringBuffer();
        rootPath.append(CommonConstants.ROOT_PATH);
        rootPath.append(CommonConstants.SEPARATOR);
        return rootPath;
    }


    public static  String getUserPath(){
        StringBuffer itemPath = getRootPath();
        itemPath.append(CommonConstants.USER_PATH);
        itemPath.append(CommonConstants.SEPARATOR);
        return itemPath.toString();
    }

    public static  String getUserIdPath(String userId){
        StringBuffer itemPath = getRootPath();
        itemPath.append(CommonConstants.USER_PATH);
        itemPath.append(CommonConstants.SEPARATOR);
        itemPath.append(userId);
        itemPath.append(CommonConstants.SEPARATOR);

        return itemPath.toString();
    }

    public static  String getCookPath(){
        StringBuffer itemPath = getRootPath();
        itemPath.append(CommonConstants.COOK_PATH);
        itemPath.append(CommonConstants.SEPARATOR);
        return itemPath.toString();
    }

    public static  String getCookIdPath(String cookId){
        StringBuffer cookPath = getRootPath();
        cookPath.append(CommonConstants.COOK_PATH);
        cookPath.append(CommonConstants.SEPARATOR);
        cookPath.append(cookId);
        cookPath.append(CommonConstants.SEPARATOR);
        return cookPath.toString();
    }

    public static  String getCookItemPath(String cookId){
        StringBuffer cookPath = getRootPath();
        cookPath.append(CommonConstants.COOK_PATH);
        cookPath.append(CommonConstants.SEPARATOR);
        cookPath.append(cookId);
        cookPath.append(CommonConstants.SEPARATOR);
        cookPath.append(CommonConstants.ITEMS_PATH);
        cookPath.append(CommonConstants.SEPARATOR);
        return cookPath.toString();
    }






}
