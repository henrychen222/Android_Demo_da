package com.example.weichen.myapplication.acty.listener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.weichen.myapplication.R;
import com.example.weichen.myapplication.acty.listener.HomeHouse.OnThiefListener;

/**
 * 
 * @author wwx220
 */
public class ThiefActy extends Activity {
	private TextView msgTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_thief);

		
		msgTV = (TextView)findViewById(R.id.at_tv_msg);
		
		// �����ķ���
		HomeHouse house = new HomeHouse();
		house.setOnThiefListener(new OnThiefListener() {
			
			@Override
			public void onSleep() {
				Log.e("thief","�������Ǹ�������˯����---------->");
				showMsg("�������Ǹ�������˯����---------->");
			}
			
			@Override
			public void onOpenDoor(int kind) {
				// �°�ؼ�
				if (kind == 0) {
					Log.e("thief","���ã��������Ǹ��������Żؼ���---------->");
					showMsg("���ã��������Ǹ��������Żؼ���---------->");
				}else{
					Log.e("thief","�������Ǹ����������ϰ���---------->");
					showMsg("�������Ǹ����������ϰ���---------->");
				}
			}
			
			@Override
			public void onCloseDoor(int kind) {
				Log.e("thief","�������Ǹ�����������---------->");
				showMsg("�������Ǹ�����������---------->");
			}
		});
		
		// ����
		final Master master = new Master("����", 23, "��");
		// ���������üҶ���
		master.setHomeHouse(house);
		/*
		 *  ���߳�ģ��һ���û���һ����������һ��������У�
		 *  ������ȡ�����£����ں��ʵ�ʱ��ȥ͵����
		 */
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				// ��ʱ2��
				waitTime(2000);
				
				// �ϰ���
				master.goToWork();
				// �ϰ�8��
				waitTime(8000);

				// �°�ؼ�
				master.backToHome();
				// �ؼ���1��
				waitTime(1000);

				master.doCook();
				// ������2��
				waitTime(2000);

				master.eat("��");
				// ������2��
				waitTime(2000);
				
				master.sleep();
				// ˯����8��
				waitTime(8000);
				
				master.wake();
				// ˯����1��
				waitTime(1000);
				
				master.doCook();
				// ������2��
				waitTime(2000);
				
				master.eat("�緹");
				// �Է���2��
				waitTime(2000);
				
				master.goToWork();
				// ������8��
				waitTime(8000);
			}
		}).start();
		
		

	}
	
	private void waitTime(int time){
		try {
			Thread.sleep(time);
		} catch (Exception e) {
		}
		
	}
	
	
	private void showMsg(final String msg){
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				String old = msgTV.getText().toString();
				if (old.length() > 0) {
					old = old + "\n";
				}
				msgTV.setText(old + msg);
				
			}
		});
		
	}

}
