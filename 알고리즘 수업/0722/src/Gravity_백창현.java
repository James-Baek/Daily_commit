import java.util.*;

public class Gravity_백창현 {
	static int[][] map;
	static int[][] map_90;
	
	static void rotation(int n, int max) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < max; j++) {
				map_90[i][j] = map[max-j-1][i];
			}
		}
	}
	
	static void drop(int n, int max) {
		for(int k = 0; k < n-1; k++) {
			for(int i = 0; i < max; i++) {
				for(int j = n-1; j > 0; j--) {
					if(map_90[j][i] == 0) {
						map_90[j][i] = map_90[j-1][i];
						map_90[j-1][i] = 0;
					}
				}
			}
		}
	}
	
	static int count(int n, int max) {
		int cnt = 0;
		int max_cnt = 0;
		
		for(int i = 0; i < max ; i++) {
			for(int j = n-1; j >= 0; j--) {
				if(map_90[j][i] == 0) {
					cnt++;
				}
			}
			max_cnt = max_cnt > cnt ? max_cnt : cnt;
			cnt = 0;
		}
		
		return max_cnt;
	}
	
	static void stackbox(int[] num, int m) {
		for(int i = 0; i < num.length; i++) {
			for(int j = m-1; j >= m - num[i]; j--) {
				map[j][i] = 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		int[] numlist = new int[num.length];
		int max = 0;
		
		for(int i = 0; i < num.length; i++) {
			numlist[i] = Integer.parseInt(num[i]);
			max = max > numlist[i] ? max : numlist[i];
 		}
		
		map = new int[max][num.length];
		map_90 = new int[num.length][max];
		
		stackbox(numlist, max);
		rotation(numlist.length, max);
		drop(numlist.length, max);
		System.out.println("최대 낙차는 "+ count(numlist.length, max)+ " 입니다.");
	}

}
