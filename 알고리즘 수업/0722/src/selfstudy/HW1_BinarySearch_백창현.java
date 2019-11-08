package selfstudy;

public class HW1_BinarySearch_백창현 {

	public static void main(String[] args) {
		int[] num = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,56,94,99,103,206,333,697,1002};
		int target = 99;
		int start = 0;
		int end = num.length; // 18
		int pivot = (start+end)/2; // 9
		
		while(true) {
			if(num[pivot] == target) {
				System.out.println("target 넘버 "+target+ "의 인덱스는 "+ pivot +" 입니다.");
				System.out.println(pivot+ "인덱스의 값은 " + num[pivot] + " 입니다.");
				break;
			}
			if(num[pivot] < target) {
				start = pivot;
				pivot = (pivot + end) / 2;
			}
			else
				end = pivot;
				pivot = (start+pivot) / 2;
		}
	}
}
