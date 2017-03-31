package com.bysj.account.adapter;

import com.bysj.account.ui.MainActivity;
import com.bysj.account.ui.fragment_bills;
import com.bysj.account.ui.fragment_wallet;
import com.bysj.account.ui.fragment_chart;
import com.bysj.account.ui.fragment_setting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Jay on 2015/8/31 0031.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private fragment_bills myFragment1 = null; 
    private fragment_wallet myFragment2 = null;
    private fragment_chart myFragment3 = null;
    private fragment_setting myFragment4 = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new fragment_bills();
        myFragment2 = new fragment_wallet();
        myFragment3 = new fragment_chart();
        myFragment4 = new fragment_setting();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }
    
    


}

