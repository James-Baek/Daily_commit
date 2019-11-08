import java.util.*;

public class Solution_D3_1208_Flatten_백창현 {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = 10;
			for(int testCase = 1; testCase <= T; testCase++) {
				int time = sc.nextInt();
				int[] box = new int[100];
				int sub = 0;
				
				for(int i = 0; i < 100; i++) {
					box[i] = sc.nextInt();
				}

				for(int j = 0; j < time; j++) {
					Arrays.sort(box);
					box[0]++;
					box[99]--;
				}
				Arrays.sort(box);
				
				sub = Math.abs(box[99] - box[0]);
				System.out.printf("#%d %d\n", testCase, sub);
			}
		}

}

