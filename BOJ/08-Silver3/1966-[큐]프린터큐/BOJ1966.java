import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Queue<Point> printQ;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 인쇄 순서 궁금한 문서 순서

            printQ = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) printQ.add(new Point(i, Integer.parseInt(st.nextToken())));

            sb.append(getOrder(printQ, M)).append('\n');   
        }
        System.out.print(sb);
    }

    static int getOrder(Queue<Point> q, int M) {
        int count = 0;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            boolean isMax = true;
            for(Point p : q) {
                if(cur.y < p.y) {
                    isMax = false;
                    break;
                }
            }

            if(isMax) {
                count++;
                if(cur.x == M) return count;
            } else q.add(cur);
        }
        return count;
    }
}