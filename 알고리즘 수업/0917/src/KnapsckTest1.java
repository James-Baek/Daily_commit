import java.util.Scanner;

public class KnapsckTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		int[][] D = new int[N][W+1];
		
		for(int i = 1; i <= N; ++i) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int itemWeight, itemProfit;
		
		for(int item = 1; item <= N; ++item) {
			itemWeight = weights[item];
			itemProfit = profits[item];
			for(int weight = 1; weight <= W; ++weight) {
				if(itemWeight<=weight) {
					D[item][weight] = Math.max(D[item-1][weight - itemWeight]+itemProfit, D[item-1][weight]);
				}else { // 현아이템이 weight 무게를 초과
					D[item][weight] = D[item-1][weight];
				}
			}
		}
		System.out.println(D[N][W]);
	}
}
