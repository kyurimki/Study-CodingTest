import java.util.*;

public class BOJ2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] N = sc.next().toCharArray();
        int B = sc.nextInt();
        sc.close();

        int digit = 1, answer = 0;
        for(int i = N.length-1; i >= 0; i--) {
            int base = ('A'<= N[i] && N[i]<='Z') ? (N[i]-'A'+10) : (N[i]-'0');
            answer += base * digit;
            digit *= B;
        }
        System.out.println(answer);
    }
}