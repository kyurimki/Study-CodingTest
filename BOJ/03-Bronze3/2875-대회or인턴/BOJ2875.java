import java.util.*;

public class BOJ2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= K; i++) {
            int x = N-i;
            int y = M-(K-i);

            max = Math.max(max, Math.min(x/2, y));
        }
        System.out.println(max);

        sc.close();
    }
}