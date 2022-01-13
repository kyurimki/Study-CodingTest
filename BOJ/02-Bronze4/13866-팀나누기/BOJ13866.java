import java.util.*;

public class BOJ13866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(Math.abs((a+d)-(b+c)));
        sc.close();
    }
}