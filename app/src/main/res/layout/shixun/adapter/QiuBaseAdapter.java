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
import com.sutest.shixun.item.QiuItem;

public class QiuBaseAdapter extends BaseAdapter{
	private List<QiuItem> qiuList = new ArrayList<QiuItem>();
	private Context ctx;
	
	public QiuBaseAdapter(Context ctx, List<QiuItem> qiuList) {
		this.ctx = ctx;
		this.qiuList = qiuList;
	}

	@Override
	public int getCount() {
		return qiuList.size();
	}

	@Override
	public Object getItem(int position) {
		return qiuList.get(position);
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
			convertView.setTag(viewHolder);
		}
		
		QiuItem qiuItem = qiuList.get(position);
		viewHolder.qiuIV.setImageResource(qiuItem.getResId());
		viewHolder.nameTV.setText(qiuItem.getName());
		
		return convertView;
	}
	
	static class ViewHolder{
		ImageView qiuIV;
		TextView nameTV;
	}

}
