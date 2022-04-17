import java.util.*;

public class BOJ2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        int layer = 1;
        int n = 0;
        int total = 1;

        while(true) {
            if(N <= total) break;
            else {
                n += 6;
                total += n;
                layer++;
            }
        }
        System.out.println(layer);

        sc.close();
    }
}