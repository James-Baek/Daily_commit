package com.ssafy.step1.car;

import java.util.Arrays;

public class CarMgr {
	private Car[] cars;
	
	//2. 객체를 1번 생성해서 참조변수에 저장한다.(참조변수는 static으로 작성)
	private static CarMgr instance = new CarMgr();
	
	//1. 생성자를 private
	private CarMgr() {
		super();
	}
	
	//3. 참조변수가 private일 경우 getter제공
	public static CarMgr GetInstance() {
		return instance;
	}
	
	public void add(Car newCar) {
		int idx = 0;
		if(cars == null) {
			this.cars = new Car[1];
			cars[cars.length-1] = newCar;
		}else {
			if(newCar != null) {
				for(Car temp : cars) {
					if(temp == null) {
						cars[idx] = newCar;
						System.out.println(newCar.getNum()+" "+newCar.getModel()+" 차량이 추가됐습니다.");
						return;
					}
					if(newCar.getNum() == temp.getNum()) {
						System.out.println("이미 등록된 번호의 차량입니다.");
						return;
					}
					idx++;
				}
				cars = Arrays.copyOf(cars, cars.length+1);
				cars[cars.length-1] = newCar;
			}
		}
		System.out.println(newCar.getNum()+" "+newCar.getModel()+" 차량이 추가됐습니다.");
	}
	
	public Car[] search() {
		System.out.println("####################### 모든 차량 정보 ########################");
		for(Car temp : cars) {
			if(temp == null) {
				continue;
			}
			System.out.println(temp.toString());
		}
		return cars;
	}
	
	public Car search(String num) {
		boolean isFind = false;
		
		for(Car temp : cars) {
			if(temp == null) {
				continue;
			}
			if(temp.getNum().equals(num)) {
				isFind = true;
				System.out.println("######### 요청하신 차량번호 \'"+num+"\' 의 정보입니다. #########");
				System.out.println(temp.toString());
				return temp;
			}
		}
		if(!isFind) {
			System.out.println("######### 요청하신 차량번호 \'"+num+"\' 와 일치하는 차량이 없습니다. #########");			
		}
		return null;
	}
	
	public Car[] search(int price) {
		boolean isFind = false;
		String txtfindList = "";
		Car[] findList = new Car[cars.length];
		int idx = 0;
		
		for(Car temp : cars) {
			if(temp == null) {
				continue;
			}
			if(temp.getPrice() < price) {
				isFind = true;
				findList[idx] = temp;
				txtfindList += temp.toString()+"\n";
				idx++;
			}
		}
		if(isFind) {
			System.out.println("######### 요청하신 \'"+price+"\' 가격 미만 차량정보입니다. #########");
			System.out.print(txtfindList);
			findList = Arrays.copyOf(findList, idx+1);
			return findList;
		}else {
			System.out.println("######### 요청하신 \'"+price+"\' 가격 미만 차량이 없습니다. #########");
			return null;
		}
	}
	
	public void update(String num, int price) {
		Car temp = search(num);
		if(temp == null) {
			return;
		}else {
			temp.setPrice(price);
			System.out.println("########## 요청하신 \'"+num+"\' 차량의 가격이 "+price+"원으로 변경됐습니다.");
		}
	}
	
	public void delete(String num) {
		int len = cars.length;
		int idx = 0;
		for(Car temp : cars) {
			if(temp == null) {
				continue;
			}
			if(temp.getNum() == num) {
				cars[idx] = null;
				System.out.println("############# 요청하신 \'"+num+"\' 차량 정보가 삭제됐습니다.");
				return;
			}
			idx++;
		}
	}
	
	public int size() {
		int sum = 0;
		for(Car temp : cars) {
			if(temp != null) sum += 1;
		}
		System.out.println("저장된 차량 수량은 총 "+sum+"대 입니다.");
		return sum;
	}
	
	public int totalPrice() {
		int sum = 0;
		for(Car temp : cars) {
			if(temp != null) sum += temp.getPrice();
		}
		System.out.println("저장된 차량 금액의 총합은 "+sum+"원 입니다.");
		return sum;
	}
}
