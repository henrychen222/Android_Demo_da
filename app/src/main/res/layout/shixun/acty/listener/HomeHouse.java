package com.sutest.shixun.acty.listener;

import android.util.Log;

public class HomeHouse {
	
	/**
	 * 做饭
	 */
	public void goCookRoom(){
		Log.i("room", "走进厨房了----------->");
	}
	
	public void goInBedRoom(){
		Log.i("room", "走进卧室了----------->");
		if (onThiefListener != null) {
			onThiefListener.onSleep();
		}
	}
	
	public void goOutBedRoom(){
		Log.i("room", "走出卧室了----------->");
	}
	
	/** kind为0下班回家；1为出门上班*/
	public void openDoor(int kind){
		Log.i("room", "门打开了----------->");
		if (onThiefListener != null) {
			onThiefListener.onOpenDoor(kind);
		}
	}
	
	/** kind为0下班回家；1为出门上班*/
	public void closeDoor(int kind){
		Log.i("room", "门关闭了----------->");
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
		
		/** kind为0下班回家；1为出门上班*/
		void onOpenDoor(int kind);
		
		/** kind为0下班回家；1为出门上班*/
		void onCloseDoor(int kind);
		
		void onSleep();
		
		
	}
	
	
	
	
	
	

}
