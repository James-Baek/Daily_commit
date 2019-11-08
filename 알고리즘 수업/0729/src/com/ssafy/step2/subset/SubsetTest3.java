package com.ssafy.step2.subset;

public class SubsetTest3 {
	static boolean[] selected;
	static int N = 5;
	static boolean isFind = false;
	
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
		if(isFind) return;
		if(index == N) {
			int sum = 0;
			boolean t = false;
			for (int s = 0; s < selected.length; s++) {
				int temp = selected[s] ? numbers[s] : 0;
				if(temp != 0) t = true;
				sum += temp;
			}
			if(sum == 0 && t == true) {
				isFind = true;
			}
			return;
		}
		selected[index] = true;
		subset(index+1, numbers);
		
		selected[index] = false;
		subset(index+1, numbers);
		
	}
	public static void main(String[] args) {
		int[] numbers = {-7,-3,-2,5,8};
		selected = new boolean[5];
		subset(0, numbers);
		if(isFind) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
	}

}
