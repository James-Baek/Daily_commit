import java.util.*;
public class Solution_D4_1218_괄호짝짓기_백창현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int len = sc.nextInt();
			int[] cnt = new int[4];
			sc.nextLine();
			String str = sc.nextLine();
			boolean isFind = true;
			
			for(char temp : str.toCharArray()) {
				switch(temp) {
				case '(':
					cnt[0]++;
					break;
				case '{':
					cnt[1]++;
					break;
				case '[':
					cnt[2]++;
					break;
				case '<':
					cnt[3]++;
					break;
				case ')':
					cnt[0]--;
					break;
				case '}':
					cnt[1]--;
					break;
				case ']':
					cnt[2]--;
					break;
				case '>':
					cnt[3]--;
					break;
				}
			}
			for(int num: cnt) {
				if(num != 0) isFind = false;
			}
			
			if(isFind) {
				sb.append("#"+t+" 1\n");
			}else {
				sb.append("#"+t+" 0\n");
			}
		}
		System.out.println(sb);
	}
}
