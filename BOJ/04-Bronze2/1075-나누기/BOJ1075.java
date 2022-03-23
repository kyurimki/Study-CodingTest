import java.util.*;

public class BOJ1075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();

        for(int i = N/100*100; i < (N/100+1)*100; i++) {
            if(i % F == 0) {
                String answer = String.valueOf(i%100);
                if(answer.length() == 1) answer = "0" + answer;
                System.out.println(answer);
                break;
            }
        }
        sc.close();
    }
}