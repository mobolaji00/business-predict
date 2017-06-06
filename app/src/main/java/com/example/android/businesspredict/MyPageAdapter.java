package com.example.android.businesspredict;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mobolajioo on 5/17/17.
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragments;
    private HashMap<Integer,Fragment> registeredFragments;

    public MyPageAdapter(FragmentManager fm, ArrayList<Fragment> fragments)
    {
        super(fm);
        this.fragments = fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }
    @Override
    public int getCount() {
        return this.fragments.size();
    }


    public ArrayList getFragments()
    {
        return fragments;
    }

}

