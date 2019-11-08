import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class nextPermu최적경로 {
	static int company;
	static int home;
	static int[] customers;
	static int[] distance;
	static int min;
	static int N;
	
	public static void swap(int from, int to) {
		int temp = customers[from];
		customers[from] = customers[to];
		customers[to] = temp;
	}
	
	public static boolean nextPermutation() {
		int i = N - 1;
		
		while(i > 0 && customers[i-1] >= customers[i] ) --i;
		
		if(i == 0) return false;
		
		int j = N - 1;
		
		while(customers[i-1]>=customers[j]) --j;
		
		swap(i-1, j);
		
		j = N-1;
		while(i<j) {
			swap(i++, j--);
		}
		
		for(int k = 1; k <= N; k++) {
			distance[k] = customers[k-1];
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T ; t++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			customers = new int[N];
			distance = new int[N+2];
			distance[0] = sc.nextInt()*1000 + sc.nextInt();
			distance[N+1]= sc.nextInt()*1000 + sc.nextInt();
			
			for(int i = 0 ; i < N; i++) {
				customers[i] = sc.nextInt()*1000 + sc.nextInt();
			}
			
			Arrays.sort(customers);
			
			for(int k = 1; k <= N; k++) {
				distance[k] = customers[k-1];
			}
			
			do {
				int dist = 0;
				for(int i = N+1; i > 0; i--) {
					int now_x = distance[i] / 1000;
					int now_y = distance[i] % 1000;
					int cust_x = distance[i-1] / 1000;
					int cust_y = distance[i-1] % 1000;
					dist += Math.abs(now_x - cust_x);
					dist += Math.abs(now_y - cust_y);
				}
				if(dist < min) min = dist;
			}while(nextPermutation());
			System.out.printf("#%d %d\n", t, min);
		}
	}

}
