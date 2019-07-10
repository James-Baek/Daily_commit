import java.util.*;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // ArrayList<String> answer = new ArrayList<Stirng>();

        for(int i = 0; i < T; ++i){
            String temp = sc.nextLine();
            Decoder decoder = Base64.getDecoder();
            byte[] decodedBytes = decoder.decode(temp);
            System.out.println(new String(decodedBytes));
        }

        for(int j = 0; j < T; ++j){
            System.out.printf("#%d ",j);
            
        }
        
    }
}