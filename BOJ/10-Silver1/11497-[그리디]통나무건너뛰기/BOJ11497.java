import java.io.*;
import java.util.*;

public class BOJ11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 통나무 개수
            
            int[] woods = new int[N];
            int[] sorted = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) woods[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(woods);
            sorted[N/2] = woods[N-1];
            for(int i = 0; i < N/2; i++) {
                sorted[i] = woods[2*i];
                sorted[N-1-i] = woods[2*i+1];
            }
            if(N % 2 == 0) sorted[N/2-1] = woods[N-2];
            
            int max = 0;
            for(int i = 1; i < N; i++)
                max = Math.max(max, Math.abs(sorted[i] - sorted[i-1]));
            
            sb.append(max + "\n");
        }
        System.out.print(sb);
    }
}