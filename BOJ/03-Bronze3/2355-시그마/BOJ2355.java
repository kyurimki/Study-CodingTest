import java.util.*;

public class BOJ2355 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        
        System.out.println((int)((a+b) * (Math.max(a, b)- Math.min(a, b) + 1) / 2.0));

        sc.close();
    }
}