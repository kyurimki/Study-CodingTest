import java.util.*;

public class BOJ21734 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();

        for(char c : input) {
            char[] size = Integer.toString((int)c).toCharArray();
            int sum = 0;
            for(char s : size) sum += (int)(s-'0');

            for(int i = 0; i < sum; i++) System.out.print(c);
            System.out.println();
        }
        
        sc.close();
    }
}