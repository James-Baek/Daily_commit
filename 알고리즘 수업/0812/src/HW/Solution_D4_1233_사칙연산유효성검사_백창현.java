package HW;

import java.util.Scanner;

public class Solution_D4_1233_사칙연산유효성검사_백창현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			int ans = 1;
			int totalNode = Integer.parseInt(sc.nextLine());
			for(int i = 0; i < totalNode; i++) {
				String[] node = sc.nextLine().split(" ");
				if(Character.isDigit(node[1].toCharArray()[0]) && node.length > 2) {
					ans = 0;
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
