import java.util.*;

public class BOJ11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int b = sc.nextInt();

        while(n > 0) {
            if(n % b < 10)
                sb.append((char)(n%b+'0'));
            else
                sb.append((char)(n%b-10+'A'));
            n /= b;
        }
        System.out.println(sb.reverse());

        sc.close();
    }
}