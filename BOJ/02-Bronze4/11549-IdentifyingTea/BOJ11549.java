import java.util.*;

public class BOJ11549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < 5; i++) {
            int tea = sc.nextInt();
            if(tea == t) cnt++;
        }
        System.out.println(cnt);
        sc.close();
    }
}