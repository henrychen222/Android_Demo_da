package com.sutest.shixun.acty;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.sutest.shixun.R;
import com.sutest.shixun.adapter.PeopleBaseAdapter;
import com.sutest.shixun.db.DataBaseHelper;
import com.sutest.shixun.db.DataBaseManager;
import com.sutest.shixun.item.PeopleItem;

public class DataBaseActy extends Activity implements OnClickListener{
	
	
	protected Context mContext;
	private ListView listView;
	private List<PeopleItem> peopleList = new ArrayList<PeopleItem>();
	private PeopleBaseAdapter peopleItemAdapter;
	private EditText sexET;
	private EditText ageET;
	private EditText nameET;
	private EditText phoneET;
	private Button addBN;
	private Button deleteBN;
	private Button updateBN;
	private Button chaBN;
	/** 列表选中的人*/
	private PeopleItem people;
	private DataBaseManager dataBaseManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_db_list);
		
		initVar();
		
		findViews();
		
		
		bindViews();
		
		setOnListener();
		
	}
	
	private void initVar() {
		mContext = this;
		dataBaseManager = new DataBaseManager(mContext);
		peopleItemAdapter = new PeopleBaseAdapter(mContext, peopleList);
		
		people = new PeopleItem();
		people.setName("张三");
		people.setAge(22);
		people.setSex("男");
		people.setPhone("13515118999");
	}

	private void findViews() {
		listView = (ListView)findViewById(R.id.adl_lv_listView);
		listView.setAdapter(peopleItemAdapter);
		
		phoneET = (EditText)findViewById(R.id.adl_et_phone);
		nameET = (EditText)findViewById(R.id.adl_et_name);
		ageET = (EditText)findViewById(R.id.adl_et_age);
		sexET = (EditText)findViewById(R.id.adl_et_sex);
		
		addBN = (Button)findViewById(R.id.adl_bn_add);
		deleteBN = (Button)findViewById(R.id.adl_bn_delete);
		updateBN = (Button)findViewById(R.id.adl_bn_update);
		chaBN = (Button)findViewById(R.id.adl_bn_cha);
	}

	private void bindViews() {
		nameET.setText(people.getName());
		
		ageET.setText(people.getAge() + "");
//		ageET.setText(R.string.app_name);
		
		sexET.setText(people.getSex());
		phoneET.setText(people.getPhone());
	}

	private void setOnListener() {
		addBN.setOnClickListener(this);
		deleteBN.setOnClickListener(this);
		updateBN.setOnClickListener(this);
		chaBN.setOnClickListener(this);
		// 选中监听
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				people = (PeopleItem)peopleItemAdapter.getItem(position);
				bindViews();
			}
		});
	}

	
	private int index = 0;
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adl_bn_add:
			people.setName(nameET.getText().toString());
			try {
				people.setAge(Integer.valueOf(ageET.getText().toString()));
			} catch (Exception e) {
			}
			people.setPhone(phoneET.getText().toString());
			people.setSex(sexET.getText().toString());
			
			index ++;
			people.setId("00" + index);
			dataBaseManager.addPeople(people);
			break;
		case R.id.adl_bn_delete:
			dataBaseManager.deletePeople(people);
			break;
		case R.id.adl_bn_update:
			people.setName(nameET.getText().toString());
			try {
				people.setAge(Integer.valueOf(ageET.getText().toString()));
			} catch (Exception e) {
			}
			people.setPhone(phoneET.getText().toString());
			people.setSex(sexET.getText().toString());
			
			dataBaseManager.updatePeople(people);
			break;
		case R.id.adl_bn_cha:
			String sql = "select * from " + DataBaseHelper.TAB_PEOPLE;
			peopleList = dataBaseManager.getPeopleList(sql);
			
			peopleItemAdapter.setPeopleList(peopleList);
			peopleItemAdapter.notifyDataSetChanged();
			
			break;
		default:
			break;
		}
		
	}

	
	
	
}
