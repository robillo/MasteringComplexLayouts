package com.appbusters.robinkamboj.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    private TextView mTextMessage;
    private String from;
    private ViewPagerAdapter adapter;
    private nViewPagerAdapter pagerAdapter = null;
    private ScreenSlidePager adapterSlide;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:{
                    from = getString(R.string.title_home);
//                    setupViewPager(viewPager, from);
                    adapterSlide = new ScreenSlidePager(getSupportFragmentManager(), from);
                    viewPager.setAdapter(adapterSlide);
                    return true;
                }
                case R.id.navigation_dashboard:{
                    from = getString(R.string.guru);
//                    setupViewPager(viewPager, from);
                    adapterSlide = new ScreenSlidePager(getSupportFragmentManager(), from);
                    viewPager.setAdapter(adapterSlide);
                    return true;
                }
                case R.id.navigation_notifications:{
                    from = getString(R.string.explore);
//                    setupViewPager(viewPager, from);
                    adapterSlide = new ScreenSlidePager(getSupportFragmentManager(), from);
                    viewPager.setAdapter(adapterSlide);
                    return true;
                }
                case R.id.navigation_your_feeds:{
                    from = getString(R.string.your_feeds);
//                    setupViewPager(viewPager, from);
                    adapterSlide = new ScreenSlidePager(getSupportFragmentManager(), from);
                    viewPager.setAdapter(adapterSlide);
                    return true;
                }
                case R.id.navigation_profile:{
                    from = getString(R.string.profile);
//                    setupViewPager(viewPager, from);
                    adapterSlide = new ScreenSlidePager(getSupportFragmentManager(), from);
                    viewPager.setAdapter(adapterSlide);
                    return true;
                }
            }
            return false;
        }

    };

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        pagerAdapter = new nViewPagerAdapter();

//        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        from = getString(R.string.title_home);
        setSupportActionBar(toolbar);
//        setupViewPager(viewPager, from);
//        viewPager.setOnPageChangeListener(this);
        adapterSlide = new ScreenSlidePager(getSupportFragmentManager(), from);
        viewPager.setAdapter(adapterSlide);
        tabLayout.setupWithViewPager(viewPager);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//        Fragment fragment = adapter.getFragment(position);
//        if (fragment != null) {
//            fragment.onResume();
//        }
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }

    private void setupViewPager(ViewPager viewPager, String from) {

//        if(adapter.getCount()>0){
//            viewPager.removeAllViews();
//        }
//
//        Fragment fragment = new TempFragment();
//        Bundle args = new Bundle();
//        args.putString("from", from);
//        fragment.setArguments(args);
//
//        adapter.addFragment(fragment, "Status");
//
//        fragment = new TempFragment();
//        fragment.setArguments(args);
//
//        adapter.addFragment(fragment, "Photos");
//
//        fragment = new TempFragment();
//        fragment.setArguments(args);
//
//        adapter.addFragment(fragment, "Videos");
//        adapter.notifyDataSetChanged();
//
//        viewPager.setAdapter(adapter);
    }
}
