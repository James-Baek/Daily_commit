package HW1_암호생성기_백창현;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;


public class HW1_암호생성기_백창현 {
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void makecry() {
		while(true) {
			for(int i = 1; i <= 5; i++) {
				int temp = queue.poll() - i;
				if(temp <= 0) {
					queue.offer(0);
					return;
				}
				queue.offer(temp);
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int tt = sc.nextInt();
			for(int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			
			makecry();
			
			System.out.printf("#%d ", t);
			for(int j = 0; j < 8; j++) {
				System.out.printf("%d ", queue.poll());
			}
			System.out.println();
		}
		
	}

}
