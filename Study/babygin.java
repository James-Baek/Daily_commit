import java.util.*;

public class babygin {
	static boolean[] permu;
	static int cnt;
	static boolean isFind;

	public static String swap(String input, int i, int j) 
    { 
        char temp; 
        char[] charArray = input.toCharArray(); 
        temp = charArray[i]; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
	} 
	
	public static void makepermu(String input, int start, int end) {
		if(!isFind){
			if(start == end){
				if(isbabygin(input)){
					System.out.println("베이비진 입니다.");
					isFind = true;
					return;
				}

			}else{
				for (int i = start; i <= end; i++) { 
					input = swap(input, start, i); 
					makepermu(input, start + 1, end); 
					input = swap(input, start, i); 
				}
			}
		}
	}
	
	public static boolean isbabygin(String num) {
		boolean front = false;
		boolean last = false;

		// 앞 3자리가 triplet이니?
		if(num.charAt(0) == num.charAt(1) && num.charAt(0) == num.charAt(2)){
			front = true;
		}

		// 앞 3자리가 run이니?
		if((num.charAt(1) - '0') - (num.charAt(0) - '0') == 1 && (num.charAt(2) - '0') - (num.charAt(1) - '0') == 1 ){
			front = true;
		}

		// 뒤 3자리가 triplet이니?
		if(num.charAt(3) == num.charAt(4) && num.charAt(3) == num.charAt(5)){
			last = true;
		}

		// 뒤 3자리가 run이니?
		if((num.charAt(4) - '0') - (num.charAt(3) - '0') == 1 && (num.charAt(5) - '0') - (num.charAt(4) - '0') == 1 ){
			last = true;
		}

		if(front & last){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine().toString();
		makepermu(n, 0, n.length()-1);
		if(!isFind) {
			System.out.println("베이비진이 아닙니다.");
		}
		sc.close();
	}

}
