package com.ssafy.step1.queue;

import javax.management.RuntimeErrorException;

public class CircularQueue {
	private Object[] queue;
	private final int MAX_SIZE;
	private int front, rear; // front : 마지막으로 dequeue된 원소자리,
							 // rear : 마지막으로 enqueue된 원소자리,
	
	public CircularQueue(int maxSize) {
		MAX_SIZE = maxSize;
		queue = new Object[maxSize];
		front = rear = 0; ///////////////////////////////
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return (rear+1)%MAX_SIZE == front;///////////////////////////////////////////
	}
	
	public void enQueue(Object item) {
		if(isFull()) {
			throw new RuntimeException("큐가 포화상태입니다.");
		}
		rear = (rear+1)%MAX_SIZE;//////////////////////////////
		queue[rear] = item;////////////////////////////////
	}
	
	public Object peek() {
		if(isEmpty()) {
			throw new RuntimeException("큐가 공백상태입니다.");
		}
		return queue[(front+1)%MAX_SIZE];/////////////////////////////////////////////
	}
	
	public Object deQueue() {
		Object result = peek();
		front=(front+1)%MAX_SIZE;////////////////////////////////////////
		queue[front] = null;//////////////////////////////////
		return result;
	}
}
