import java.util.*;

public class BOJ10995 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 2*n; j++) {
                if((i+j) % 2 == 0)
                    System.out.print("*");
                else System.out.print(" ");
            }	
			System.out.println();
        }
        
        sc.close();
    }
}