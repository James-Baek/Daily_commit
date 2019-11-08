package com.ssafy.step1.car;


public class Car {
	/**
	 * num : 차량번호
	 * model : 모델명
	 * price : 가격
	 */
	private String num;
	private String model;
	private int price;
	
	public Car() {}
	
	public Car(String num, String model, int price) {
		this.num = num;
		this.model = model;
		this.price = price;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "차량번호 : "+num+"\t모델명 : "+model+"\t가격 : "+price;
	}
	
}
