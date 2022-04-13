import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ9205 {
    static int n;
    static int LIMIT = 1000;
    static Point start, dest;
    static ArrayList<Point> cvs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int x, y;
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            start = new Point(x, y);

            cvs = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                cvs.add(new Point(x, y));
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            dest = new Point(x, y);

            sb.append(bfs() ? "happy" : "sad").append('\n');
        }
        System.out.print(sb);
    }

    private static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        boolean[] visited = new boolean[n];

        while(!q.isEmpty()) {
            Point p = q.poll();
            if(Math.abs(p.x-dest.x) + Math.abs(p.y-dest.y) <= LIMIT)
                return true;

            for(int i = 0; i < n; i++) {
                if(visited[i]) continue;

                Point np = cvs.get(i);
                int dist = Math.abs(p.x-np.x) + Math.abs(p.y-np.y);
                if(dist <= LIMIT) {
                    visited[i] = true;
                    q.offer(np);
                }
            }
        }
        return false;
    }
}