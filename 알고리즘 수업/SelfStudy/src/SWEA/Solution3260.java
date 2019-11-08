package SWEA;
import java.util.*;

public class Solution3260 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int t = 1; t <= T; t++) {
			Double ans;
			String[] num = sc.nextLine().split(" ");
			Double a = Double.parseDouble(num[0]);
			Double b = Double.parseDouble(num[1]);
			ans = a+b;
//			int maxlen = num[0].length() > num[1].length() ? num[0].length() : num[1].length();
//			int minlen = num[0].length() < num[1].length() ? num[0].length() : num[1].length();
//			
//			char[] num1 = num[0].toCharArray();
//			char[] num2 = num[1].toCharArray();
//			
//			for(int i = 1; i <= minlen; i++) {
//				int a = num1[num1.length-i]-'0';
//				int b = num2[num2.length-i]-'0';
//				
//				if(a+b >= 10) {
//					int temp = 0;
//					if(num1.length-(i+1) >= 0) {
//						temp = num1[num1.length-(i+1)]-'0';
//					}else {
//						temp = num1[0]
//					}
//
//					temp++;
//					ans += (a+b)-10;
//					num1[num1.length-(i+1)] = (char)temp;
//					System.out.println((char)temp);
//				}else {
//					ans += (a+b);
//				}
//			}
			String c = ans.toString();
			System.out.printf("#%d %s\n", t, c.substring(0, c.length()-2));

		}
	}
}
