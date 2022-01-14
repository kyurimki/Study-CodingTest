import java.util.*;

public class BOJ1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(lcm(a, b));
        }
        sc.close();
    }

    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}