import java.util.Scanner;

public class Solution5648 {
	static int N;
	static int[][] atom;
	static int[] crushed;
	static int power;
	public static void fire() {
		for(int dist = 1; dist < 1001; dist++) {
			for(int i = 0; i < N; i++) {
				if(crushed[i] != 0) continue;
				for(int j = 0; j < N; j++) {
					if(crushed[j] != 0) continue;
					// 상(0) y좌표 상승, 하(1) y좌표 하락, 좌(2) x좌표 하락, 우(3) x좌표 상승
					int base_x = atom[i][0];
					int base_y = atom[i][1];
					int base_dir = atom[i][2];
					int target_x = atom[j][0];
					int target_y = atom[j][1];
					int target_dir = atom[j][2];
					
					switch(base_dir) {
					case 0:
						if(target_dir == 3 && target_x < base_x && target_x + dist == base_y + dist) {
							
						}else if(target_dir == 2 && target_x < base_x && target_x + dist == base_y + dist) {
							
						}else if(target_dir == 1) {
							
						}
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			atom = new int[N][4];
			crushed = new int[N];
			power = 0;
			for(int i = 0; i < N; i++) {
				atom[i][0] = sc.nextInt();
				atom[i][1] = sc.nextInt();
				atom[i][2] = sc.nextInt();
				atom[i][3] = sc.nextInt();
			}
			
			
			System.out.printf("#%d %d\n", t, 0);
		}
		
	}

}
