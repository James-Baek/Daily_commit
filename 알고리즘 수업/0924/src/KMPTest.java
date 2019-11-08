import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMPTest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] T = in.readLine().toCharArray();
		char[] P = in.readLine().toCharArray();
		
		int tLength = T.length, pLength = P.length;
		int[] fail = new int[pLength];
		
		// 실패함수 만들기 : P에서 P를 찾는 형태로...
		// 해당 부분문자열의 최대접미사의 길이
		for(int i = 1, j = 0; i <pLength; ++i) { // i : 접미사포인터, j : 접두사포인터
			// j위치에서 틀리면 j-1위치까지는 맞았다는 이야기
			// fail[j-1] : j-1위치까지 일치하는 접미사의 길이 ==> 이동해야 하는 다음 비교 j위치
			while(j>0 && P[i] != P[j]) j = fail[j-1];
			
			if(P[i] == P[j]) fail[i] = ++j;
		}
		
		int cnt = 0;
		
		
		// i : 텍스트포인터, j : 패턴포인터
		// i는 계속 증가하는 형태
		for(int i = 0, j = 0; i < tLength; ++i) {
			while(j > 0 && T[i] != P[j]) j = fail[j-1];
			if(T[i] == P[j]) {
				if(j == pLength-1) { // 패턴의 끝까지 일치
					cnt++;
					j = fail[j];
				}else {
					++j;
				}
			}
		}
		System.out.println(cnt);
	}

}
