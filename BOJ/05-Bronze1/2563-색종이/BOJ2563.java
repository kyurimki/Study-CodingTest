import java.util.*;

public class BOJ2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[100][100];

        int count = 0;
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int j = x; j < x+10; j++) {
                for(int k = y; k < y+10; k++) {
                    if(arr[j][k] == 1)
                        continue;
                    arr[j][k] = 1;
                    cnt += 1;
                }
            }
        }
        System.out.println(count);
    }
}