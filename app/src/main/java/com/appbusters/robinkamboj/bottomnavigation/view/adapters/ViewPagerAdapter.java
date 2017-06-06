package com.appbusters.robinkamboj.bottomnavigation.view.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private Map<Integer, String> mFragmentTags;
    private FragmentManager mFragmentManager;
    private static int NUM_ITEMS = 3;

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        mFragmentManager = fragmentManager;
        mFragmentTags = new HashMap<Integer, String>();
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

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return TempFragment.newInstance();
//            case 1:
//                return TempFragment.newInstance();
//            case 2:
//                return TempFragment.newInstance();
//            default:
//                return null;
//        }
//    }

    public void setItem(int position, Fragment fragment){
        mFragmentList.set(position, fragment);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public void removeFragment(int position){
        mFragmentList.remove(position);
        mFragmentTitleList.remove(position);
    }

//    // Returns the page title for the top indicator
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return "Page " + position;
//    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
