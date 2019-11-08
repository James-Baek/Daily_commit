
public class recursive {
	static int nsum(int n) {
		if(n == 1) {
			return 1;
		}
		return n + nsum(n-1);
	}
	public static void main(String[] args) {

		System.out.println(nsum(10));
	}

}
