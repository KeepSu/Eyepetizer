package com.tzs.eyepetizer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by TZS on 2017/1/11.
 */

public class FindTabAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private List<String> title;

    public FindTabAdapter(FragmentManager fm, List<Fragment> data, List<String> title) {
        super(fm);
        this.data = data;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
