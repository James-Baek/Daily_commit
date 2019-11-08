package HW;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution_D3_1228_암호문1_백창현 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("c:\\input.txt"));
		Scanner sc = new Scanner(System.in);

		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(sc.nextLine());
			String[] temp_origin = sc.nextLine().split(" ");
			LinkedList<Integer> result = new LinkedList<Integer>();
			
			for(String temp : temp_origin) {
				result.offer(Integer.parseInt(temp));
			}
			
			int O = Integer.parseInt(sc.nextLine());
			
			String[] order = sc.nextLine().split("I");
			
			for(String temp : order) {
				String[] od = temp.split(" ");
				if(temp.length() <= 1) continue;
				int x = Integer.parseInt(od[1]);
				int y = Integer.parseInt(od[2]);
				
				
				for(int i = y+2; i >= 3; --i) {
					
					result.add(x, Integer.parseInt(od[i]));
				}
			}
			
			
			System.out.printf("#%d ", t);
			
			for(int k = 0; k < 10; k++) {
				System.out.printf("%d ", result.poll());
			}
			System.out.println();
		}
	}

}
