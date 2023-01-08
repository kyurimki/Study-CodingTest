import java.util.*;

public class BOJ8870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ret = 0;
        for(int s = 1; s<=n; s++) {
            for(int k = s; k<=n; k++) {
                for(int i = k; i<=n; i++) {
                ret = (ret+s*k/i)%2010;
                }
            }
        }
        System.out.println(ret);
        sc.close();
    }
}
