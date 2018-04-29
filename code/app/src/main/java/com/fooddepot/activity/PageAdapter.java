package com.fooddepot.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fooddepot.activity.cook.CookMenuFragment;
import com.fooddepot.activity.cook.CookOrdersFragment;
import com.fooddepot.activity.cook.CookProfileFragment;
import com.fooddepot.activity.cook.CookRatingsFragment;

/**
 * Created by mudrita on 4/29/18.
 */

public class PageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CookProfileFragment();
            case 1:
                return new CookMenuFragment();
            case 2:
                return new CookOrdersFragment();
            case 3:
                return new CookRatingsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }




}
