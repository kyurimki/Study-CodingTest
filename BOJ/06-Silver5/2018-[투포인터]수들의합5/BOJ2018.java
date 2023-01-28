import java.util.*;

public class BOJ2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start = 1, end = 1, sum = 1, count = 0;
        while(start <= end) {
            if(sum == N) count++;
            
            if(sum < N) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}