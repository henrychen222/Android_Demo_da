package com.sutest.shixun.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sutest.shixun.R;

public class MyBaseAdapter extends BaseAdapter {
	
	private List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
	private Context mCtx;
	
	public MyBaseAdapter(Context mCtx, List<Map<String, Object>> list) {
		this.mCtx = mCtx;
		this.mapList = list;
	}

	/**
	 * 列表数据长度
	 */
	@Override
	public int getCount() {
		return mapList.size();
	}

	/**
	 * 获取单条数据对象
	 */
	@Override
	public Object getItem(int position) {
		return mapList.get(position);
	}

	/**
	 * 获取单条数据源的id，可以不实现
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 
	 */
	
	
	/**
	 * 没有利用重用机制
	 */
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		Log.i("","position--->" + position);
//		// 根据xml文件生成一个布局
//		View rootView = LayoutInflater.from(mCtx).inflate(R.layout.item_friend, null);
//		
//		TextView nameTV = (TextView)rootView.findViewById(R.id.if_tv_name);
//		TextView phoneTV = (TextView)rootView.findViewById(R.id.if_tv_phone);
//		
//	    // 获取数据源，绑定到布局
//		Map<String, Object> map = mapList.get(position);
//		nameTV.setText(map.get("name").toString());
//		phoneTV.setText(map.get("phone").toString());
//		
//		return rootView;
//	}
	
	/**
	 * 利用重用机制
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("","position--->" + position);
		// 视图管理类
		ViewHolder viewHolder;
		// 池中有可重用的布局
		if (convertView != null && convertView.getTag() != null) {
			// 取回视图管理对象
			viewHolder = (ViewHolder)convertView.getTag();
		}
		// 池中没有可以重用的布局
		else{
			// 根据xml文件生成一个布局
			convertView = LayoutInflater.from(mCtx).inflate(R.layout.item_friend, null);
			// 产生一个视图管理对象
			viewHolder = new ViewHolder();
			// 赋值多个控件子元素
			viewHolder.nameTV = (TextView)convertView.findViewById(R.id.if_tv_name);
			// 赋值多个控件子元素
			viewHolder.contetnTV = (TextView)convertView.findViewById(R.id.if_tv_phone);
			// 设置到tag，方便重用时取回来
			convertView.setTag(viewHolder);
		}
		// 偶数行
		if (position % 2 == 0) {
			convertView.setBackgroundResource(R.drawable.xml_weilist_item_even);
		}
		else{
			convertView.setBackgroundResource(R.drawable.xml_weilist_item_odd);
		}
		
		
		/*
		 * -------------------- 数据源和视图的绑定-------------
		 */
		// 获取单条数据源
		Map<String, Object> map = (Map<String, Object>)getItem(position);
//		// 获取单条数据源
//		Map<String, Object> map = mapList.get(position);
		String name = map.get("name").toString();
		viewHolder.nameTV.setText(name);
		if ("李四4".equals(name)) {
			viewHolder.nameTV.setTextColor(Color.BLUE);
		}else{
			viewHolder.nameTV.setTextColor(Color.parseColor("#ff00ff"));
		}
		viewHolder.contetnTV.setText(map.get("phone").toString());
		
		return convertView;
	}
	
	public static class ViewHolder{
		TextView nameTV;
		TextView contetnTV;
		
	}

}
