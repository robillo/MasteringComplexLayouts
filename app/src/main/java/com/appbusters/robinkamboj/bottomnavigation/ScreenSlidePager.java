package com.appbusters.robinkamboj.bottomnavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class ScreenSlidePager extends FragmentStatePagerAdapter {

    private String from;
    private FragmentManager fragmentManager;

    // tab titles
    private String[] tabTitles = new String[]{"Status", "Photos", "Videos"};

    public ScreenSlidePager(FragmentManager fm, String from) {
        super(fm);
        this.from = from;
        this.fragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: {
                return assignFragment(0, from);
            }
            case 1: {
                return assignFragment(1, from);
            }
            case 2: {
                return assignFragment(2, from);
            }
            default: {
                return assignFragment(0, from);
            }
        }
    }

    private Fragment assignFragment(int position, String from){
        Fragment fragment = new TempFragment();
        Bundle args = new Bundle();
        args.putString("from", from);
        args.putInt("levelNumber", position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public float getPageWidth(int position) {
        return 1.0f;
    }
}