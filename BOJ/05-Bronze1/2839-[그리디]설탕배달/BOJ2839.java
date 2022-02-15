import java.util.*;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;
        boolean flag = false;
        while(n >= 0) {
            if(n % 5 == 0) {
                result += n / 5;
                System.out.println(result);
                flag = true;
                break;
            }
            n -= 3;
            result++;
        }
        if(!flag) System.out.println(-1);

        sc.close();
    }
}