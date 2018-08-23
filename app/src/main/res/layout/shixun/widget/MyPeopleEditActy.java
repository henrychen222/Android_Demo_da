package com.sutest.shixun.widget;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.sutest.shixun.R;
import com.sutest.shixun.adapter.GroupPeopleBaseAdapter;
import com.sutest.shixun.item.GroupPeopleItem;

public class MyPeopleEditActy extends Activity {

	private GridView gridView;
	private Button rightBN;
	private GroupPeopleBaseAdapter adapter;
	private int[] imageIds = new int[] {
			R.drawable.head1, R.drawable.head3, R.drawable.head2, 
			R.drawable.head1, R.drawable.head3, R.drawable.head2, 
			R.drawable.head3, R.drawable.head2, R.drawable.head1,
			R.drawable.head2, R.drawable.head3, R.drawable.head1,
			R.drawable.head2, R.drawable.head1, R.drawable.head3, 
			R.drawable.head2 };
	private ArrayList<GroupPeopleItem> peopleList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_people_edit);
		
		initVar();
		
		findViews();
		
		bindViews();
		
		setListener();
		
	}

	

	private void initVar() {
		peopleList = new ArrayList<GroupPeopleItem>();
		GroupPeopleItem groupPeopleItem;
		for (int i = 0; i < imageIds.length; i++) {
			groupPeopleItem = new GroupPeopleItem();
			groupPeopleItem.setName("张三" + i);
			groupPeopleItem.setResId(imageIds[i]);
			peopleList.add(groupPeopleItem);
		}
		adapter = new GroupPeopleBaseAdapter(this, peopleList);
	}

	private void findViews() {
		gridView = (GridView)findViewById(R.id.ape_gv_grid);
		rightBN = (Button)findViewById(R.id.ape_bn_right);
		
	}

	private void bindViews() {
		gridView.setAdapter(adapter);
	}
	
	private void setListener() {
		rightBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 进入编辑状态
				if (rightBN.getTag() == null) {
					rightBN.setTag("--");
					rightBN.setText("完成");
					// 进入编辑状态
					updateData(true);
					
				}
				// 完成状态
				else {
					rightBN.setTag(null);
					rightBN.setText("编辑");
					// 完成状态
					updateData(false);
					
				}
				
			}
		});
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// 加号
				if (position == adapter.getCount() - 1) {
					Toast.makeText(MyPeopleEditActy.this, "点击了加号", Toast.LENGTH_SHORT).show();
					return;
				}
				
				
				GroupPeopleItem item = (GroupPeopleItem)adapter.getItem(position);
				// 完成状态
				if (rightBN.getTag() == null) {
					Toast.makeText(MyPeopleEditActy.this, item.getName(), Toast.LENGTH_SHORT).show();
				}
				else{
					adapter.deletePeople(position);
//					peopleList.remove(position);
					// 真正更新界面的方法
					adapter.notifyDataSetChanged();
				}
				
			}
		});
		
	}
	
	
	private void updateData(boolean isEdit){
		
		List<GroupPeopleItem> allList = adapter.getPeopleList();
		GroupPeopleItem item;
		// 更新数据源里所有对象的isEdit变量（属性）
		for (int i = 0; i < allList.size(); i++) {
			item = allList.get(i);
//			// 0非编辑状态，1编辑状态
//			item.setIsEdit(isEdit? "1":"0");
			
			// 0非编辑状态，1编辑状态
			if (isEdit) {
				item.setIsEdit("1");
			}else{
				item.setIsEdit("0");
			}
			
		}
		// 真正更新界面的方法
		adapter.notifyDataSetChanged();
		
	}
	
	

}
