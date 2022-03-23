import java.util.*;

public class BOJ6359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            boolean[] room = new boolean[n+1];

            for(int i = 1; i <= n; i++) {
                for(int j = i; j <= n; j++) {
                    if(j % i == 0) room[j] = !room[j];
                }
            }

            int count = 0;
            for(int i = 1; i <= n; i++)
                if(room[i]) count++;
            sb.append(count + "\n");
        }
        System.out.print(sb);
        sc.close();
    }    
}