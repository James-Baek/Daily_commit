package WS;

import java.util.Scanner;

public class WS2_LinkedList {
	static int V;
	static int E;
	
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
				return "";
			}
			return this.name+" "+this.next.toString();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		Node[] list = new Node[V];
		
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
	}

}
