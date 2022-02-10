import java.io.*;
import java.util.*;

public class SWEA3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
            sb.append("#" + tc + " ");
            int n = Integer.parseInt(br.readLine());
            int mid = (int)Math.ceil((double)n/2);

            st = new StringTokenizer(br.readLine());
            String[] cards = new String[n];
            for(int i = 0; i < n; i++)
                cards[i] = st.nextToken();
            
            for(int j = 0; j < n/2; j++) {
                sb.append(cards[j] + " ");
                sb.append(cards[mid+j] + " ");
            }

            if(n % 2 == 1) sb.append(cards[mid-1]);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}