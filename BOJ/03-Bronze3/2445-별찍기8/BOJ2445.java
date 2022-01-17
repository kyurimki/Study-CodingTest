import java.util.*;

public class BOJ2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++)
				System.out.print("*");
			for(int j = i; j < n; j++)
				System.out.print(" ");
            for(int j = n; j < 2*n-i; j++)
				System.out.print(" ");
			for(int j = 2*n-i; j < 2*n; j++)
				System.out.print("*");
            System.out.println();
        }
        
        for(int i = n-1; i >= 1; i--) {
            for(int j = 0; j < i; j++)
				System.out.print("*");
			for(int j = i; j < n; j++)
				System.out.print(" ");
            for(int j = n; j < 2*n-i; j++)
				System.out.print(" ");
			for(int j = 2*n-i; j < 2*n; j++)
				System.out.print("*");
            System.out.println();
        }

        sc.close();
    }
}