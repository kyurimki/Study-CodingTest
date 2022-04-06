import java.io.*;
import java.util.*;

public class BOJ15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 총 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹어야 하는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];
        for(int i = 0; i < N; i++)
            sushi[i] = Integer.parseInt(br.readLine());
        
        int[] count = new int[d+1];
        int max = 0;
        for(int i = 0; i < k; i++) {
            if(count[sushi[i]] == 0) max++;
            count[sushi[i]]++;
        }
        
        int cnt = max;
        for(int i = 1; i < N; i++) {
            if(cnt >= max) {
                if(count[c] == 0) max = cnt+1;
                else max = cnt;
            }
            count[sushi[i-1]]--;
            if(count[sushi[i-1]] == 0) cnt--;

            if(count[sushi[(i+k-1)%N]] == 0) cnt++;
            count[sushi[(i+k-1)%N]]++;
        }
        System.out.println(max);
    }
}