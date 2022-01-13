import java.util.*;

public class BOJ15963 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        if(n == m) System.out.println(1);
        else System.out.println(0);

        sc.close();
    }
}