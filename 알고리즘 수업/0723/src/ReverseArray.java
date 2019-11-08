import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4}
					  ,{5,6,7,8}
					  ,{9,10,11,12}
					  ,{13,14,15,16}};
		
		for(int i = 0; i < arr[0].length; i++) {
			for(int j = 0; j < i; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		
		for(int[] num : arr) {
			System.out.println(Arrays.toString(num));
		}

	}
}
