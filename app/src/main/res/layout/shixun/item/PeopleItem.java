package com.sutest.shixun.item;

public class PeopleItem {
	
	private String id;
	
	private String headUrl;
	
	private String name;
	
	private String phone;
	
	private int age;
	
	private String sex;
	
//	public PeopleItem(String name) {
//		this.name = name;
//	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 0ÄÐ£»1Å®£»
	 * @param sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 0ÄÐ£»1Å®£»
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	
	

}
