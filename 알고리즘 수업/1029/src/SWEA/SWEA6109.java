package SWEA;

import java.util.Scanner;

public class SWEA6109 {
	static int N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int dir;
	static int[][] map;
	static boolean[][] done;
	
	public static void move() {
		done = new boolean[N][N];
		int start_r;
		int start_c;
		if(dir == 0) {
			start_r = 1;
			start_c = 0;
			for(int i = 0; i < N; i++) {
				for(int j = start_r; j < N; j++) {
					int target = j - 1;
					while(true) {
						if(map[target][i] == 0 && target != 0) {
							target--;
						}else {
							break;
						}
					}
					if(map[target][i] == 0) {
						map[target][i] = map[j][i];
						map[j][i] = 0;
						continue;
					}
					if(done[target][i] && target+1 != j) {
						map[target+1][i] = map[j][i];
						map[j][i] = 0;
						continue;
					}else if(done[target][i] && target+1 == j) {
						continue;
					}
					
					if(map[target][i] == map[j][i] && map[target][i] != 0 && map[j][i] != 0) {
						map[target][i] *= 2;
						map[j][i] = 0;
						done[target][i] = true;
						continue;
					}
					if(map[target][i] != map[j][i] && map[target][i] != 0 && map[j][i] != 0 && target+1 != j) {
						map[target+1][i] = map[j][i];
						map[j][i] = 0;
						continue;
					}
					
				}
			}
		}else if(dir == 1) { // down
			start_r = N-2;
			start_c = 0;
			for(int i = 0; i < N; i++) {
				for(int j = start_r; j >= 0; j--) {
					int target = j + 1;
					while(true) {
						if(map[target][i] == 0 && target != N-1) {
							target++;
						}else {
							break;
						}
					}
					if(map[target][i] == 0) {
						map[target][i] = map[j][i];
						map[j][i] = 0;
						continue;
					}
					if(done[target][i] && target-1 != j) {
						map[target-1][i] = map[j][i];
						map[j][i] = 0;
						continue;
					}else if(done[target][i] && target-1 == j) {
						continue;
					}
					
					if(map[target][i] == map[j][i] && map[target][i] != 0 && map[j][i] != 0) {
						map[target][i] *= 2;
						map[j][i] = 0;
						done[target][i] = true;
						continue;
					}
					if(map[target][i] != map[j][i] && map[target][i] != 0 && map[j][i] != 0 && target-1 != j) {
						map[target-1][i] = map[j][i];
						map[j][i] = 0;
						continue;
					}
					
				}
			}
		}else if(dir == 2) { // left
			start_r = 0;
			start_c = 1;
			for(int i = 0; i < N; i++) {
				for(int j = start_c; j < N; j++) {
					int target = j - 1;
					while(true) {
						if(map[i][target] == 0 && target != 0) {
							target--;
						}else {
							break;
						}
					}
					if(map[i][target] == 0) {
						map[i][target] = map[i][j];
						map[i][j] = 0;
						continue;
					}
					if(done[i][target] && target+1 != j) {
						map[i][target+1] = map[i][j];
						map[i][j] = 0;
						continue;
					}else if(done[i][target] && target+1 == j) {
						continue;
					}
					
					if(map[i][target] == map[i][j] && map[i][target] != 0 && map[i][j] != 0) {
						map[i][target] *= 2;
						map[i][j] = 0;
						done[i][target] = true;
						continue;
					}
					if(map[i][target] != map[i][j] && map[i][target] != 0 && map[i][j] != 0 && target+1 != j) {
						map[i][target+1] = map[i][j];
						map[i][j] = 0;
						continue;
					}
					
				}
			}
		}else if(dir == 3) {
			start_r = 0;
			start_c = N-2;
			for(int i = 0; i < N; i++) {
				for(int j = start_c; j >= 0; j--) {
					int target = j + 1;
					while(true) {
						if(map[i][target] == 0 && target != N-1) {
							target++;
						}else {
							break;
						}
					}
					if(map[i][target] == 0) {
						map[i][target] = map[i][j];
						map[i][j] = 0;
						continue;
					}
					if(done[i][target] && target-1 != j) {
						map[i][target-1] = map[i][j];
						map[i][j] = 0;
						continue;
					}else if(done[i][target] && target-1 == j) {
						continue;
					}
					
					if(map[i][target] == map[i][j] && map[i][target] != 0 && map[i][j] != 0) {
						map[i][target] *= 2;
						map[i][j] = 0;
						done[i][target] = true;
						continue;
					}
					if(map[i][target] != map[i][j] && map[i][target] != 0 && map[i][j] != 0 && target-1 != j) {
						map[i][target-1] = map[i][j];
						map[i][j] = 0;
						continue;
					}
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t = 1; t <= T; t++) {
			String[] line = sc.nextLine().split(" ");
			dir = 0;
			N = Integer.parseInt(line[0]);
			if(line[1].equals("up")) dir = 0;
			else if(line[1].equals("down")) dir = 1;
			else if(line[1].equals("left")) dir = 2;
			else if(line[1].equals("right")) dir = 3;
			map = new int[N][N];

			for(int i = 0; i < N; i++) {
				line = sc.nextLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}
			move();
			System.out.println("#"+t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}
