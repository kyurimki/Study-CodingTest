import java.io.*;
import java.util.*;

class Route11657 {
    int start;
    int end;
    int value;

    public Route11657(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}

public class BOJ11657 {
    static int N, M;
    static Route11657[] r;
    static long[] dist;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dist = new long[N+1];
        Arrays.fill(dist, INF);

        M = Integer.parseInt(st.nextToken());
        r = new Route11657[M];
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            r[m] = new Route11657(A, B, C);
        }

        if(bellmanFord(1))
            sb.append("-1\n");
        else {
            for(int i = 2; i <= N; i++) {
                if(dist[i] == INF)
                    sb.append("-1\n");
                else
                    sb.append(dist[i] + "\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean bellmanFord(int start) {
        dist[start] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < M; j++) {
                int s = r[j].start;
                int e = r[j].end;
                int v = r[j].value;

                if(dist[s] == INF) continue;
                
                if(dist[e] > (dist[s]+v)) {
                    dist[e] = dist[s]+v;

                    if(i == N) return true;
                }
            }
        }
        return false;
    }
}
