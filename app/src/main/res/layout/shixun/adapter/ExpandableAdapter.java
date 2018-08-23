package com.sutest.shixun.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.sutest.shixun.R;

public class ExpandableAdapter extends BaseExpandableListAdapter {
	private Context mCtx;
	
	private String[] groupArr = new String[]{"动物类","植物类","微生物类"};
	private String[][] childArr = new String[][]{
			{"熊猫","大狗","小猫","毛驴","兔子"},
			{"小草","大树","荷花","仙人掌"},
			{"细菌","真菌","病毒"}
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
		
		// 数据源绑定
		groupNameTV.setText(groupArr[groupPosition]);
		
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		TextView textView = new TextView(mCtx);
		textView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 80));
		// 左对齐且垂直居中
		textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		textView.setPadding(36, 0, 0, 0);
		textView.setTextSize(20);
		
		// 绑定数据源
		textView.setText(childArr[groupPosition][childPosition]);
		
		return textView;
	}

	
	
}
