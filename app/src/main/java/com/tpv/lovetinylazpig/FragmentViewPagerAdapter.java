package com.tpv.lovetinylazpig;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

/**
 * Created by loyouyang on 3/22/18.
 */

public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    private FragmentManager fm;
    private List<Fragment> fragments;

    public FragmentViewPagerAdapter(FragmentManager fm, List<Fragment> fragments){
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
