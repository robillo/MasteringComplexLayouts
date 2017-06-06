package com.appbusters.robinkamboj.bottomnavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ScreenSlidePager extends FragmentStatePagerAdapter {

    public ScreenSlidePager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: {
                return assignFragment(0, "HOME");
            }
            case 1: {
                return assignFragment(1, "GURU");
            }
            case 2: {
                return assignFragment(2, "EXPLORE");
            }
            default: {
                return assignFragment(0, "HOME");
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
}