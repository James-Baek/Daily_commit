import java.util.Scanner;

public class CoinRecursive {
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		changeCoin(money, 0);
		System.out.println(MIN);
	}
	
	private static void changeCoin(int money, int count) {
		if(money==0) {
			if(count < MIN) MIN = count;
			return;
		}
		
		//1원
		if(money>=1) changeCoin(money-1, count+1);
		//4원
		if(money>=4) changeCoin(money-4, count+1);
		//6원
		if(money>=6) changeCoin(money-6, count+1);
	}
}
