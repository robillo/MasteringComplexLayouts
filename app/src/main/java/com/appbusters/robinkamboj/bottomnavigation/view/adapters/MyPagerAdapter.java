package com.appbusters.robinkamboj.bottomnavigation.view.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.appbusters.robinkamboj.bottomnavigation.view.fragments.TempFragment;

import java.util.HashMap;
import java.util.Map;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private Map<Integer, String> mFragmentTags;
    private FragmentManager mFragmentManager;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        mFragmentManager = fragmentManager;
        mFragmentTags = new HashMap<Integer, String>();
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TempFragment.newInstance();
            case 1:
                return TempFragment.newInstance();
            case 2:
                return TempFragment.newInstance();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object object = super.instantiateItem(container, position);
        if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            String tag = fragment.getTag();
            mFragmentTags.put(position, tag);
        }
        return object;
    }

    public Fragment getFragment(int position) {
        Fragment fragment = null;
        String tag = mFragmentTags.get(position);
        if (tag != null) {
            fragment = mFragmentManager.findFragmentByTag(tag);
        }
        return fragment;
    }
}