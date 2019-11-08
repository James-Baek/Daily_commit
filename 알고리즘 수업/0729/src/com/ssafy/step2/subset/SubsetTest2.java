package com.ssafy.step2.subset;

public class SubsetTest2 {
	static int[] numbers;
	static boolean[] selected;
	static int N = 3;
	
	public static void print() {
		for(int i = 0; i < 3; i++) {
			if(selected[i] == true) {
				System.out.print(i+1+"\t");
			}else {
				System.out.print("X\t");
			}
		}
		System.out.println();
	}
	
	
	public static void subset(int index) {
		if(index == N) {
			for (int s = 0; s < selected.length; s++) {
				System.out.print((selected[s] ? numbers[s] : "X")+"\t");
			}
			System.out.println();
			return;
		}
		selected[index] = true;
		subset(index+1);
		
		selected[index] = false;
		subset(index+1);
		
	}
	public static void main(String[] args) {
		numbers = new int[3];
		selected = new boolean[3];
		subset(0);
		
	}

}
