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
import com.sutest.shixun.item.ChatItem;
import com.sutest.shixun.item.ChatItem;

public class ChatBaseAdapter extends BaseAdapter {
	
	private List<ChatItem> chatList = new ArrayList<ChatItem>();
	private Context ctx;
	private String myId;
	

	public ChatBaseAdapter(Context ctx, List<ChatItem> peopleList) {
		this.chatList = peopleList;
//		this.chatList.addAll(peopleList);
		this.ctx = ctx;
	}
	
	public void addChatItem(ChatItem chatItem){
		// 把聊天消息加入到列表中最后一条
		this.chatList.add(chatItem);
	}

	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}



	@Override
	public int getCount() {
		return chatList.size();
	}

	@Override
	public Object getItem(int position) {
		return chatList.get(position);
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
			convertView = LayoutInflater.from(ctx).inflate(R.layout.item_chat, null);
			// 左侧
			viewHolder.leftView = convertView.findViewById(R.id.ic_rl_left);
			viewHolder.headIV = (ImageView)convertView.findViewById(R.id.ic_iv_head);
			viewHolder.nameTV = (TextView)convertView.findViewById(R.id.ic_tv_name);
			viewHolder.msgTV = (TextView)convertView.findViewById(R.id.ic_tv_msg);
			// 右侧
			viewHolder.rightView = convertView.findViewById(R.id.ic_rl_right);
			viewHolder.headIV2 = (ImageView)convertView.findViewById(R.id.ic_iv_head2);
			viewHolder.nameTV2 = (TextView)convertView.findViewById(R.id.ic_tv_name2);
			viewHolder.msgTV2 = (TextView)convertView.findViewById(R.id.ic_tv_msg2);
			convertView.setTag(viewHolder);
		}
		
		
		// 数据源绑定
		ChatItem chatItem = chatList.get(position);
		// 右侧绑定,我发送的消息
		if (myId != null && myId.equals(chatItem.getFromId())) {
			viewHolder.rightView.setVisibility(View.VISIBLE);
			viewHolder.leftView.setVisibility(View.GONE);
			
			viewHolder.nameTV2.setText(chatItem.getFromName());
			viewHolder.msgTV2.setText(chatItem.getMsg());
			
		}
		// 左侧绑定
		else {
			viewHolder.leftView.setVisibility(View.VISIBLE);
			viewHolder.rightView.setVisibility(View.GONE);
			
			viewHolder.nameTV.setText(chatItem.getFromName());
			viewHolder.msgTV.setText(chatItem.getMsg());
		}
		
		return convertView;
	}
	
	
	static class ViewHolder{
		View leftView;
		ImageView headIV;
		TextView nameTV;
		TextView msgTV;
		
		View rightView;
		ImageView headIV2;
		TextView nameTV2;
		TextView msgTV2;
	}

}
