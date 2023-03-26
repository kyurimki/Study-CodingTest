import java.io.*;
import java.util.*;

public class BOJ10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] cards = new int[21];
        for(int i = 1; i <= 20; i++) cards[i] = i;

        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            reverseCards(cards, a, b);
        }

        for(int i = 1; i <= 20; i++) sb.append(cards[i]).append(' ');
        System.out.println(sb);
    }

    static void reverseCards(int[] cards, int start, int end) {
        int mid = (end-start) / 2;

        for(int i = 0; i <= mid; i++) {
            int tmp = cards[start+i];
            cards[start+i] = cards[end-i];
            cards[end-i] = tmp;
        }
    }
}