import java.io.*;
import java.util.*;

public class SWEA3307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] LIS = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            
            int max = 0;
            for(int i = 0; i < N; i++) {
                LIS[i] = 1;
                for(int j = 0; j < i; j++) {
                    if(arr[j] < arr[i] && LIS[i] < LIS[j]+1)
                        LIS[i] = LIS[j]+1;
                }
                if(max < LIS[i]) max = LIS[i];
            }
            sb.append("#" + t + " " + max + "\n");
        }
        System.out.print(sb);
    }
}