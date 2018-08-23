package com.sutest.shixun.acty.listener;

import android.util.Log;

public class Master {
	private String name;
	private int age;
	private String sex;
	private HomeHouse house;
	
	
	public Master(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public void setHomeHouse(HomeHouse h){
		this.house = h;
	}
	
	
	public void sleep(){
		if (house != null) {
			house.goInBedRoom();
			Log.i("master",name + "睡觉了----------->");
		}
	}
	public void wake(){
		if (house != null) {
			Log.i("master",name + "睡醒了----------->");
			house.goOutBedRoom();
		}
	}
	
	public void goToWork(){
		if (house != null) {
			house.openDoor(1);
			Log.i("master",name + "走出房间了----------->");
			house.closeDoor(1);
		}
	}
	
	
	public void backToHome(){
		if (house != null) {
			house.openDoor(0);
			Log.i("master",name + "走进房间了----------->");
			house.closeDoor(0);
		}
	}
	
	
	public void doCook(){
		if (house != null) {
			house.goCookRoom();
			Log.i("master", name + "做饭了----------->");
		}
	}
	
	public void eat(String fan){
		Log.i("master", name + "吃" + fan + "了----------->");
	}
	
	

}
