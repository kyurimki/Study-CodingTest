import java.util.*;

public class BOJ1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] S = sc.next().toCharArray();

        int[] count = new int[2];
        char cur = '2';
        for(char s : S) {
            if(s != cur) {
                cur = s;
                count[cur-'0']++;
            }
        }

        System.out.println(Math.min(count[0], count[1]));
        sc.close();
    }
}