import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cards = new int[n];
        for(int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int max = 0;
        int sum;
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                for(int k = j+1; k < n; k++) {
                    sum = cards[i]+cards[j]+cards[k];
                    if(sum <= m && sum > max) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
        sc.close();
    }
}
