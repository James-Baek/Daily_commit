import java.util.Arrays;
import java.util.Scanner;

public class CoinMemo2 {
	static int memo[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		memo = new int[money+1];
		Arrays.fill(memo, -1);
		
		System.out.println(changeCoin(money));
	}
	
	private static int changeCoin(int money) {
		if(money == 0) return 0;
		if(memo[money] != -1) return memo[money];
		
		int min = Integer.MAX_VALUE;
		int temp = 0;
		//1원
		
		if(money>=1 && (temp = changeCoin(money-1)+1) < min) min = temp;
		//4원
		if(money>=4 && (temp = changeCoin(money-4)+1) < min) min = temp;
		//6원
		if(money>=6 && (temp = changeCoin(money-6)+1) < min) min = temp;
		return memo[money] = min;
	}
}
