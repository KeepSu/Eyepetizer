package com.tzs.eyepetizer.util;

import android.support.v4.app.Fragment;

import com.tzs.eyepetizer.fragment.DiscoverFragment;
import com.tzs.eyepetizer.fragment.FollowFragment;
import com.tzs.eyepetizer.fragment.MineFragment;
import com.tzs.eyepetizer.fragment.SelectFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment帮助类
 */
public class FragmentUtil {
    private static SelectFragment selectFragment=new SelectFragment();
    private static DiscoverFragment discoverFragment=new DiscoverFragment();
    private static FollowFragment followFragment=new FollowFragment();
    private static MineFragment mineFragment=new MineFragment();
    private static List<Fragment> fragmentList=new ArrayList<>();

    public static List<Fragment> getFragmentList(){
        fragmentList.add(selectFragment);
        fragmentList.add(discoverFragment);
        fragmentList.add(followFragment);
        fragmentList.add(mineFragment);
        return fragmentList;
    }

    public static Fragment getFragment(int position){
        return fragmentList.get(position);
    }
}
