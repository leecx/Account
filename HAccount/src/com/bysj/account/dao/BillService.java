package com.bysj.account.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bysj.account.model.Bill;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 *@author  created by licx
 *@data    2017年4月5日---上午11:29:13
 */

public class BillService {
	
	private MyDbOpnHelper myDbOpnHelper;
	private Context context;
	private SQLiteDatabase database;
	
	public BillService(Context context){
		this.context = context;
	}
	
	//打开数据库连接
	public void opendb(Context context){
		myDbOpnHelper = new MyDbOpnHelper(context);
		database = myDbOpnHelper.getWritableDatabase();
	}
	
	//关闭数据库连接
	public void closedb(Context context){
		if(database.isOpen()){
			database.close();
		}
	}
	
	//插入表数据
	public void save(String table_name,Bill bill) {
		opendb(context);
		String sql = "insert into bills(icon,name,money,data) values(?,?,?,?)";
		database.execSQL(sql,new Object[]{bill.getbIcon(),bill.getbName(),bill.getbMoney(),bill.getbDate()});
		closedb(context);
	}
	//更新
	
	//删除
	
	//查询
	public List<Bill> findAll() throws Exception{
		opendb(context);
		String sql="select * from bills";
		Cursor cursor = database.rawQuery(sql, null);
		List<Bill> list = new ArrayList<Bill>();
		while(cursor.moveToNext()){
			Bill bill = new Bill();
			bill.setbIcon(cursor.getInt(0));
			bill.setbName(cursor.getString(1));
			bill.setbMoney(cursor.getDouble(2));
			bill.setbDate(new SimpleDateFormat().parse(cursor.getString(3)));
			list.add(bill);
		}
		closedb(context);
		
		return list;
	}

}


