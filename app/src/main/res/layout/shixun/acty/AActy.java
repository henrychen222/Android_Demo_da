package com.sutest.shixun.acty;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AActy extends Activity {
	private String TAG = "AActy";
	private SharedPreferences mySPF;
	private Button button;
	
	public static final String ACTION_UPDATE_NAME = "action_update_name";
	public static final String ACTION_UPDATE_AGE = "action_update_age";
	/** 接收器,在广播接收器中不能做耗时操作 */
	private BroadcastReceiver receiver = new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			// 修改名字的广播
			if (ACTION_UPDATE_NAME.equals(action)) {
				String name = intent.getStringExtra("name");
				button.setText("收到广播，name为:" + name);
				Log.e("receive","收到广播，name为:" + name);
				
			}
			// 修改年龄的广播
			else if (ACTION_UPDATE_AGE.equals(action)) {
				int age = intent.getIntExtra("age", 0);
				button.setText("收到广播，age为:" + age);
				Log.e("receive","收到广播，age为:" + age);
			}
			
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		button = new Button(this);
		setContentView(button);
		
		mySPF = getSharedPreferences("mySPF", Activity.MODE_PRIVATE);
		
		button.setText("跳转到B页面");
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(AActy.this, BActy.class);
				startActivity(intent);
				
			}
		});
		
		Log.i(TAG, "onCreate--------------->");
		
		
		// 广播过滤器
		IntentFilter filter = new IntentFilter();
		filter.addAction(ACTION_UPDATE_NAME);
		filter.addAction(ACTION_UPDATE_AGE);
		// 注册监听器
		registerReceiver(receiver, filter);
		
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart--------------->");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume--------------->");
//		int fen = mySPF.getInt("oneFen", 0);
//		button.setText("跳转到B页面,得分:" + fen);
		
	}
	
	
	

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause--------------->");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop--------------->");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy--------------->");
		// 注销监听
		unregisterReceiver(receiver);
	}

	
	
}
