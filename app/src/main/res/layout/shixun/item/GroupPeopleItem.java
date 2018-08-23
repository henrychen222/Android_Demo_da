package com.sutest.shixun.item;

public class GroupPeopleItem {
	
	private int resId;
	private String name;
	/** 0·Ç±à¼­×´Ì¬£¬1±à¼­×´Ì¬*/
	private String isEdit = "0";
	
	
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/** 0·Ç±à¼­×´Ì¬£¬1±à¼­×´Ì¬*/
	public String getIsEdit() {
		return isEdit;
	}
	
	/** 0·Ç±à¼­×´Ì¬£¬1±à¼­×´Ì¬*/
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	
	

}
