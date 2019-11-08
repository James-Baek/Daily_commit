import java.util.Arrays;
import java.util.Scanner;

public class LISTest_BinarySearch_백창현 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int N = sn.nextInt();
		int[] num = new int[N];
		int[] LIS = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = sn.nextInt();
		}
		
		int size = 0;

        for (int i=0; i < N; i++) {
            int temp = Arrays.binarySearch(LIS, 0, size, num[i]);
            temp = Math.abs(temp)-1;
            LIS[temp] = num[i];

            if (size == temp) {
                size++;
            }
        }
        System.out.println(size);
	}

}
