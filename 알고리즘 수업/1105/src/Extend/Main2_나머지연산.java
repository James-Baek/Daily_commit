package Extend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 120ms : 숫자를 10으로 나머지연산, 6의 개수가 연속으로 3이상인지 확인
public class Main2_나머지연산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 10,000 자연수
		int cnt = 0;	// 666의 개수
		int index = 666;
		while(true) {
			int cnt6 = 0; // 연속된 숫자 6의 개수
			int num = index; // 나누기해서 저장할때 숫자값에 영향이 없도록
			for(; num > 0; num /= 10) {
				if(num % 10 == 6) { // 1의 자리가 6이냐?
					cnt6++;
					if(cnt6 == 3) { // 연속 3이상이냐?
						cnt++;
						break;
					}
				} else {
					cnt6 = 0;
				}
				
			}
			if (cnt == N) {
				break;
			}
			index++;
		}
		System.out.println(index);
	}

}
