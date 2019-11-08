package com.ssafy.step1.bit;

import java.util.Scanner;

public class BitOct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();

		for(int i = 0; i < temp.length(); i+=7) {	
			System.out.println(Integer.parseInt(temp.substring(i, i+7),2));
		}
	}

}
