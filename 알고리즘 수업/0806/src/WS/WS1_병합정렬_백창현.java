package WS;

import java.util.Arrays;

public class WS1_병합정렬_백창현 {

	public int[] merge(int[] num) {
		int Lsize = 0;
		int Rsize = 0;
		if(num.length % 2 != 0) {
			Lsize = num.length / 2 + 1;
			Rsize = num.length / 2;
		}else {
			Lsize = num.length / 2;
			Rsize = num.length / 2;
		}
		int[] left = new int[Lsize];
		int[] right = new int[Rsize];
		int[] mergedNum = new int[num.length];
		
		if(num.length == 1) {
			return num;
		}
		
		for(int i = 0; i < Lsize; i++) {
			left[i] = num[i];
		}
		for(int j = Lsize; j < num.length; j++) {
			right[j-Lsize] = num[j];
		}
		
		left = merge(left);
		
		right = merge(right);
		
		int lcnt = 0;
		int rcnt = 0;
		
		if(left.length == 1 && right.length == 1) {
			if(left[lcnt] < right[rcnt]) {
				mergedNum[0] = left[lcnt];
				mergedNum[1] = right[rcnt];
			}else {
				mergedNum[0] = right[rcnt];
				mergedNum[1] = left[lcnt];
			}
			return mergedNum;
		}
		for(int i = 0; i < num.length; ++i) {
			if(lcnt == left.length) {
				for(int j = i; j < num.length; ++j) {
					mergedNum[j] = right[rcnt];
					rcnt++;
				}
				break;
			}else if(rcnt == right.length) {
				for(int j = i; j < num.length; ++j) {
					mergedNum[j] = left[lcnt];
					lcnt++;
				}
				break;
			}
			
			int L = left[lcnt];
			int R = right[rcnt];
			
			if(L < R) {
				mergedNum[i] = L;
				lcnt++;
			}else {
				mergedNum[i] = R;
				rcnt++;
			}
		}
		
		return mergedNum;
	}
	public static void main(String[] args) {
		WS1_병합정렬_백창현 mg = new WS1_병합정렬_백창현();
		int[] list = {69,10,30,2,16,8,31,22};
		
		System.out.println(Arrays.toString(mg.merge(list)));
	}

}
