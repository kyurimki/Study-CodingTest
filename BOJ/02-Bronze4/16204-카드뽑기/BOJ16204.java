import java.util.*;

public class BOJ16204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        System.out.println(m<=k ? n+m-k : n-m+k);
        sc.close();
    }
}