import java.io.*;
import java.util.*;

public class BOJ11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] H = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            H[i] = Integer.parseInt(st.nextToken());
        
        int count = 0;
        for(int i = 0; i < N; i++) {
            int h = H[i];

            if(h == 0) continue;

            count++;
            H[i] = 0;
            h--;
            
            for(int j = i; j < N; j++) {
                if(H[j] == h) {
                    H[j] = 0;
                    h--;
                }
            }
        }
        System.out.println(count);
    }
}