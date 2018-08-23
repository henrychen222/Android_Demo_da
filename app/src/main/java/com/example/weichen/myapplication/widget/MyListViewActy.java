package com.example.weichen.myapplication.widget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.weichen.myapplication.R;
import com.example.weichen.myapplication.adapter.ChatBaseAdapter;
import com.example.weichen.myapplication.adapter.PeopleBaseAdapter;
import com.example.weichen.myapplication.item.ChatItem;
import com.example.weichen.myapplication.item.PeopleItem;

public class MyListViewActy extends Activity {

	private ListView myListViewLV;
	private EditText msgET;
	private Button sendBN;
	private ChatBaseAdapter chatBaseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_list_view);
		
		initVar();
		
		findViews();
		
		bindViews();
		
	}

	private void initVar() {
		
	}

	private void findViews() {
		myListViewLV = (ListView)findViewById(R.id.alv_lv_list);
		msgET = (EditText)findViewById(R.id.alv_et_msg);
		sendBN = (Button)findViewById(R.id.alv_bn_send);
		sendBN.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ChatItem chatItem = new ChatItem();
				chatItem.setFromId("st_001");
				chatItem.setFromName("����");
				chatItem.setMsg(msgET.getText().toString());
				// ��������Ϣ���뵽�б������һ��
				chatBaseAdapter.addChatItem(chatItem);
				// �������½���ķ���
				chatBaseAdapter.notifyDataSetChanged();
				// �Զ��������ײ�
				myListViewLV.setSelection(chatBaseAdapter.getCount());

			}
		});
	}

	private void bindViews() {
		
		// ��һ��
//		String[] arrays = new String[]{"����","����","����"};
//		ArrayAdapter<String> arraysAdapter = new ArrayAdapter<String>(
//				MyListViewActy.this, 
//				android.R.layout.simple_list_item_1, 
//				arrays);
//		myListViewLV.setAdapter(arraysAdapter);
		
		// ������
//		List<String> strList = new ArrayList<String>();
//		for (int i = 0; i < 20; i++) {
//			strList.add("����" + i);
//		}
//		ArrayAdapter<String> strAdapter = new ArrayAdapter<String>(
//				MyListViewActy.this, 
//				android.R.layout.simple_list_item_1, 
//				strList);
//		myListViewLV.setAdapter(strAdapter);
		
		
		// ������
//		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
//		Map<String, Object> map;
//		for (int i = 0; i < 20; i++) {
//			map = new HashMap<String, Object>();
//			map.put("name", "����" + i);
//			map.put("phone", "1351511916" + i);
//			mapList.add(map);
//		}
//		SimpleAdapter simpleAdapter = new SimpleAdapter(
//				MyListViewActy.this, 
//				mapList, 
//				android.R.layout.simple_list_item_2, 
//				new String[]{
//						"name",
//						"phone"
//				}, 
//				new int[]{
//					android.R.id.text1,
//					android.R.id.text2
//				});
//		myListViewLV.setAdapter(simpleAdapter);
		
		
		// ���ģ�BaseAdapter Map<String, Object>�ɶ��Բ�����þ������
//		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
//		Map<String, Object> map;
//		for (int i = 0; i < 20; i++) {
//			map = new HashMap<String, Object>();
//			map.put("name", "����" + i);
//			map.put("phone", "1351511916" + i);
//			mapList.add(map);
//		}
//		MyBaseAdapter myBaseAdapter = new MyBaseAdapter(MyListViewActy.this, mapList);
//		myListViewLV.setAdapter(myBaseAdapter);
		
		String[] headArr = new String[]{
				"http://192.168.15.253/WS_SuweiWeibo/image/head1.jpg",
				"http://192.168.15.253/WS_SuweiWeibo/image/head2.jpg",
				"http://192.168.15.253/WS_SuweiWeibo/image/head3.jpg",
				"http://192.168.15.253/WS_SuweiWeibo/image/head4.jpg",
				"http://192.168.15.253/WS_SuweiWeibo/image/head5.jpg"
				};
		// �����Ż���
		List<PeopleItem> peopleList = new ArrayList<PeopleItem>();
		PeopleItem peopleItem;
		for (int i = 0; i < 20; i++) {
			peopleItem = new PeopleItem();
			peopleItem.setHeadUrl(headArr[i%5]);
			peopleItem.setName("����" + i);
			peopleItem.setPhone("1351511916" + i);
			peopleItem.setSex("0");
			peopleList.add(peopleItem);
		}
		PeopleBaseAdapter peopleBaseAdapter = new PeopleBaseAdapter(MyListViewActy.this, peopleList);
		// ��������
		myListViewLV.setAdapter(peopleBaseAdapter);
		
//		String[] ids = new String[]{
//				"st_002","st_001","st_002","st_001","st_001",
//				"st_002","st_001","st_002","st_001","st_001",
//				"st_002","st_001","st_002","st_001","st_001",
//				"st_001","st_001","st_002","st_001","st_002"};
//		
//		List<ChatItem> chatList = new ArrayList<ChatItem>();
//		String myId = "st_001";
//		ChatItem chatItem;
//		for (int i = 0; i<20; i++) {
//			chatItem = new ChatItem();
//			chatItem.setFromId(ids[i]);
//			if ("st_001".equals(ids[i])) {
//				chatItem.setFromName("����");
//				chatItem.setMsg("��ã�����������ã�����������ã�����������ã���������");
//			}else {
//				chatItem.setFromName("����");
//				chatItem.setMsg("��ã���֪������ã���֪������ã���֪������ã���֪������ã���֪����");
//			}
//			chatList.add(chatItem);
//		}
//		
//		chatBaseAdapter = new ChatBaseAdapter(this, chatList);
//		chatBaseAdapter.setMyId(myId);
//		
//		myListViewLV.setAdapter(chatBaseAdapter);
//		
//		myListViewLV.setOnItemClickListener(new OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				ChatItem chatItem = (ChatItem)chatBaseAdapter.getItem(position);
//				Log.i("","position--->" + position);
//				Log.i("","chatItem.getMsg--->" + chatItem.getMsg());
//				
//			}
//			
//		});
		
		
	}
	
	
	

}
