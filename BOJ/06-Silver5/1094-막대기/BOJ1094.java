import java.util.*;

public class BOJ1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        int result = 0;
        for(int i = 0; i <= 6; i++) {
            if((X&(1 << i)) > 0) result++;
        }
        System.out.println(result);
    }
}