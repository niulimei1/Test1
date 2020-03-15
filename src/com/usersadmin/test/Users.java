package com.usersadmin.test;

public class Users {
	private String name;// 姓名
	private String number;// 电话号码
	private String position;// 职位
	private String xueyuan;// 学院
	private String province;// 当前所在省
	private String status;// 是否有疑似症状
	private String isolation;// 是否处于隔离期
	private String date;// 填报时间（3.12）

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getXueyuan() {
		return xueyuan;
	}

	public void setXueyuan(String xueyuan) {
		this.xueyuan = xueyuan;
	}

	/*
	 * public String getBanji() { return banji; } public void setBanji(String
	 * banji) { this.banji = banji; }
	 */
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsolation() {
		return isolation;
	}

	public void setIsolation(String isolation) {
		this.isolation = isolation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
