package com.fooddepot.storage.impl;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.fooddepot.util.StorageUtil;
import com.fooddepot.storage.api.ProfilePicService;
import com.fooddepot.storage.util.FirebaseImageLoader;

/**
 * Created by ravisha on 12/21/16.
 */
public class ProfilePicServiceImpl implements ProfilePicService {

    @Override
    public void loadProfilePic(Activity activity, ImageView profilePicImageView, String profilePicPath)  {
        Glide.with(activity)
                .using(new FirebaseImageLoader())
                .load(StorageUtil.getStorageReference().child(profilePicPath))
                        .into(profilePicImageView);
    }
}
