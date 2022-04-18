import java.util.*;

public class BOJ16953 {
    static long A, B;
    static int count = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        makeB(A, 1);
        System.out.println(count == Integer.MAX_VALUE ? -1 : count);

        sc.close();
    }

    private static void makeB(long a, int cnt) {
        if(a == B) {
            count = Math.min(count, cnt);
            return ;
        }
        if(a > B) return ;

        if(a*2 <= B)
            makeB(a*2, cnt+1);
        if((a*10+1) <= B)
            makeB(a*10+1, cnt+1);
    }
}