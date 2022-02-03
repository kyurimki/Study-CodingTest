import java.util.*;

public class SWEA1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            String input = sc.next();
            int[] num = new int[input.length()];
            for(int j = 0; j < input.length(); j++)
                num[j] = input.charAt(j) - '0';

            int count = num[0];
            for(int j = 1; j < num.length; j++) {
                if(num[j-1] != num[j]) count++;
            }

            System.out.println("#" + i + " " + count);
        }
        sc.close();
    }
}