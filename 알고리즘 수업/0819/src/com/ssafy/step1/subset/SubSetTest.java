package com.ssafy.step1.subset;

public class SubSetTest {

	public static void main(String[] args) {
		int[] numbers = {1,2,3};
		int N = numbers.length;
		int caseCount = 1<<N;
		for(int i = 0; i < caseCount; ++i) {
			for(int j = 0; j < N; ++j) {
				if((i & i<<j) != 0) {
					System.out.print(numbers[j]+" ");
				}
			}
			System.out.println();
		}
		
	}

}
