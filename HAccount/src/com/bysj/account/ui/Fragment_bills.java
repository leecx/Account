package com.bysj.account.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bysj.account.R;
import com.bysj.account.adapter.ImAdapter;
import com.bysj.account.model.Bill;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class Fragment_bills extends Fragment  {

	
	private View view;
	private ListView biil_list;
	private ImAdapter<Bill> imAdapter = null;
	private List<Bill> bills = null;
	
    public Fragment_bills() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fg_bills, container, false);
         init();
         
        return view;
    }

	private void init() {
		
		biil_list = (ListView) view.findViewById(R.id.bill_list);
		
		//构造数据
		
		bills = new ArrayList<Bill>();
		bills.add(new Bill(R.drawable.ic_launcher, "吃饭", 20.00, new Date()));
		bills.add(new Bill(R.drawable.ic_launcher, "吃饭", 20.00, new Date()));
		bills.add(new Bill(R.drawable.ic_launcher, "吃饭", 20.00, new Date()));
		bills.add(new Bill(R.drawable.ic_launcher, "吃饭", 20.00, new Date()));
		bills.add(new Bill(R.drawable.ic_launcher, "吃饭", 20.00, new Date()));
		bills.add(new Bill(R.drawable.ic_launcher, "吃饭", 20.00, new Date()));
		bills.add(new Bill(R.drawable.ic_launcher, "吃饭", 20.00, new Date()));
		
		//adapter初始化
		imAdapter = new ImAdapter<Bill>((ArrayList<Bill>)bills,R.layout.item_bill_list) {
				
			@Override
			public void bindView(
					 ViewHolder holder,
					Bill obj) {
				holder.setImageResource(R.id.img_icon,obj.getbIcon());
				holder.setText(R.id.bname, obj.getbName()+obj.getbMoney()+new SimpleDateFormat("yyyy-MM-DD").format(obj.getbDate()));
			} 
		};
		
		biil_list.setAdapter(imAdapter);
		
	}

}
