package com.example.weichen.myapplication.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weichen.myapplication.R;
import com.example.weichen.myapplication.item.GroupPeopleItem;

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
		
		// ��ʾ�Ӻ�ͼƬ
		if (position == peopleList.size()) {
			viewHolder.qiuIV.setImageResource(R.mipmap.img_add);
			viewHolder.nameTV.setVisibility(View.GONE);
			viewHolder.closeIV.setVisibility(View.GONE);
			
		}else{
			viewHolder.nameTV.setVisibility(View.VISIBLE);
			
			GroupPeopleItem item = peopleList.get(position);
			viewHolder.qiuIV.setImageResource(item.getResId());
			viewHolder.nameTV.setText(item.getName());
			// 0�Ǳ༭״̬��1�༭״̬
			if ("0".equals(item.getIsEdit())) {
				viewHolder.closeIV.setVisibility(View.GONE);
			}
			// 1�༭״̬
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
