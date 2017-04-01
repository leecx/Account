package com.bysj.account.ui;

import com.bysj.account.R;
import com.bysj.account.adapter.MyFragmentPagerAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Coder-pig on 2015/8/28 0028.
 */
public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    //UI Objects
    private RadioGroup rg_tab_bar;
    private RadioButton rb_bills;
    private RadioButton rb_wallet;
    private RadioButton rb_chart;
    private RadioButton rb_setting;
    private ViewPager vpager;
  
    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_bills.setChecked(true);
    }

    private void bindViews() {
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_bills = (RadioButton) findViewById(R.id.rb_bills);
        rb_wallet = (RadioButton) findViewById(R.id.rb_wallet);
        rb_chart = (RadioButton) findViewById(R.id.rb_chart);
        rb_setting = (RadioButton) findViewById(R.id.rb_setting);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.setOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_bills:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_wallet:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_chart:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_setting:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }
    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_bills.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_wallet.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_chart.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_setting.setChecked(true);
                    break;
            }
        }
    }
    
    //添加清单按钮事件，即打开记账页面
    public void onClick_keepAccout(View v){
    	Intent intent = new Intent(MainActivity.this,AddBill_Activity.class);
    	startActivity(intent);
    }
    
}
