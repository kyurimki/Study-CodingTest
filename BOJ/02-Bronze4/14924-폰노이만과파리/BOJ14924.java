import java.util.*;

public class BOJ14924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(d / (2*s) * t);
        sc.close();
    }
}