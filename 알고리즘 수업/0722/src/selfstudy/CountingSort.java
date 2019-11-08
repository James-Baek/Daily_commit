package selfstudy;
import java.util.*;

public class CountingSort {
	static int[] counting(int[] arr, int max) {
		int[] counts = new int[max+1];
		//1. count세기
		for(int i = 0; i < arr.length; ++i) {
			counts[arr[i]]++;
		}
		//2. count 누적하기
		for(int i = 1; i < 5; ++i) {
			// i-1 i 2번째 count 부터 누적될 것이 있으니 i = 1부터 시작
			counts[i] = counts[i-1] + counts[i];
			
		}
		//3. 누적 count 이용하여 각 원소 자기자리 꽂아주기
		int[] newArr = new int[arr.length];
		for(int i = arr.length-1; i >= 0; --i) {
			newArr[counts[arr[i]] - 1] = arr[i];
			counts[arr[i]]--;
			
		}
		return newArr;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] temp_num = sc.nextLine().split(" ");
		int[] num = new int[temp_num.length];
		int max = 0;
		
		for(int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(temp_num[i]);
			max = max > num[i] ? max : num[i];
		}
		
		System.out.println(Arrays.toString(counting(num, max)));
		
		
	}

}
