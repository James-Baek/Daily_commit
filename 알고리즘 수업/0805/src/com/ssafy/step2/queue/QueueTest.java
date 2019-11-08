package com.ssafy.step2.queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enQueue("봄");
		System.out.println(queue.deQueue());
		queue.enQueue("여름");
		System.out.println(queue.deQueue());
		queue.enQueue("가을");
		System.out.println(queue.deQueue());
		queue.enQueue("겨울");
		System.out.println(queue.deQueue());
		queue.enQueue("안녕하세요");
		System.out.println(queue.deQueue());
		queue.enQueue("화이팅");
		System.out.println(queue.deQueue());
	}

}
