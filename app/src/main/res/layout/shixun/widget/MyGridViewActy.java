package com.sutest.shixun.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.sutest.shixun.R;
import com.sutest.shixun.adapter.QiuBaseAdapter;
import com.sutest.shixun.item.QiuItem;

public class MyGridViewActy extends Activity {

	private GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_grid_view);
		
		initVar();
		
		findViews();
		
		bindViews();
		
	}

	private void initVar() {
		
	}

	private void findViews() {
		gridView = (GridView)findViewById(R.id.agv_gv_grid);
		
	}

	private void bindViews() {
		List<QiuItem> qiuList = new ArrayList<QiuItem>();
		int[] imageIds = new int[] {R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7, R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10, R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13,
				R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16 };
		QiuItem qiuItem;
		for (int i = 0; i < imageIds.length ; i++) {
			qiuItem = new QiuItem();
			qiuItem.setName("ÖØÐÍÕ¨µ¯" + i);
			qiuItem.setResId(imageIds[i]);
			qiuList.add(qiuItem);
		}
		
		QiuBaseAdapter qiuBaseAdapter = new QiuBaseAdapter(MyGridViewActy.this, qiuList);
		
		gridView.setAdapter(qiuBaseAdapter);
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Log.i("","position-->" + position);
			}
		});
		
	}
	
	
	

}
