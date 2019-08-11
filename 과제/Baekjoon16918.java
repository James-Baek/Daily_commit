package ssafy;
import java.util.*;

public class Baekjoon16918 {
//							╩С го аб ©Л
		static int[] dr = {-1,1,0,0,0};
		static int[] dc = {0,0,-1,1,0};
		
		static int[][] map;
		static boolean[][] b_map;
		static boolean[][] boundary;
		static int R;
		static int C;
		static int N;
		
		static void plustime() {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] >= 0) map[i][j]++;
				}
			}
		}
		
		static void setbobm() {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(b_map[i][j] == false) {
						b_map[i][j] = true;
						map[i][j] = 0;
					}
				}
			}
		}
		
		static void burst() {
			boundary = new boolean[R][C];
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					for(int k = 0; k < 5; k++) {
						if(i+dr[k] < 0 || i+dr[k] >= R || j+dc[k] < 0 || j+dc[k] >= C) {
							continue;
						}
						
						if(map[i][j] >= 3) {
							boundary[i+dr[k]][j+dc[k]] = true;
						}
					}
				}
			}
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(boundary[i][j] == true) {
						map[i][j] = -1;
						b_map[i][j] = false;
					}
				}
			}
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String[] input_num = sc.nextLine().split(" ");
			R = Integer.parseInt(input_num[0]);
			C = Integer.parseInt(input_num[1]);
			N = Integer.parseInt(input_num[2]);
			
			map = new int[R][C];
			b_map = new boolean[R][C];

			
			for(int i = 0; i < R; i++) {
				char[] temp_input = sc.nextLine().toCharArray();
				for(int j = 0; j < C; j++) {
					if(temp_input[j] == '.') {
						map[i][j] = -1;
					}else {
						map[i][j] = 1;
						b_map[i][j] = true;
					}
				}
			}
			
//			System.out.println(map);
			
			for(int time = 2; time <= N; time++) {
				plustime();
				setbobm();
				burst();
			}

			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] == -1) {
						System.out.print('.');
					}else {
						System.out.print('O');
					}
				}
				System.out.println();
			}
		}
}

