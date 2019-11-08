package com.ssafy.step1.car;

public class Truck extends Car {
	private int ton;
	
	public Truck() {}
	public Truck(String num, String model, int price, int ton) {
		super(num, model, price);
		this.ton = ton;
	}
	public int getTon() {
		return ton;
	}
	public void setTon(int ton) {
		this.ton = ton;
	}
	
	public String toString() {
		return super.toString()+"\t톤 : "+ton;
	}
}
