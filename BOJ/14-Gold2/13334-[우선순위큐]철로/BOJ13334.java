import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ13334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            list.add(new Point(x, y));
        }
        int L = Integer.parseInt(br.readLine());

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.y == o2.y) return o1.x-o2.x;
                return o1.y-o2.y;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0, max = 0;
        for(Point p : list) {
            while(!pq.isEmpty() && pq.peek() < p.y-L) {
                pq.poll();
                cnt--;
            }

            if(p.x >= p.y-L) {
                cnt++;
                pq.add(p.x);
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
