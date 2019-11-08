
public class test {

	public static void main(String[] args) {

		int i = 0;
		int j = 10;
		
		while(true) {
			System.out.print(i);
			if(i++ > --j) {
				break;
			}
		}
	}

}
