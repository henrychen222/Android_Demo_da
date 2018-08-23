package com.example.weichen.myapplication.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Contacts.People;

import com.example.weichen.myapplication.item.PeopleItem;

public class DataBaseManager {
	
	private DataBaseHelper dataBaseHelper;
	private Context mCtx;
	
	public DataBaseManager(Context ctx){
		this.mCtx = ctx;
		dataBaseHelper = new DataBaseHelper(ctx);
	}
	
	
	
	// ����һ����
	public void addPeople(PeopleItem people){
		ContentValues contentValues = new ContentValues();
		contentValues.put("id", people.getId());
		contentValues.put("name", people.getName());
		contentValues.put("sex", people.getSex());
		contentValues.put("phone", people.getPhone());
		contentValues.put("age", people.getAge());
		
		// ִ�в���
		SQLiteDatabase writableDatabase = dataBaseHelper.getWritableDatabase();
		writableDatabase.insert(DataBaseHelper.TAB_PEOPLE, null, contentValues);
		
	}
	// ɾ��һ����
	public void deletePeople(PeopleItem people){
		SQLiteDatabase writableDatabase = dataBaseHelper.getWritableDatabase();
		writableDatabase.delete(DataBaseHelper.TAB_PEOPLE, " id = ? ", new String[]{people.getId()});
	}
	
	// �޸�һ����
	public void updatePeople(PeopleItem people){
		ContentValues contentValues = new ContentValues();
		contentValues.put("id", people.getId());
		contentValues.put("name", people.getName());
		contentValues.put("sex", people.getSex());
		contentValues.put("phone", people.getPhone());
		contentValues.put("age", people.getAge());
		
		// ִ���޸�
		SQLiteDatabase writableDatabase = dataBaseHelper.getWritableDatabase();
		writableDatabase.update(DataBaseHelper.TAB_PEOPLE, contentValues, " id = ? ", new String[]{people.getId()});
	}
	
	// ��ѯ���б�
	public List<PeopleItem> getPeopleList(String sql){
		List<PeopleItem> list = new ArrayList<PeopleItem>();
		SQLiteDatabase readableDatabase = dataBaseHelper.getReadableDatabase();
		Cursor cursor = readableDatabase.rawQuery(sql, null);
		PeopleItem people;
		while (cursor.moveToNext()) {
			people = new PeopleItem();
			people.setId(cursor.getString(cursor.getColumnIndex("id")));
			people.setName(cursor.getString(cursor.getColumnIndex("name")));
			people.setSex(cursor.getString(cursor.getColumnIndex("sex")));
			people.setAge(cursor.getInt(cursor.getColumnIndex("age")));
			people.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
			list.add(people);
		}
		cursor.close();
		return list;
	}
	

}
