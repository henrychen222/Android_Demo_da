package com.example.weichen.myapplication.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.weichen.myapplication.R;

public class ExpandableAdapter extends BaseExpandableListAdapter {
	private Context mCtx;
	
	private String[] groupArr = new String[]{"������","ֲ����","΢������"};
	private String[][] childArr = new String[][]{
			{"��è","��","Сè","ë¿","����"},
			{"С��","����","�ɻ�","������"},
			{"ϸ��","���","����"}
	};
	
	public ExpandableAdapter(Context ctx) {
		this.mCtx = ctx;
	}
	
	

	public String[] getGroupArr() {
		return groupArr;
	}


	public void setGroupArr(String[] groupArr) {
		this.groupArr = groupArr;
	}

	public String[][] getChildArr() {
		return childArr;
	}



	public void setChildArr(String[][] childArr) {
		this.childArr = childArr;
	}



	@Override
	public int getGroupCount() {
		return groupArr.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return childArr[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groupArr[groupPosition];
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return childArr[groupPosition][childPosition];
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}
	
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		
		TextView groupNameTV;
		if (convertView != null && convertView.getTag() != null) {
			groupNameTV = (TextView)convertView.getTag();
		}else{
			convertView = LayoutInflater.from(mCtx).inflate(R.layout.item_group, null);
			groupNameTV = (TextView)convertView.findViewById(R.id.ig_tv_name);
			convertView.setTag(groupNameTV);
		}
		
		// ����Դ��
		groupNameTV.setText(groupArr[groupPosition]);
		
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		TextView textView = new TextView(mCtx);
		textView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 80));
		// ������Ҵ�ֱ����
		textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		textView.setPadding(36, 0, 0, 0);
		textView.setTextSize(20);
		
		// ������Դ
		textView.setText(childArr[groupPosition][childPosition]);
		
		return textView;
	}

	
	
}
