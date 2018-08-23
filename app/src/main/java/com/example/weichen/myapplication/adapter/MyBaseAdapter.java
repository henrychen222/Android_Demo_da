package com.example.weichen.myapplication.adapter;

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

import com.example.weichen.myapplication.R;

public class MyBaseAdapter extends BaseAdapter {
	
	private List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
	private Context mCtx;
	
	public MyBaseAdapter(Context mCtx, List<Map<String, Object>> list) {
		this.mCtx = mCtx;
		this.mapList = list;
	}

	/**
	 * �б����ݳ���
	 */
	@Override
	public int getCount() {
		return mapList.size();
	}

	/**
	 * ��ȡ�������ݶ���
	 */
	@Override
	public Object getItem(int position) {
		return mapList.get(position);
	}

	/**
	 * ��ȡ��������Դ��id�����Բ�ʵ��
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 
	 */
	
	
	/**
	 * û���������û���
	 */
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		Log.i("","position--->" + position);
//		// ����xml�ļ�����һ������
//		View rootView = LayoutInflater.from(mCtx).inflate(R.layout.item_friend, null);
//		
//		TextView nameTV = (TextView)rootView.findViewById(R.id.if_tv_name);
//		TextView phoneTV = (TextView)rootView.findViewById(R.id.if_tv_phone);
//		
//	    // ��ȡ����Դ���󶨵�����
//		Map<String, Object> map = mapList.get(position);
//		nameTV.setText(map.get("name").toString());
//		phoneTV.setText(map.get("phone").toString());
//		
//		return rootView;
//	}
	
	/**
	 * �������û���
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("","position--->" + position);
		// ��ͼ������
		ViewHolder viewHolder;
		// �����п����õĲ���
		if (convertView != null && convertView.getTag() != null) {
			// ȡ����ͼ�������
			viewHolder = (ViewHolder)convertView.getTag();
		}
		// ����û�п������õĲ���
		else{
			// ����xml�ļ�����һ������
			convertView = LayoutInflater.from(mCtx).inflate(R.layout.item_friend, null);
			// ����һ����ͼ�������
			viewHolder = new ViewHolder();
			// ��ֵ����ؼ���Ԫ��
			viewHolder.nameTV = (TextView)convertView.findViewById(R.id.if_tv_name);
			// ��ֵ����ؼ���Ԫ��
			viewHolder.contetnTV = (TextView)convertView.findViewById(R.id.if_tv_phone);
			// ���õ�tag����������ʱȡ����
			convertView.setTag(viewHolder);
		}
		// ż����
		if (position % 2 == 0) {
			convertView.setBackgroundResource(R.drawable.xml_weilist_item_even);
		}
		else{
			convertView.setBackgroundResource(R.drawable.xml_weilist_item_odd);
		}
		
		
		/*
		 * -------------------- ����Դ����ͼ�İ�-------------
		 */
		// ��ȡ��������Դ
		Map<String, Object> map = (Map<String, Object>)getItem(position);
//		// ��ȡ��������Դ
//		Map<String, Object> map = mapList.get(position);
		String name = map.get("name").toString();
		viewHolder.nameTV.setText(name);
		if ("����4".equals(name)) {
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
