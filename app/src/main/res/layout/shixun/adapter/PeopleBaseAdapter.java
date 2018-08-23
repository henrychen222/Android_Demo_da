package com.sutest.shixun.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sutest.shixun.R;
import com.sutest.shixun.acty.listener.SyncImgLoader;
import com.sutest.shixun.acty.listener.SyncImgLoader.OnloadImage;
import com.sutest.shixun.item.PeopleItem;

public class PeopleBaseAdapter extends BaseAdapter {
	
	private List<PeopleItem> peopleList = new ArrayList<PeopleItem>();
	private Context ctx;
	private SyncImgLoader syncImgLoader;
	

	public PeopleBaseAdapter(Context ctx, List<PeopleItem> peopleList) {
		this.peopleList = peopleList;
		this.ctx = ctx;
		syncImgLoader = new SyncImgLoader();
	}
	
	public void setPeopleList(List<PeopleItem> peopleList){
		this.peopleList = peopleList;
	}

	@Override
	public int getCount() {
		return peopleList.size();
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
		final ViewHolder viewHolder;
		if (convertView != null && convertView.getTag() != null) {
			viewHolder = (ViewHolder)convertView.getTag();
		}else {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(ctx).inflate(R.layout.item_people, null);
			viewHolder.headIV = (ImageView)convertView.findViewById(R.id.ip_iv_head);
			viewHolder.nameTV = (TextView)convertView.findViewById(R.id.ip_tv_name);
			viewHolder.phoneTV = (TextView)convertView.findViewById(R.id.ip_tv_phone);
			convertView.setTag(viewHolder);
		}
		
		// 偶数行
		if (position % 2 == 0) {
			convertView.setBackgroundResource(R.drawable.xml_weilist_item_even);
		}
		else{
			convertView.setBackgroundResource(R.drawable.xml_weilist_item_odd);
		}
		
		// 数据源绑定
		PeopleItem peopleItem = peopleList.get(position);
		viewHolder.nameTV.setText(peopleItem.getName());
		viewHolder.phoneTV.setText(peopleItem.getPhone());
		viewHolder.headIV.setImageResource(R.drawable.public_img_default);
		
		// 异步绑定头像（Imageview）
		syncImgLoader.loadImage(peopleItem.getHeadUrl(), new OnloadImage() {
			
			@Override
			public void loadFinish(Bitmap bitmap) {
				viewHolder.headIV.setImageBitmap(bitmap);
			}
			
			@Override
			public void loadFail() {
				viewHolder.headIV.setImageResource(R.drawable.public_img_default);
			}
		});
		
		
		return convertView;
	}
	
	
	static class ViewHolder{
		ImageView headIV;
		TextView nameTV;
		TextView phoneTV;
	}

}
