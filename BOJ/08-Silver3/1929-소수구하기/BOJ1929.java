import java.util.*;

public class BOJ1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        for(int i = M; i <= N; i++) {
            if(i <= 1) continue;
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println(i);
        }
        sc.close();
    }
}