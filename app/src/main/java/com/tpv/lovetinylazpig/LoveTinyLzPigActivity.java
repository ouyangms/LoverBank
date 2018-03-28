package com.tpv.lovetinylazpig;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.tpv.lovetinylazpig.R;

import java.util.ArrayList;
import java.util.List;

public class LoveTinyLzPigActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawLayout;
    private ViewPager mViewPager = null;
    private static final int[] mIds = {R.id.main_activity_navigation_menu_home, R.id.main_activity_navigation_menu_chat, R.id.main_activity_navigation_menu_time};
    private List<Fragment> mFragments = new ArrayList<>();
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.e("ouyang", "onNavigationItemSelected: " + item.toString());
            switch (item.getItemId()) {
                case R.id.main_activity_navigation_menu_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.main_activity_navigation_menu_chat:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.main_activity_navigation_menu_time:
                    mViewPager.setCurrentItem(2);
                    return true;
                default:
                    return false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_draw);
        for (int i = 0; i < mIds.length; i++) {
            mFragments.add(i, FragmentFactory.newFragmentInstance(mIds[i]));
        }
        mViewPager = findViewById(R.id.fragment_view_pager);
        FragmentViewPagerAdapter bottomNavPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(bottomNavPagerAdapter);
        mViewPager.setOffscreenPageLimit(bottomNavPagerAdapter.getCount() - 1);
        mViewPager.setCurrentItem(0);
        final BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                navigation.setSelectedItemId(mIds[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mDrawLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if (mDrawLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle activity_navigation_draw_bottom_navigation_menus view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_camera:
                break;
            case R.id.nav_gallery:
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
                default:
                    break;

        }
        mDrawLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
