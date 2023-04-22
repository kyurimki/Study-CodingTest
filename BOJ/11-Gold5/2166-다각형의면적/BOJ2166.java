import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N+1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }
        points[N] = points[0];

        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < N; i++) {
            sum1 += (long)points[i].x * points[i+1].y;
            sum2 += (long)points[i].y * points[i+1].x;
        }
        System.out.println(String.format("%.1f", Math.abs((sum1-sum2)/2.0)));
    }
}