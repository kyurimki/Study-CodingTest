import java.util.*;

public class BOJ3009 {
    public static void main(String[] args) {
        int[] x = new int[3];
        int[] y = new int[3];
        
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int dx;
        int dy;

        dx = x[0] == x[1] ? x[2]: x[0];
        dy = y[0] == y[1] ? y[2] : y[0];

        System.out.println(dx + " " + dy);

        sc.close();
    }
}