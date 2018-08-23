package com.sutest.shixun.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

import com.sutest.shixun.R;
import com.sutest.shixun.adapter.ExpandableAdapter;

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
		String[] groupArr = new String[]{"动物类222","植物类222","微生物类222"};
		String[][] childArr = new String[][]{
				{"熊猫22","大狗22","小猫22","毛驴22","兔子22"},
				{"小草22","大树22","荷花22","仙人掌22"},
				{"细菌22","真菌22","病毒22"}
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
