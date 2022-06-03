import java.io.*;
import java.util.*;

public class BOJ1025 {
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
    
        int[][] A = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++)
                A[i][j] = input[j]-'0';
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int x = -N; x < N; x++) {
                    for(int y = -M; y < M; y++) {
                        if(x == 0 && y == 0) continue;
                        
                        int num = 0, cx = i, cy = j;
                        while(0 <= cx && cx < N && 0 <= cy && cy < M) {
                            num = num*10 + A[cx][cy];
                            
                            int sqrt = (int) Math.sqrt(num);
                            if(num == sqrt*sqrt) answer = Math.max(answer, num);

                            cx += x;
                            cy += y;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}