package Jungol;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class jungol1697 {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 0; t < T; t++) {
			String[] temp = sc.nextLine().split(" ");
			switch(temp[0]) {
			case "i":
				queue.offer(Integer.parseInt(temp[1]));
				break;
			case "c":
				System.out.println(queue.size());
				break;
			case "o":
				if(!queue.isEmpty()) {
					System.out.println(queue.poll());
				}else{
					System.out.println("empty");
				}
				break;
			}
		}
	}

}
