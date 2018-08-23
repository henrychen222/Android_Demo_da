package com.example.weichen.myapplication.acty.listener;

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
			Log.i("master",name + "˯����----------->");
		}
	}
	public void wake(){
		if (house != null) {
			Log.i("master",name + "˯����----------->");
			house.goOutBedRoom();
		}
	}
	
	public void goToWork(){
		if (house != null) {
			house.openDoor(1);
			Log.i("master",name + "�߳�������----------->");
			house.closeDoor(1);
		}
	}
	
	
	public void backToHome(){
		if (house != null) {
			house.openDoor(0);
			Log.i("master",name + "�߽�������----------->");
			house.closeDoor(0);
		}
	}
	
	
	public void doCook(){
		if (house != null) {
			house.goCookRoom();
			Log.i("master", name + "������----------->");
		}
	}
	
	public void eat(String fan){
		Log.i("master", name + "��" + fan + "��----------->");
	}
	
	

}
