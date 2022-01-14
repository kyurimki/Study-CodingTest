import java.util.*;

public class BOJ1267 {
    static int[] Y = {30, 10};
    static int[] M = {60, 15};
    public static void main(String[] args) {
        
        int calls = 0;
        int y = 0, m = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            calls = sc.nextInt();

            y += charge(Y, calls);
            m += charge(M, calls);
        }

        if(y > m) System.out.println("M " + m);
        else if(y < m) System.out.println("Y " + y);
        else System.out.println("Y M "+y);

        sc.close();
    }

    public static int charge(int[] c, int call) {
        return ((call / c[0]) + 1) * c[1];
    }
}