package com.ssafy.model.dto;

public class WrapperTest {

	public static void main(String[] args) {
		Integer iPrice = new Integer(5000);
		int price = iPrice.intValue();
		
		//java5부터
		Double IPI = 3.14;		//auto boxing
		double pi = IPI;		//auto unboxing
		
		Object inum = 256;
		
		/**
		 * 문자열 데이터를 해당 format의 Primitive
		 * parseXXX(String 값)
		 * - 잘못된 format으로 변경하면 NumberFormatException발생
		 * 
		 */
		price = Integer.parseInt("5000");
		double rate = Double.parseDouble("0.1");
		System.out.println(price + rate);
		
	}

}
