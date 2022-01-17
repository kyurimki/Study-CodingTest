import java.util.*;

public class BOJ10990 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for (int j = n ; j > i; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 0; j < 2 * i - 3; j++) {
				System.out.print(" ");

			}
			if (i > 1) System.out.print("*");

			System.out.println();
        }
        sc.close();
    }
}