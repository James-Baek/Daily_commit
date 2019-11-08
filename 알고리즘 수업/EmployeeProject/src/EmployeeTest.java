import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import com.ssafy.model.dao.EmployeePolyManager;
import com.ssafy.model.dto.Employee;
import com.ssafy.model.dto.Engineer;
import com.ssafy.model.dto.Manager;

public class EmployeeTest {
	static class EmployeeComparator implements Comparator<Employee>{
		@Override
		public int compare(Employee o1, Employee o2) {
			// 연봉기준 내림차순, 사번기준 오름차순
			int result = -(o1.getSalary() - o2.getSalary());
			if(result == 0) {
				result = o1.getEmpno().compareTo(o2.getEmpno());
			}
			return result;
		}
	}
	public static void main(String[] args) {

		Employee[] list = new Employee[]{
				new Employee("1234","하하",7000000),
				new Employee("2321","백창현",7000000),
				new Employee("3000","유재석",80000000)
				
		};
		
		
		Arrays.sort(list, new EmployeeComparator());
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
		
		ArrayList<Employee> eList = new ArrayList<Employee>();
		eList.add(new Employee("1234","하하",7000000));
		eList.add(new Employee("2321","백창현",7000000));
		eList.add(new Employee("3000","유재석",80000000));
		
		Collections.sort(eList, new EmployeeComparator());
		System.out.println(eList);
		
		System.out.println("########### 스크린 ############");
		int[][] map = new int[24][30];
		char[] line = new char[] {'A','B','C','D','E','F','G'};
		for(int i = 0; i < 24; i++) {
			System.out.print(line[i%7]);
			for(int j = 0; j < 30; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
}
