import java.util.*;

public class BOJ1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;
        int min = 0;
        for(int i = m; i <= n; i++) {
            int x = (int) Math.sqrt(i);
            if(x*x == i) {
                sum += i;
                min = min == 0 ? i : min;
            }
        }
        System.out.println((sum != 0 && min != 0) ? (sum + "\n" + min) : -1);
        sc.close();
    }
}