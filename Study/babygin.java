
import java.util.*;

public class babygin {
	static boolean[] permu;
	static int cnt;
	static boolean isFind;

	public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i]; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
	} 
	
	static void makepermu(String input, int start, int end) {
		if(!isFind){
			if(start == end){
				if(isbabygin(input)){
					System.out.println("베이비진 입니다.");
					isFind = true;
					return;
				}

			}else{
				for (int i = l; i <= r; i++) { 
					input = swap(input, l, i); 
					makepermu(input, l + 1, r); 
					input = swap(input, l, i); 
				}
			}
		}
	}
	
	static boolean isbabygin(String num) {
		boolean front = false;
		boolean last = false;

		// 앞 3자리가 triplet이니?
		if(num.charAt(0) == num.charAt(1) && num.charAt(0) == num.charAt(2)){
			front = true;
		}

		// 앞 3자리가 run이니?
		if(Math.abs((num.charAt(1) - '0') - (num.charAt(0) - '0')) == 1 && Math.abs((num.charAt(1) - '0') - (num.charAt(2) - '0')) == 1 ){
			front = true;
		}

		// 뒤 3자리가 triplet이니?
		if(num.charAt(3) == num.charAt(4) && num.charAt(3) == num.charAt(5)){
			front = true;
		}

		// 뒤 3자리가 run이니?
		if(Math.abs((num.charAt(4) - '0') - (num.charAt(3) - '0')) == 1 && Math.abs((num.charAt(4) - '0') - (num.charAt(5) - '0')) == 1 ){
			front = true;
		}

		if(front & last){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("test");
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine().toString();
		System.out.println(n.length());
		makepermu(n, 0, n.length());
		sc.close();
	}

}
