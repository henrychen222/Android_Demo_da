package com.example.weichen.myapplication.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

import com.example.weichen.myapplication.R;
import com.example.weichen.myapplication.adapter.ExpandableAdapter;

public class MyExpandableListView extends Activity {

	private ExpandableListView listView;
	private ExpandableAdapter expandableAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_expand_list_view);
		
		initVar();
		
		findViews();
		
		bindViews();
		
		setListener();
		
	}
	

	


	private void initVar() {
		expandableAdapter = new ExpandableAdapter(MyExpandableListView.this);
		String[] groupArr = new String[]{"������222","ֲ����222","΢������222"};
		String[][] childArr = new String[][]{
				{"��è22","��22","Сè22","ë¿22","����22"},
				{"С��22","����22","�ɻ�22","������22"},
				{"ϸ��22","���22","����22"}
		};
		expandableAdapter.setGroupArr(groupArr);
		expandableAdapter.setChildArr(childArr);
	}

	private void findViews() {
		listView = (ExpandableListView)findViewById(R.id.aelv_elv_list);
	}

	private void bindViews() {
		listView.setAdapter(expandableAdapter);
	}
	
	
	private void setListener() {
		listView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				String[][] childArr = expandableAdapter.getChildArr();
				
				String name = childArr[groupPosition][childPosition];
				
				Toast.makeText(MyExpandableListView.this, name, Toast.LENGTH_SHORT).show();
				
				return false;
			}
		});
	}
	
	

}
