package com.sutest.shixun.acty.service;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;

import com.sutest.shixun.R;
import com.sutest.shixun.service.MyService;
import com.sutest.shixun.service.MyService.MyBind;

public class BindServerPlayMusicActy extends Activity implements OnClickListener{
	private Context mContext;
	private MyService myService;
	private ArrayList<Map<String, Object>> musicList;
	
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder iBinder) {
			MyBind myBind = (MyBind)iBinder;
			myService = myBind.getMyservice();
			
			
			Map<String, Object> map = musicList.get(index);
			// 播放音乐
			myService.playMusic(map.get("path").toString());
			
		}
	};
	private int index;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_bind_service_music);
		
		initVar();
		
		findViews();
		
		bindViews();
		
		setOnListener();
		
		// 法一：
		//Intent intent = new Intent("com.xiaozhuang.music");
		// 法二：
		Intent intent = new Intent(mContext, MyService.class);
		// 绑定service
		bindService(intent, conn, Service.BIND_AUTO_CREATE);
	}

	
	
	
	private void setOnListener() {
		findViewById(R.id.adi_bn_play).setOnClickListener(this);
		findViewById(R.id.adi_bn_pause).setOnClickListener(this);
		findViewById(R.id.adi_bn_stop).setOnClickListener(this);
		
	}




	private void initVar() {
		mContext = this;
		
		musicList = (ArrayList<Map<String, Object>>)getIntent().getSerializableExtra("list");
		index = getIntent().getIntExtra("index", 0);
	}




	private void findViews() {
		
	}




	private void bindViews() {
		
	}




	@Override
	protected void onDestroy() {
		// 解除绑定
		unbindService(conn);
		super.onDestroy();
	}




	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.adi_bn_play:
			if (myService == null) {
				return;
			}
			Map<String, Object> map = musicList.get(index);
			// 播放音乐
			myService.playMusic(map.get("path").toString());
			break;
		case R.id.adi_bn_pause:
			if (myService == null) {
				return;
			}
			myService.pauseMusic();
			break;
		case R.id.adi_bn_stop:
			if (myService == null) {
				return;
			}
			myService.stopMusic();
			break;

		default:
			break;
		}
		
	}
	
	

}
