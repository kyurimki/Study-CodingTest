import java.util.*;

public class BOJ1476 {
    static int e = 15, s = 28, m = 19;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int year = 0;
        while(true) {
            year++;
            if((year-E)%e == 0 && (year-S)%s == 0 && (year-M)%m == 0) break;
        }
        System.out.println(year);

        sc.close();
    }
}