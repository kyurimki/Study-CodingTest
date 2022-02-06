import java.util.*;

public class BOJ9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = n / 2;
            int y = n - x;

            while(true) {
                if(isPrime(x) && isPrime(y))
                    break;
                else {
                    x--;
                    y++;
                }
            }
            System.out.println(x + " " + y);
        }
        sc.close();
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
