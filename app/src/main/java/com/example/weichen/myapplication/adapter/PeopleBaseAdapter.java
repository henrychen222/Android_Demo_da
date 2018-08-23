package com.example.weichen.myapplication.adapter;

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

import com.example.weichen.myapplication.R;
import com.example.weichen.myapplication.acty.listener.SyncImgLoader;
import com.example.weichen.myapplication.acty.listener.SyncImgLoader.OnloadImage;
import com.example.weichen.myapplication.item.PeopleItem;

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
		
		// ż����
		if (position % 2 == 0) {
			convertView.setBackgroundResource(R.drawable.xml_weilist_item_even);
		}
		else{
			convertView.setBackgroundResource(R.drawable.xml_weilist_item_odd);
		}
		
		// ����Դ��
		PeopleItem peopleItem = peopleList.get(position);
		viewHolder.nameTV.setText(peopleItem.getName());
		viewHolder.phoneTV.setText(peopleItem.getPhone());
		viewHolder.headIV.setImageResource(R.mipmap.public_img_default);
		
		// �첽��ͷ��Imageview��
		syncImgLoader.loadImage(peopleItem.getHeadUrl(), new OnloadImage() {
			
			@Override
			public void loadFinish(Bitmap bitmap) {
				viewHolder.headIV.setImageBitmap(bitmap);
			}
			
			@Override
			public void loadFail() {
				viewHolder.headIV.setImageResource(R.mipmap.public_img_default);
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
