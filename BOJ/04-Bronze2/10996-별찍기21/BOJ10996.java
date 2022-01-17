import java.util.*;

public class BOJ10996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		
		for(int i = 1; i <= 2*n; i++) {
			if(i % 2 == 1) {
				for(int j = 1; j <= n; j++) {
					System.out.print(j % 2 == 1 ? "*" : " ");
				}
			} else {
				for(int j = 1; j <= n; j++) {
					System.out.print(j % 2 == 1 ? " " : "*");
				}
			}
			System.out.println();
		}
        sc.close();
	}
}