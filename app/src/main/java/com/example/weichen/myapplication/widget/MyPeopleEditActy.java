package com.example.weichen.myapplication.widget;

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

import com.example.weichen.myapplication.R;
import com.example.weichen.myapplication.adapter.GroupPeopleBaseAdapter;
import com.example.weichen.myapplication.item.GroupPeopleItem;

public class MyPeopleEditActy extends Activity {

	private GridView gridView;
	private Button rightBN;
	private GroupPeopleBaseAdapter adapter;
	private int[] imageIds = new int[] {
			R.mipmap.head1, R.mipmap.head3, R.mipmap.head2,
			R.mipmap.head1, R.mipmap.head3, R.mipmap.head2,
			R.mipmap.head3, R.mipmap.head2, R.mipmap.head1,
			R.mipmap.head2, R.mipmap.head3, R.mipmap.head1,
			R.mipmap.head2, R.mipmap.head1, R.mipmap.head3,
			R.mipmap.head2 };
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
			groupPeopleItem.setName("����" + i);
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
				// ����༭״̬
				if (rightBN.getTag() == null) {
					rightBN.setTag("--");
					rightBN.setText("���");
					// ����༭״̬
					updateData(true);
					
				}
				// ���״̬
				else {
					rightBN.setTag(null);
					rightBN.setText("�༭");
					// ���״̬
					updateData(false);
					
				}
				
			}
		});
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// �Ӻ�
				if (position == adapter.getCount() - 1) {
					Toast.makeText(MyPeopleEditActy.this, "����˼Ӻ�", Toast.LENGTH_SHORT).show();
					return;
				}
				
				
				GroupPeopleItem item = (GroupPeopleItem)adapter.getItem(position);
				// ���״̬
				if (rightBN.getTag() == null) {
					Toast.makeText(MyPeopleEditActy.this, item.getName(), Toast.LENGTH_SHORT).show();
				}
				else{
					adapter.deletePeople(position);
//					peopleList.remove(position);
					// �������½���ķ���
					adapter.notifyDataSetChanged();
				}
				
			}
		});
		
	}
	
	
	private void updateData(boolean isEdit){
		
		List<GroupPeopleItem> allList = adapter.getPeopleList();
		GroupPeopleItem item;
		// ��������Դ�����ж����isEdit���������ԣ�
		for (int i = 0; i < allList.size(); i++) {
			item = allList.get(i);
//			// 0�Ǳ༭״̬��1�༭״̬
//			item.setIsEdit(isEdit? "1":"0");
			
			// 0�Ǳ༭״̬��1�༭״̬
			if (isEdit) {
				item.setIsEdit("1");
			}else{
				item.setIsEdit("0");
			}
			
		}
		// �������½���ķ���
		adapter.notifyDataSetChanged();
		
	}
	
	

}
