import java.io.*;
import java.util.*;

class Lecture11000 {
    int start;
    int end;

    Lecture11000(int start, int end) {
        this.start = start;
        this.end  = end;
    }
}

public class BOJ11000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Lecture11000[] lectures = new Lecture11000[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture11000(start, end);
        }

        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);

        for(int i = 1; i < n; i++) {
            if(pq.peek() <= lectures[i].start)
                pq.poll();
            pq.offer(lectures[i].end);
        }

        System.out.println(pq.size());
    }
}