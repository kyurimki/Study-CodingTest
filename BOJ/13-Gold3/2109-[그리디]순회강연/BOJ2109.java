import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Point[] info = new Point[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 금액 -> x
            int d = Integer.parseInt(st.nextToken()); // 날짜 -> y
            info[i] = new Point(p, d);
        }

        Arrays.sort(info, (p1, p2) -> (p1.x == p2.x) ? p2.y-p1.y : p2.x-p1.x);

        int answer = 0;
        boolean[] checked = new boolean[10001];
        for(int i = 0; i < n; i++) {
            for(int j = info[i].y; j > 0; j--) {
                if(checked[j]) continue;
                checked[j] = true;
                answer += info[i].x;
                break;
            }
        }
        System.out.println(answer);
    }
}