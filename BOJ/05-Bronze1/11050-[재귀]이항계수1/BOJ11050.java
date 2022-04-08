import java.util.*;

public class BOJ11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(factorial(N)/(factorial(K)*factorial(N-K)));

        sc.close();
    }

    private static int factorial(int n) {
        if(n == 0) return 1;
        return n*factorial(n-1);
    }
}