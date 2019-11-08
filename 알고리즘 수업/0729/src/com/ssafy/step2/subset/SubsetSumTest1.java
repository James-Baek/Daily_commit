package com.ssafy.step2.subset;

public class SubsetSumTest1 {
	static boolean[] selected;
	static int N = 5;
	static boolean isFind = false;
	static int cnt = 0;
	public static void print() {
		for(int i = 0; i < 5; i++) {
			if(selected[i] == true) {
				System.out.print(i+1+"\t");
			}else {
				System.out.print("X\t");
			}
		}
		System.out.println();
	}
	
	
	public static void subset(int index, int[] numbers) {
		if(index == N) {
			int sum = 0;
			for (int s = 0; s < selected.length; s++) {
				int temp = selected[s] ? numbers[s] : 0;
				sum += temp;
			}
			if(sum == 21) {
				isFind = true;
				cnt++;
			}
			return;
		}
		selected[index] = true;
		subset(index+1, numbers);
		
		selected[index] = false;
		subset(index+1, numbers);
		
	}
	public static void main(String[] args) {
		int[] numbers = {5,6,10,11,16};
		selected = new boolean[5];
		subset(0, numbers);
		if(isFind) {
			System.out.println("True");
			System.out.println(cnt);
		}else {
			System.out.println("False");
		}
	}

}
