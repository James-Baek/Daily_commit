package WS;


public class StackLinkedList {
	private static class Node{
		Object data;
		Node prev,next;
		
		public Node() {}
		public Node(Object data) {
			super();
			this.data = data;
		}
		public Node(Object data, Node prev, Node next) {
			this(data);
			this.prev = prev;
			this.next = next;
		}
		
	}
	
	private Node head; // 첫번째 노드의 포인터 역할

	private int size;
	
	public void push(String element) {
		Node newNode;
		if(head == null) {
			head = new Node(element, null, head);
			return;
		}else {
			Node top = getTop();
			newNode = new Node(element,top,null);
			top.next = newNode;
		}
		size++;
	}
	
	public Node getTop() {
		Node current = head;
		if(current != null) {
			while(current.next != null) {
				current = current.next;
			}
		}else {
			return null;
		}
		return current;
	}
	
	public String pop() {
		Node top = getTop();
		if(top == null) {
			return "스택이 비어있습니다.";
		}
		String el = top.data.toString();
		Node pre = top.prev;
		if(pre == null) {
			head = null;
			size--;
			return el;
		}
		pre.next = null;
		top.prev = null;
		size--;
		return el;
	}
	
	public String peek() {
		Node top = getTop();
		String el = top.data.toString();
		return el;
	}
	public static void main(String[] args) {
		StackLinkedList stack = new StackLinkedList();
		stack.push("월요일");
		stack.push("화요일");
		stack.push("수요일");
		stack.push("목요일");
		stack.push("금요일");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push("금요일");
		stack.push("일요일");
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
	}
}
