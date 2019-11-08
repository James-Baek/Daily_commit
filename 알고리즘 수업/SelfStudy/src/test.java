import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class test {

	public static void main(String[] args) {
		HashMap<Double,Integer[]> uid = new HashMap<Double,Integer[]>();
		String temp = "1 2 3 4 5 6 7";
		String[] test = temp.split(" ");
		System.out.println(Arrays.toString(test));
		String[] answer = {};
		ArrayList<Integer> tt = new ArrayList<Integer>();
		tt.add(1);
		tt.add(10);
		tt.sort(Collections.reverseOrder());
//		StringBuilder sb = new StringBuilder();
//		sb.toString().split(",");
		System.out.println(tt.toString());
		System.out.println(uid.get(0.5215));

//		System.out.println(Arrays.toString(newNum));
		int[] num = new int[1];
		uid.put(0.5, num);
	}

}
