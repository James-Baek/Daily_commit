package HW;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_1108_페이지전환_백창현 {
	static double[][] map;
	static ArrayList<Integer> start;
	static double sum;
	
	public static void find() {
		for(int temp : start) {
			for(int i = 1; i < map[temp].length; i++) {
				for(int j = 1; j < map[temp].length; j++) {
					if(map[i][temp] + map[temp][j] < map[i][j]) {
						map[i][j] = map[i][temp] + map[temp][j];
					}
				}
			}
		}
		for(int temp : start) {
			for(int i = 1; i < 500; i++) {
				sum+=map[temp][i];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		start = new ArrayList<Integer>();
		sum = 0;
		map = new double[500][500];
		for(int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			start.add(r);
			map[r][c] = 1;
		}
		find();
		System.out.println(sum/(start.size() * start.size() -1));
	}

}
