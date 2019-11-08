package IM;

import java.util.Scanner;

import javax.sound.midi.MetaEventListener;

public class Main1127ver2 {
	static boolean[] isSelected;
	static int[][] materials;
	static int SIZE = 0;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SIZE = sc.nextInt();
		materials = new int[SIZE][SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			materials[i][0] = sc.nextInt();
			materials[i][1] = sc.nextInt();
		}
		makeFood(0);
		System.out.println(MIN);
	}
	
	// index에 해당하는 재료의 조합을 고려하여 음식을 만들 수 있도록 한다.
	private static void makeFood(int index) {
		if(index == SIZE) {
			//선택된 재료들을 이용하여 신맛, 쓴맛지수 계산
			int sSum = 1, bSum = 0, cnt = 0;
			for(int i = 0; i<SIZE; ++i) {
				if(!isSelected[i]) continue; // i재료가 선택되지 않았다면 다음재료로.
				cnt++;
				sSum *= materials[i][0];
				bSum += materials[i][1];
			}
			if(cnt>0) {
				int temp = Math.abs(sSum - bSum);
				if(temp < MIN) MIN = temp;
			}
			return;
		}
		
		isSelected[index] = true;
		makeFood(index+1);
		isSelected[index] = false;
		makeFood(index+1);
	}
}
