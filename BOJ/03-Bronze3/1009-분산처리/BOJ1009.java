import java.util.*;

public class BOJ1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int x = 1;
            if(a%10 == 0 || a%10 == 1 || a%10 == 5 || a%10 == 6) x = a%10;
            else {
                for(int j = 0; j < b; j++) {
                    x = (x * a) % 10;
                }
            }
            if(x == 0) x = 10;
            System.out.println(x);
        }
        sc.close();
    }
}