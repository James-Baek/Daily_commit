package WS1_마이쮸_백창현;

import java.util.LinkedList;
import java.util.Queue;

class Player{
	int num;
	int my;
	public Player(int num, int my) {
		this.num = num;
		this.my = my;
	}
}

public class WS1_마이쮸_백창현 {
	static int cnt;

	public static void main(String[] args) {
		Queue<Player> queue = new LinkedList<Player>();
		cnt = 0;
		int next = 1;
		while(true) {
			queue.offer(new Player(next, 1));
			next++;
			cnt += queue.peek().my;
			if(20 - cnt <= 0) {
				System.out.printf("%d번이 %d개의 마이쥬를 받는다.\n", queue.peek().num, 20 - cnt + queue.peek().my);
				break;
			}
			System.out.printf("%d번이 %d개의 마이쥬를 받는다.\n", queue.peek().num, queue.peek().my);
			Player np = queue.poll();
			np.my++;
			queue.offer(np);
		}
	}
}
