package com.appbusters.robinkamboj.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private String from = "HOME";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setupViewPager(viewPager, from = getString(R.string.title_home));
                    return true;
                case R.id.navigation_dashboard:
                    setupViewPager(viewPager, from = getString(R.string.guru));
                    return true;
                case R.id.navigation_notifications:
                    setupViewPager(viewPager, from = getString(R.string.explore));
                    return true;
                case R.id.navigation_your_feeds:
                    setupViewPager(viewPager, from = getString(R.string.your_feeds));
                    return true;
                case R.id.navigation_profile:
                    setupViewPager(viewPager, from = getString(R.string.profile));
                    return true;
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

        setSupportActionBar(toolbar);
        setupViewPager(viewPager, from);
        tabLayout.setupWithViewPager(viewPager);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setupViewPager(ViewPager viewPager, String from) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Fragment fragment = new TempFragment();
        Bundle args = new Bundle();
        args.putString("from", from);
        fragment.setArguments(args);

        adapter.addFragment(fragment, "Status");

        fragment = new TempFragment();
        fragment.setArguments(args);

        adapter.addFragment(fragment, "Photos");

        fragment = new TempFragment();
        fragment.setArguments(args);

        adapter.addFragment(fragment, "Videos");

        viewPager.setAdapter(adapter);
    }
}
