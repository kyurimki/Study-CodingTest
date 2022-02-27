import java.io.*;
import java.util.*;

public class BOJ21317 {
    static int N, K;
    static int[][] energy;

    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        energy = new int[N][2];
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            energy[i][0] = Integer.parseInt(st.nextToken());
            energy[i][1] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());

        jump(1, false, 0);
        
        System.out.println(answer);
    }

    private static void jump(int cur, boolean maxJump, int sum) {
        if(cur == N) {
            answer = Math.min(answer, sum);
            return ;
        }
        
        if(cur > N) return ;

        jump(cur+1, maxJump, sum+energy[cur][0]);
        jump(cur+2, maxJump, sum+energy[cur][1]);

        if(!maxJump)
            jump(cur+3, true, sum+K);
    }
}