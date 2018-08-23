package com.example.weichen.myapplication.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.weichen.myapplication.item.ImageItem;


public class ImageBaseAdapter extends BaseAdapter {
	
	private Context mCtx;
	private List<ImageItem> imageList = new ArrayList<ImageItem>();
	

	public ImageBaseAdapter(Context mCtx, List<ImageItem> imageList) {
		this.mCtx = mCtx;
		this.imageList = imageList;
	}

	@Override
	public int getCount() {
		return imageList.size();
	}

	@Override
	public Object getItem(int position) {
		return imageList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView iv;
		if (convertView != null) {
			iv = (ImageView)convertView;
		}else{
			iv = new ImageView(mCtx);
			iv.setLayoutParams(new Gallery.LayoutParams(250, 250));
			iv.setScaleType(ScaleType.FIT_XY);
		}
		
		// ����Դ��
		ImageItem imageItem = imageList.get(position);
		// ������
		iv.setImageResource(imageItem.getResId());
		
		return iv;
	}

}
