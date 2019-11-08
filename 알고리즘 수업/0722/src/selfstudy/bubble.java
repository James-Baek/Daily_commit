package selfstudy;
import java.util.*;

public class bubble {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] temp_num = sc.nextLine().split(" ");
		int[] num = new int[temp_num.length];
		
		for(int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(temp_num[i]);
		}
		
		for(int i = num.length - 1; i > 0 ; i--) {
			for(int j = 0; j < i; j++) {
				if(num[j] > num[j+1]) {
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(num));
	}
}
