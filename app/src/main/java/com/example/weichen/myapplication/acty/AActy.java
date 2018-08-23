package com.example.weichen.myapplication.acty;

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
	/** ������,�ڹ㲥�������в�������ʱ���� */
	private BroadcastReceiver receiver = new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			// �޸����ֵĹ㲥
			if (ACTION_UPDATE_NAME.equals(action)) {
				String name = intent.getStringExtra("name");
				button.setText("�յ��㲥��nameΪ:" + name);
				Log.e("receive","�յ��㲥��nameΪ:" + name);
				
			}
			// �޸�����Ĺ㲥
			else if (ACTION_UPDATE_AGE.equals(action)) {
				int age = intent.getIntExtra("age", 0);
				button.setText("�յ��㲥��ageΪ:" + age);
				Log.e("receive","�յ��㲥��ageΪ:" + age);
			}
			
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		button = new Button(this);
		setContentView(button);
		
		mySPF = getSharedPreferences("mySPF", Activity.MODE_PRIVATE);
		
		button.setText("��ת��Bҳ��");
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(AActy.this, BActy.class);
				startActivity(intent);
				
			}
		});
		
		Log.i(TAG, "onCreate--------------->");
		
		
		// �㲥������
		IntentFilter filter = new IntentFilter();
		filter.addAction(ACTION_UPDATE_NAME);
		filter.addAction(ACTION_UPDATE_AGE);
		// ע�������
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
//		button.setText("��ת��Bҳ��,�÷�:" + fen);
		
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
		// ע������
		unregisterReceiver(receiver);
	}

	
	
}
