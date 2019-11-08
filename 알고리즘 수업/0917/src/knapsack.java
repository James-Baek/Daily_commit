import java.util.Scanner;

public class knapsack {
	static int[][] gift = {{3,50},{4,40},{5,10},{6,30}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int[][] bag = new int[3][W+1];
		int min;

		for(int i = 1; i < 3; ++i) {
			for(int j = 1; j <= W; ++j) {
				if(gift[i][1] <= j) {
					bag[i][j] = Math.max(bag[i][j-gift[i][0]]+gift[i][1], bag[i-1][j]);
				}else {
					bag[i][j] = bag[i-1][j];
				}
			}
		}
		
		
		System.out.println(bag[W]);
	}

}
