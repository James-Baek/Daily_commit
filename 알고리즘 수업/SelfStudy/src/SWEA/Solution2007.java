package SWEA;
import java.util.*;
public class Solution2007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t = 1; t <= T; t++) {
			int ans = 0;
			String txt = sc.nextLine();
			char[] list = txt.toCharArray();
			for(int i = 1; i < txt.length()/2; i++) {
				String temp = txt.substring(0, i);
				String temp2 = txt.substring(i,i+i);
				if(temp.equals(temp2)) {
					ans = temp.length();
					break;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
