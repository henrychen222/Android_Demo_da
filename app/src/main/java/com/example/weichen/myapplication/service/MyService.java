package com.example.weichen.myapplication.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

import com.example.weichen.myapplication.R;

public class MyService extends Service {

	private MediaPlayer mediaPlayer;
	public static final String action_play = "action_play";
	public static final String action_pause = "action_pause";
	public static final String action_stop = "action_stop";
	
	private BroadcastReceiver receiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action_play.equals(action)) {
				String path  = intent.getStringExtra("path");
				playMusic(path);
			}
			
			else if (action_pause.equals(action)) {
				pauseMusic();
			}
			
			else if (action_stop.equals(action)) {
				stopMusic();
			}
			
		}
	};
	
	public class MyBind extends Binder{
		
		public MyService getMyservice(){
			return MyService.this;
		}
	}
	

	@Override
	public IBinder onBind(Intent intent) {
		return new MyBind();
	}

	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Log.e("", "onStart----------------------->");
	}


	@Override
	public void onCreate() {
		super.onCreate();
		Log.e("", "onCreate----------------------->");
		
		mediaPlayer = MediaPlayer.create(this, R.raw.yueliang2);
		mediaPlayer.setLooping(true);
		
		playMusic();
		
		IntentFilter filter = new IntentFilter();
		filter.addAction(action_play);
		filter.addAction(action_stop);
		filter.addAction(action_pause);
		// ע��㲥
		registerReceiver(receiver, filter);
		
	}

	@Override
	public void onDestroy() {
		Log.e("", "onDestroy----------------------->");
		if (!isStop) {
			mediaPlayer.stop();
		}
		mediaPlayer.release();
		
		// ע���㲥
		unregisterReceiver(receiver);
		super.onDestroy();
	}
	
	
	
	
	public void playMusic(){
		try {
			if(isStop){
				mediaPlayer.prepare();
				isStop = false;
			}
			mediaPlayer.start();
		} catch (Exception e) {
			Log.e("", "---->" + e);
		}
	}
	
	/**
	 * ���ű�������
	 * @param path �������־���·��
	 */
	public void playMusic(String path){
		if(TextUtils.isEmpty(path)){
			return;
		}
		try {
			mediaPlayer.reset();
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (Exception e) {
			Log.e("", "---->" + e);
		}
	}
	
	public void pauseMusic(){
		mediaPlayer.pause();
	}
	
	/**
	 * ֹͣ���ţ����һص������ղ���λ��
	 */
	public void stopMusic(){
		if (isStop) {
			return;
		}
		
		mediaPlayer.seekTo(0);
		mediaPlayer.stop();
		isStop = true;
	}
	
	private boolean isStop = false;
	
	public boolean isStop(){
		return isStop;
	}
	
	public void seekTo(int seekTo){
		mediaPlayer.seekTo(seekTo);
	}
	
	public int getDuration(){
		return mediaPlayer.getDuration();
	}
	
	public int getCurrentPosition(){
		return mediaPlayer.getCurrentPosition();
	}
	

}
