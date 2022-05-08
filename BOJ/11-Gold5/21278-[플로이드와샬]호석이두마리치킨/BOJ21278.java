import java.io.*;
import java.util.*;

public class BOJ21278 {
    static int N, M;
    static int[][] time;
    static int min = Integer.MAX_VALUE;
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(time[i], N);
            time[i][i] = 0;
        }
            

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            time[a][b] = 1;
            time[b][a] = 1;
        }

        floydWarshall();

        combination(new int[2], new boolean[N+1], 1, 0);

        System.out.println(answer[0] + " " + answer[1] + " " + min);
    }

    private static void floydWarshall() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++)
                    time[j][k] = Math.min(time[j][k], time[j][i] + time[i][k]);
            }
        }
    }

    private static void combination(int[] output, boolean[] visited, int start, int cnt) {
        if(cnt == 2) {
            int sum = 0;
            for(int i = 1; i <= N; i++) {
                if(visited[i]) continue; // 치킨집인 건물 제외
                int minDist = Integer.MAX_VALUE;
                for(int j : output)
                    minDist = Math.min(minDist, time[i][j]);
                sum += (minDist*2);
            }

            // System.out.println(Arrays.toString(output.clone()) + " " + min);
            if(sum < min) {
                min = sum;
                answer[0] = output[0];
                answer[1] = output[1];
            }
            return ;
        }

        for(int i = start; i <= N; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            output[cnt] = i;
            combination(output, visited, i+1, cnt+1);
            visited[i] = false;
        }
    }
}
