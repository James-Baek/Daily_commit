package com.ssafy.step1.car;

public class Bus extends Car {
	private int seat;
	
	public Bus() {}
	public Bus(String num, String model, int price, int seat) {
		super(num, model, price);
		this.seat = seat;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public String toString() {
		return super.toString()+"\t좌석수 : "+seat;
	}
}
