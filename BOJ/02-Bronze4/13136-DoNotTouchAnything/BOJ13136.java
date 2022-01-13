import java.util.*;

public class BOJ13136 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();

        long cnt = r / n;
        if(r % n != 0) cnt++;

        int tmp = c / n;
        if(c % n != 0) tmp++;
        cnt *= tmp;

        System.out.println(cnt);
        sc.close();
    }
}