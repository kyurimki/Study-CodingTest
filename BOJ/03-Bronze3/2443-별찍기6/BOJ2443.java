import java.util.*;

public class BOJ2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=n; i >= 1; i--) {
            for(int j = 0; j < n-i; j++)
				System.out.print(" ");
			for(int j = 0; j < i*2-1; j++)
				System.out.print("*");
			System.out.println();
        }

        sc.close();
    }
}