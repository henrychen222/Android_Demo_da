package com.sutest.shixun.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
	
	private static String dbName = "myData.db";
	private static int version = 4;
	public static String TAB_PEOPLE = "t_people";

	public DataBaseHelper(Context context) {
		super(context, dbName, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("db", "onCreate--------------->");
		// 创建人用户表
		db.execSQL("create table if not exists " + TAB_PEOPLE
				 +" (_id integer, "
				 +" id varchar primary key, "
				 +" name varchar, "
				 +" sex varchar, "
				 +" age varchar, "
				 +" phone varchar) "
				);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("db", "onUpgrade-------oldVersion:" + oldVersion + "--newVersion:" + newVersion);
		db.execSQL("drop table if exists " + TAB_PEOPLE);
		onCreate(db);
	}

}
