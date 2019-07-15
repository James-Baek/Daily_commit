import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] tempList = new int[N];
			int max = 0;
			int cnt = 1;
			
			for(int eachCase = 0; eachCase < N; eachCase++ ) {
				int tempNum = sc.nextInt();
				tempList[eachCase] = tempNum;
			}
			
			for(int i = 0; i < tempList.length; i++) {
				int pick = tempList[i];
				for(int j = i+1; j < tempList.length; j++) {
					if(pick <= tempList[j]) {
						pick = tempList[j];
						cnt++;
					}
				}
				if(cnt > max) {
					max = cnt;
				}
				cnt = 1;
			}

			answer.add(max);
			
			System.out.printf("#%d %d\n", testCase, answer.get(testCase - 1));
		}
		sc.close();
	}
}
