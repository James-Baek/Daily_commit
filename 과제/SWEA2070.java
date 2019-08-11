package ssafy;
import java.util.*;

public class SWEA2070 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			char ans = ' ';
			
			if(a == b) {
				ans = '=';
			}else if(a > b) {
				ans = '>';
			}else if(a < b) {
				ans = '<';
			}
			
			System.out.printf("#%d %c\n", t, ans);
		}
	}

}
