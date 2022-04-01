import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int from, to, weight;

    Point(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Point o) {
        return this.weight-o.weight;
    }
}

public class BOJ4485 {
    static int N;
    static int[][] rupees, distance;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int stage = 0;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            stage++;

            rupees = new int[N][N];
            distance = new int[N][N];
            for(int i = 0; i < N; i++)
                Arrays.fill(distance[i], Integer.MAX_VALUE);

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++)
                    rupees[i][j] = Integer.parseInt(st.nextToken());
            }
            sb.append("Problem " + stage + ": " + dijakstra()).append('\n');
        }
        System.out.print(sb);
    }

    private static int dijakstra() {
        distance[0][0] = rupees[0][0];

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, distance[0][0]));

        while(!pq.isEmpty()) {
            Point p = pq.poll();

            for(int i = 0; i < 4; i++) {
                int cx = p.from + dx[i];
                int cy = p.to + dy[i];

                if(cx < 0 || cx >= N || cy < 0 || cy >= N) continue;
                if(distance[cx][cy] > distance[p.from][p.to] + rupees[cx][cy]) {
                    distance[cx][cy] = distance[p.from][p.to] + rupees[cx][cy];
                    pq.add(new Point(cx, cy, distance[cx][cy]));
                }
            }
        }
        return distance[N-1][N-1];
    }
}