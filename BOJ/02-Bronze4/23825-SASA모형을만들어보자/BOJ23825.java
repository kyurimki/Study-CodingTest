import java.util.*;

public class BOJ23825 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        System.out.println(n/2 > m/2 ? m/2 : n/2);
        sc.close();
    }
}