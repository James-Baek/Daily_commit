package com.ssafy.step1.car;

public class CarTest {

	public static void main(String[] args) {
		CarMgr m1 = CarMgr.GetInstance();
		CarMgr m2 = CarMgr.GetInstance();
		System.out.println(m1 == m2);
		m1.add(new Car("가1234", "BMW", 70000000));
		m1.add(new Car("허3265", "페라리", 30000000));
		m1.add(new Car("바2146", "소나타", 5000000));
		m1.add(new Car("사6694", "벤틀리", 235000000));
		m1.search();
		m1.search("가1234");
		m1.search("헐1234");
		m1.search(40000000);
		m1.update("가1234", 1000);
		m1.search();
		m1.delete("바2146");
		m1.search();
		m1.size();
		m1.totalPrice();
		m1.add(new Bus("크7777", "G버스", 2800, 45));
		m1.add(new Truck("두8852", "8톤트럭", 111111111, 8));
		m1.search();
	}

}
