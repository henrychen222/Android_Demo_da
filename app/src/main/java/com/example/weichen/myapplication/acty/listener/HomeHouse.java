package com.example.weichen.myapplication.acty.listener;

import android.util.Log;

public class HomeHouse {
	
	/**
	 * ����
	 */
	public void goCookRoom(){
		Log.i("room", "�߽�������----------->");
	}
	
	public void goInBedRoom(){
		Log.i("room", "�߽�������----------->");
		if (onThiefListener != null) {
			onThiefListener.onSleep();
		}
	}
	
	public void goOutBedRoom(){
		Log.i("room", "�߳�������----------->");
	}
	
	/** kindΪ0�°�ؼң�1Ϊ�����ϰ�*/
	public void openDoor(int kind){
		Log.i("room", "�Ŵ���----------->");
		if (onThiefListener != null) {
			onThiefListener.onOpenDoor(kind);
		}
	}
	
	/** kindΪ0�°�ؼң�1Ϊ�����ϰ�*/
	public void closeDoor(int kind){
		Log.i("room", "�Źر���----------->");
		if (onThiefListener != null) {
			onThiefListener.onCloseDoor(kind);
		}
	}
	
	
	
	
	
	private OnThiefListener onThiefListener;
	
	public OnThiefListener getOnThiefListener() {
		return onThiefListener;
	}

	public void setOnThiefListener(OnThiefListener onThiefListener) {
		this.onThiefListener = onThiefListener;
	}

	public interface OnThiefListener{
		
		/** kindΪ0�°�ؼң�1Ϊ�����ϰ�*/
		void onOpenDoor(int kind);
		
		/** kindΪ0�°�ؼң�1Ϊ�����ϰ�*/
		void onCloseDoor(int kind);
		
		void onSleep();
		
		
	}
	
	
	
	
	
	

}
