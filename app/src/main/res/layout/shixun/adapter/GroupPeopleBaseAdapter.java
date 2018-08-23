package com.sutest.shixun.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sutest.shixun.R;
import com.sutest.shixun.item.GroupPeopleItem;

public class GroupPeopleBaseAdapter extends BaseAdapter{
	private List<GroupPeopleItem> peopleList = new ArrayList<GroupPeopleItem>();
	private Context ctx;
	
	public GroupPeopleBaseAdapter(Context ctx, List<GroupPeopleItem> qiuList) {
		this.ctx = ctx;
//		this.peopleList = qiuList;
		this.peopleList.addAll(qiuList);
	}
	
	
	

	public List<GroupPeopleItem> getPeopleList() {
		return peopleList;
	}
	
	public void deletePeople(int index){
		peopleList.remove(index);
	}


	@Override
	public int getCount() {
		return peopleList.size() + 1;
	}

	@Override
	public Object getItem(int position) {
		return peopleList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder viewHolder;
		if (convertView != null && convertView.getTag() != null) {
			viewHolder = (ViewHolder)convertView.getTag();
		}else {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(ctx).inflate(R.layout.item_qiu, null);
			viewHolder.qiuIV = (ImageView)convertView.findViewById(R.id.iq_iv_head);
			viewHolder.nameTV = (TextView)convertView.findViewById(R.id.iq_tv_name);
			viewHolder.closeIV = (ImageView)convertView.findViewById(R.id.iq_iv_close);
			convertView.setTag(viewHolder);
		}
		
		// ÏÔÊ¾¼ÓºÅÍ¼Æ¬
		if (position == peopleList.size()) {
			viewHolder.qiuIV.setImageResource(R.drawable.img_add);
			viewHolder.nameTV.setVisibility(View.GONE);
			viewHolder.closeIV.setVisibility(View.GONE);
			
		}else{
			viewHolder.nameTV.setVisibility(View.VISIBLE);
			
			GroupPeopleItem item = peopleList.get(position);
			viewHolder.qiuIV.setImageResource(item.getResId());
			viewHolder.nameTV.setText(item.getName());
			// 0·Ç±à¼­×´Ì¬£¬1±à¼­×´Ì¬
			if ("0".equals(item.getIsEdit())) {
				viewHolder.closeIV.setVisibility(View.GONE);
			}
			// 1±à¼­×´Ì¬
			else{
				viewHolder.closeIV.setVisibility(View.VISIBLE);
			}
		}
		
		return convertView;
	}
	
	static class ViewHolder{
		ImageView qiuIV;
		TextView nameTV;
		ImageView closeIV;
	}

}
