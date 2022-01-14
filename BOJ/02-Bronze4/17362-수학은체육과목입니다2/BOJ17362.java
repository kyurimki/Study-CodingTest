import java.util.*;

public class BOJ17362 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n %= 8;

        System.out.println(n > 5 || n == 0 ? (10-n)%8 : n);
        sc.close();
    }
}