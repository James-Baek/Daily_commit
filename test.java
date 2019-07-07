import java.util.*;

public class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList();
        Vector<Integer> vec = new Vector();

        list.add(10);
        list.add(20);
        list.add(30);

        vec.add(10);
        
        int a = 0;

        for(int i = 0; i <= 10; ++i){
            a = a + i;
        }
        System.out.println("test2");
        System.out.println(a);

        for(int x : list){
            System.out.println(x);
        }

        System.out.println(vec);
    }
}