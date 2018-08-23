package com.sutest.shixun.acty.listener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sutest.shixun.R;
import com.sutest.shixun.acty.listener.HomeHouse.OnThiefListener;

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
		
		// 户主的房子
		HomeHouse house = new HomeHouse();
		house.setOnThiefListener(new OnThiefListener() {
			
			@Override
			public void onSleep() {
				Log.e("thief","主淫，那个二货他睡觉了---------->");
				showMsg("主淫，那个二货他睡觉了---------->");
			}
			
			@Override
			public void onOpenDoor(int kind) {
				// 下班回家
				if (kind == 0) {
					Log.e("thief","不好！主淫，那个二货开门回家了---------->");
					showMsg("不好！主淫，那个二货开门回家了---------->");
				}else{
					Log.e("thief","主淫，那个二货开门上班了---------->");
					showMsg("主淫，那个二货开门上班了---------->");
				}
			}
			
			@Override
			public void onCloseDoor(int kind) {
				Log.e("thief","主淫，那个二货关门了---------->");
				showMsg("主淫，那个二货关门了---------->");
			}
		});
		
		// 户主
		final Master master = new Master("张三", 23, "男");
		// 给户主设置家对象
		master.setHomeHouse(house);
		/*
		 *  用线程模拟一个用户的一天的生活，在这一天的生活中，
		 *  我们窃取他做事，并在合适的时间去偷东西
		 */
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				// 延时2秒
				waitTime(2000);
				
				// 上班了
				master.goToWork();
				// 上班8秒
				waitTime(8000);

				// 下班回家
				master.backToHome();
				// 回家用1秒
				waitTime(1000);

				master.doCook();
				// 做饭用2秒
				waitTime(2000);

				master.eat("晚饭");
				// 吃晚饭用2秒
				waitTime(2000);
				
				master.sleep();
				// 睡觉用8秒
				waitTime(8000);
				
				master.wake();
				// 睡醒用1秒
				waitTime(1000);
				
				master.doCook();
				// 做饭用2秒
				waitTime(2000);
				
				master.eat("早饭");
				// 吃饭用2秒
				waitTime(2000);
				
				master.goToWork();
				// 做饭用8秒
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
