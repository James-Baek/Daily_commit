package Extend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 116ms : 숫자를 1000으로 나머지연산, 666이 있는지 확인

public class Main3_나머지연산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 10,000 자연수
		int cnt = 0;	// 666의 개수
		int index = 666;
		while(true) {
			int num = index;
			for(; num > 0; num /= 10) {
				if(num % 1000 == 666) { // 마지막 세자리가 666 인지
					cnt++;
					break;					
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
