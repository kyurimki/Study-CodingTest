import java.io.*;
import java.util.*;

public class SWEA7812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] land = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) land[i] = Integer.parseInt(st.nextToken());

            int count = 0;
            int sum;
            for(int i = 0; i < N; i++) {
                sum = 0;
                for(int j = 0; j < N; j++) {
                    if(i+j >= N) break;
                    
                    sum += land[i+j];
                    if(sum == M) count++;
                }
            }
            sb.append("#" + t + " " + count + "\n");
        }
        System.out.print(sb);
    }
}
