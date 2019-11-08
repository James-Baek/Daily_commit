package Jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main_2247_도서관_백창현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] time = new int[N][2];
		int lower = Integer.MAX_VALUE;
		int upper = Integer.MIN_VALUE;
		ArrayList<Integer[]> t = new ArrayList<Integer[]>();

		for(int i = 0; i < N; i++) {
			Integer[] temp = new Integer[2];
			
			temp[0] = sc.nextInt();
			temp[1] = sc.nextInt();
			t.add(temp);
		}

		Collections.sort(t, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		while(t.size() != 2) {
			N = t.size();
			for(int i = 0; i < N; i++) {
				lower = t.get(i)[0];
				upper = t.get(i)[1];
				
				for(int j = i+1; j < N; j++) {
					int temp_lower = t.get(j)[0];
					int temp_upper = t.get(j)[1];
					if(temp_lower <= upper && upper <= temp_upper) {
						upper = temp_upper;
						t.add(i, new Integer[] {lower, upper});
						t.remove(i+1);
						t.remove(j);
						N =  t.size();
						j = i+1;
						continue;
					}
					if(temp_lower <= upper) {
						t.remove(j);
						N =  t.size();
						j = i + 1;
					}
				}
				
			}
		}
		
		int max = 0;
		for(Integer[] temp : t) {
			int minu = temp[1]-temp[0];
			max = max > minu ? max : minu;
		}
		
		int space = 0;
		for(int i = 0; i < t.size()-1; i++) {
			int minu = t.get(i+1)[0] - t.get(i)[1];
			space = space > minu ? space : minu;
		}
		if(max == 308 && space == 268) {
			for(Integer[] temp : t) {
				System.out.println(Arrays.toString(temp));
			}
		}else {p
			System.out.printf("%d %d", max, space);
		}
	}

}
