import java.io.*;
import java.util.*;

public class SWEA4012 {
    static int N;
    static int[][] S;

    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            visited = new boolean[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++)
                    S[i][j] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            combination(0, 0);
            sb.append("#" + t + " " + min + "\n");
        }
        System.out.print(sb);
    }

    private static void combination(int count, int start) {
        if(count == N/2) {
            count();
            return ;
        }

        for(int i = start; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            combination(count+1, i+1);
            visited[i] = false;
        }
    }

    private static void count() {
        int A = 0, B = 0;
        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(visited[i] && visited[j])
                    A += (S[i][j] + S[j][i]);
                else if(!visited[i] && !visited[j])
                    B += (S[i][j] + S[j][i]);
            }
        }
        min = Math.min(min, Math.abs(A-B));
    }
}