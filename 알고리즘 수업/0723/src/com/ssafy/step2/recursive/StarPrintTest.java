package com.ssafy.step2.recursive;

public class StarPrintTest {

	
	//정수 N 입력반도
	//N : 3
	// *
	// **
	// ***
	static void star(int n) {
		if(n == 0) return;
		star(n-1);
		for(int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		return;
	}
	public static void main(String[] args) {
		star(3);
	}

}
