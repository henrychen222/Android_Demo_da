package com.sutest.shixun.acty.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sutest.shixun.R;
import com.sutest.shixun.service.MyService;

/**
 * px:物理像素
 * dp:独立像素，适配像素  px = 密度 * dp
 * sp:仅仅用于字体
 * 
 * @author wwx220
 */
public class MusicListActy extends Activity {
	
	
	private MediaPlayer mediaPlayer;
	private ListView musicLV;
	private ArrayList<Map<String, Object>> musicList = new ArrayList<Map<String,Object>>();
	private SimpleAdapter simpleAdapter;
	private Button stopBN;
	private Button startBN;
	private Context mContext;
	private String clickMusicPath;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_music_list);
		
		mContext = this;
		
		startBN = (Button)findViewById(R.id.aml_bn_start);
		stopBN = (Button)findViewById(R.id.aml_bn_stop);
		musicLV = (ListView)findViewById(R.id.aml_lv_music);
		
		startBN.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 法一：
				//Intent intent = new Intent("com.xiaozhuang.music");
				// 法二：
				Intent intent = new Intent(mContext, MyService.class);
				// 启动service
				startService(intent);
				
			}
		});
		stopBN.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 法一：
				//Intent intent = new Intent("com.xiaozhuang.music");
				// 法二：
				Intent intent = new Intent(mContext, MyService.class);
				// 启动service
				stopService(intent);
			}
		});
		
		// 加权限 android.permission.READ_EXTERNAL_STORAGE
		File file = new File("/mnt/sdcard/Download/SuweiTest/music/");
		if (!file.exists()) {
			Toast.makeText(MusicListActy.this, "请检查目录/Download/SuweiTest/music/", Toast.LENGTH_LONG).show();
			return;
		}
		
		String name;
		String path;
		Map<String, Object> map;
		for (File f : file.listFiles()) {
			map = new HashMap<String, Object>();
			name = f.getName();
			path = f.getAbsolutePath();
			
			map.put("name", name);
			map.put("path", path);
			
			musicList.add(map);
		}
		
		simpleAdapter = new SimpleAdapter(
				MusicListActy.this, 
				musicList, 
				R.layout.item_contacts, 
				new String[]{
						"name",
						"path"
				}, 
				new int[]{
					R.id.ic_tv_name,
					R.id.ic_tv_phone
				});
		
		musicLV.setAdapter(simpleAdapter);
		
		
		
		musicLV.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Map<String, Object> map = (Map<String, Object>)simpleAdapter.getItem(position);
				
				Toast.makeText(MusicListActy.this, "name:" + map.get("name"), Toast.LENGTH_LONG).show();
				
				Intent intent = new Intent(MusicListActy.this, BindServerPlayMusicActy.class);
				// 数据源
				intent.putExtra("list", musicList);
				// 银锁值
				intent.putExtra("index", position);
				startActivity(intent);
				
				
//				clickMusicPath = map.get("path").toString();
//				Intent intent = new Intent(MyService.action_play);
//				intent.putExtra("path", clickMusicPath);
//				sendBroadcast(intent);
				
				
			}
			
		});
		
		
		findViewById(R.id.aml_bn_musicstart).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (TextUtils.isEmpty(clickMusicPath)) {
					Toast.makeText(mContext, "请选择歌曲", Toast.LENGTH_SHORT).show();
					return;
				}
				Intent intent = new Intent(MyService.action_play);
				intent.putExtra("path", clickMusicPath);
				sendBroadcast(intent);
			}
		});
		findViewById(R.id.aml_bn_musicpause).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MyService.action_pause);
				sendBroadcast(intent);
			}
		});
		findViewById(R.id.aml_bn_musicstop).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MyService.action_stop);
				sendBroadcast(intent);
				
			}
		});
		
		
	}
	
	
	
}
