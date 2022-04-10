import java.io.*;
import java.util.*;

public class BOJ19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        char[] input = br.readLine().toCharArray();
        for(int i = 0; i < N; i++) {
            if(input[i] == 'P') {
                for(int j = -K; j <= K; j++) {
                    if(i+j < 0 || i+j >= N) continue;
                    if(input[i+j] == 'H') {
                        input[i+j] = '-';
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}