package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol1295 {
	static String[] input;
	static int idx;
	public static void binary(int start, int end, int target) {
		int pivot = (start + end) / 2;
		int pNum = Integer.parseInt(input[pivot]);
		if(start == end && pNum != target) {
			idx = 0;
			return;
		}
		
		if(end - start == 1) {
			if(Integer.parseInt(input[start]) == target) {
				idx = start+1;
				return;
			}else if(Integer.parseInt(input[end]) == target) {
				idx = end+1;
				return;
			}
		}
		if(pNum == target) {
			idx = pivot+1;
			return;
		}else if(pNum > target){
			start = start;
			end = pivot-1;
			binary(start, end, target);
		}else if(pNum < target) {
			start = pivot+1;
			end = end;
			binary(start, end, target);
		}

		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		input = br.readLine().split(" ");		
		int T = Integer.parseInt(br.readLine().trim());
		String[] targets = br.readLine().split(" ");
		
		for(int i = 0; i < targets.length; i++) {
			idx = 0;
			binary(0,input.length-1,Integer.parseInt(targets[i]));
			sb.append(idx).append("\n");
		}
		System.out.print(sb);
	}

}
