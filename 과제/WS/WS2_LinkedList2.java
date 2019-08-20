
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WS2_LinkedList2 {
	static int V;
	static int E;
	static Node[] list;
	static int cnt;
	static int depth;
	static boolean[] visited;
	
	static class Node{
		char name;
		Node next;
		public Node() {}
		public Node(char name, Node next) {
			this.name = name;
			this.next = next;
		}
		
		public String toString() {
			if(next == null) {
				return this.name+"";
			}
			return this.name+" "+this.next.toString();
		}
	}
	
	public static void endFind() {
		Queue<Node> queue = new LinkedList<Node>();
		
		depth = 0;
		Node first = list[0];
		queue.offer(first);
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int idx = now.name -'A';
			visited[idx] = true;
			queue.offer(list[idx]);
			System.out.print(now.name+" ");
			
			while(now.next != null && !visited[now.next.name-'A']) {
				queue.offer(now.next);
				now = now.next;
				idx = now.name - 'A';
				System.out.print(now.name+" ");
				visited[idx] = true;
			}

			depth++;
			System.out.println("============ "+depth+" ============");
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		list = new Node[V];
		visited = new boolean[V];
		
		for(int i = 0; i < E; i++) {
			char tempA = sc.next().charAt(0);
			char tempB = sc.next().charAt(0);
			int r = tempA - 'A';
			int c = tempB - 'A';
			if(list[r] == null) {
				list[r] = new Node(tempB, null);
			}else {
				Node tempNode = list[r];
				while(tempNode.next != null) {
					tempNode = tempNode.next;
				}
				tempNode.next = new Node(tempB, null);
			}
			if(list[c] == null) {
				list[c] = new Node(tempA, null);
			}else {
				Node tempNode = list[c];
				while(tempNode.next != null) {
					tempNode = tempNode.next;
				}
				tempNode.next = new Node(tempA, null);
			}
		}
		for(Node n : list) {
			System.out.println(n.toString());
		}
		
		endFind();
	}

}
