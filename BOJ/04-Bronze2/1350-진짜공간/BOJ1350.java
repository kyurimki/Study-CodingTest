import java.util.*;

public class BOJ1350 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] files = new int[n];
        for(int i = 0; i < n; i++)
            files[i] = sc.nextInt();
        int cluster = sc.nextInt();

        long sum = 0;
        for(int i = 0; i < n; i++) {
            int p = files[i] / cluster;
            int q = files[i] % cluster;
            if(q != 0) p++;
            sum += p;
        }

        System.out.println(sum * cluster);
        
        sc.close();
    }
}