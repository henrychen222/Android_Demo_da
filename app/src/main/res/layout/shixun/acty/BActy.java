package com.sutest.shixun.acty;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BActy extends Activity {
	private String TAG = "BActy";
	private SharedPreferences mySPF;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Button button = new Button(this);
		setContentView(button);
		
		
		mySPF = getSharedPreferences("mySPF", Activity.MODE_PRIVATE);
		
		button.setText("返回A页面");
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				int fen = mySPF.getInt("oneFen", 0);
//				mySPF.edit()
//				.putInt("oneFen", (fen+10))
//				.commit();
//				
//				finish();
				
				if (v.getTag() == null) {
					// 发广播(修改名字的广播)
					Intent intent = new Intent(AActy.ACTION_UPDATE_NAME);
					intent.putExtra("name", "张三2");
					sendBroadcast(intent);
					
					v.setTag("name");
					
				}else {
					// 发广播(修改年龄的广播)
					Intent intent = new Intent(AActy.ACTION_UPDATE_AGE);
					intent.putExtra("age", 25);
					sendBroadcast(intent);
					
					v.setTag(null);
				}
				
				
				
			}
		});
		Log.e(TAG, "BActy--onCreate--------------->");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.e(TAG, "BActy--onStart--------------->");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG, "BActy--onResume--------------->");
	}
	

	@Override
	protected void onPause() {
		super.onPause();
		Log.e(TAG, "BActy--onPause--------------->");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e(TAG, "BActy--onStop--------------->");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e(TAG, "BActy--onDestroy--------------->");
	}

	
	
}
