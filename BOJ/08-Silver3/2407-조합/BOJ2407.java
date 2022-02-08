import java.math.BigInteger;
import java.util.*;

public class BOJ2407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        for(int i = 0; i < m; i++) {
            n1 = n1.multiply(new BigInteger(String.valueOf(n-i)));
            n2 = n2.multiply(new BigInteger(String.valueOf(i+1)));
        }

        BigInteger answer = n1.divide(n2);
        System.out.println(answer);

        sc.close();
    }
}