package com.ssafy.step1.permutation;

public class PermutationTest2 {

	// 1, 2, 3 세 수 중 3자리 순열
	// 3P3
	public static void main(String[] args) {
		for (int i = 1; i <= 3; ++i) {			//첫 번째 수
			for (int j = 1; j <= 3; ++j) {		//두 번째 수
				if(i != j) {
					System.out.println(i+" "+j);
				}
			}
		}
		
	}

}
