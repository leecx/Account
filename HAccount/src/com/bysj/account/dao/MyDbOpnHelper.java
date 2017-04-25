package com.bysj.account.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *@author  created by licx
 *@data    2017年4月5日---上午9:30:45
 */

public class MyDbOpnHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1; //数据库版本号
	
	private static final String DATABASE_NAME = "Account";  //数据库名字
	
	public MyDbOpnHelper(Context context){
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table bills(id integer primary key AUTOINCREMENT,icon integer,name varchar,money varchar,data varchar) ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}


