import java.util.*;

public class BOJ11728 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arrA = new int[n];
        int[] arrB = new int[m];
        for(int i = 0; i < n; i++) arrA[i] = sc.nextInt();
        for(int i = 0; i < m; i++) arrB[i] = sc.nextInt();

        int i = 0;
        int j = 0;
        while(i < n && j < m) {
            if(arrA[i] < arrB[j]) sb.append(arrA[i++] + " ");
            else sb.append(arrB[j++] + " ");
        }
        while(i < n) sb.append(arrA[i++] + " ");
        while(j < m) sb.append(arrB[j++] + " ");

        System.out.println(sb);

        sc.close();
    }
}