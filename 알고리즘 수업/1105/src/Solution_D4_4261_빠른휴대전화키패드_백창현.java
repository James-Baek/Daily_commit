import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;

public class Solution_D4_4261_빠른휴대전화키패드_백창현 {
	static int ans;
	static int S, N;
	static char[][] num = {{},
							{},{'a','b','c'},{'d','e','f'},
							{'g','h','i'},{'j','k','l'},{'m','n','o'},
							{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
							};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		HashMap<Character, Integer> phone = new HashMap<Character, Integer>();
		
		int cnt = 0;
		for(char[] alpha : num) {
			for(char temp : alpha) {
				phone.put(temp, cnt);
			}
			cnt++;
		}
		
		for(int t = 1; t <= T; t++) {
			ans = 0;
			String[] line = sc.nextLine().split(" ");
			String[] words = sc.nextLine().split(" ");
			for(String w : words) {
				String target = "";
				if(w.length() != line[0].length()) continue;
				for(int i = 0; i < w.length(); i++) {
					target += phone.get(w.charAt(i));
				}
				if(target.equals(line[0])) ans++;
			}
			
			System.out.printf("#%d %d\n", t, ans);
		}
		
	}

}
