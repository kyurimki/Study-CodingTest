import java.util.*;

public class BOJ10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] N = sc.nextLine().toCharArray();
        sc.close();

        long sum = 0;
        int[] numCnt = new int[10];
        for(char n : N) {
            int cur = n-'0';
            numCnt[cur]++;
            sum += cur;
        }

        if(numCnt[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
            return ;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(numCnt[i] > 0) {
                sb.append(i);
                numCnt[i]--;
            }
        }
        System.out.println(sb);
    }
}