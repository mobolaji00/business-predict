package com.example.android.businesspredict;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mobolajioo on 5/17/17.
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private HashMap<Integer,Fragment> registeredFragments;

    public MyPageAdapter(FragmentManager fm, List<Fragment> fragments)
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

    // Register the fragment when the item is instantiated
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        //registeredFragments.put(position, fragment);
        return fragment;
    }

    // Unregister fragment when the item is inactive
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    // Returns the fragment for the position (if instantiated)
    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }


    public List getFragments()
    {
        return fragments;
    }

}

