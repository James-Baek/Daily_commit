package com.ssafy.step2.list;

public class SimpleLinkedList {
	private static class Node{
		Object data;
		Node link;
		
		public Node() {}
		public Node(Object data) {
			super();
			this.data = data;
		}
		public Node(Object data, Node link) {
			this(data);
			this.link = link;
		}
		
	}
	private Node head; // 첫번째 노드의 포인터 역할
	private int size;
	
	public void addFirstNode(Object data) {
		Node newNode = new Node(data, head); // head에 저장된 첫번째 노드를 새노드의 링크로
		head = newNode; // head에 새 노드 연결
		size++;
	}
	
	public Node getLastNode() {
		Node current = head;
		if(current != null) {
			while(current.link != null) {
				current = current.link;
			}			
		}
		return current;
	}
	
	public void addLastNode(Object data) {
		Node lastNode = getLastNode();
		Node newNode = new Node(data);
		if(lastNode == null) {  // 공백리스트
			head = newNode;
		}else { // 공백 리스트가 아니면
			lastNode.link = newNode; // 마지막 노드에 새노드 연결
		}
		size++;
	}
	
	public void deleteFirstNode() {
		if(head == null) throw new RuntimeException("공백리스트여서 삭제가 불가능합니다.");
		Node temp = head;
		head = head.link;
		temp.link = null;
		size--;
	}
	
	public int getSize() {
		return size;
	}
	
	public Node getPreNode(Node target) {
		if(size < 2) return null;
		
		Node current = head;
		while(current.link != target) {
			current = current.link;
		}

		return current;
	}
	
	public void deleteLastNode() {
		Node lastNode = getLastNode();
		if(lastNode == null) throw new RuntimeException("공백리스트여서 삭제가 불가능합니다.");
		Node preNode = getPreNode(lastNode);
		if(preNode != null) {
			preNode.link = null;
		}else {
			head = null;
		}
		size--;
	}
	
	public void print() {
		Node current = head;
		System.out.print("L = (");
		while(current != null) {
			System.out.print(current.data+" ");
			current = current.link;
		}
		System.out.println(")");
	}
}
