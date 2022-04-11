import java.io.*;
import java.util.*;

class Package8980 implements Comparable<Package8980> {
    int start, end, boxes;

    public Package8980(int start, int end, int boxes) {
        this.start = start;
        this.end = end;
        this.boxes = boxes;
    }

    @Override
    public int compareTo(Package8980 o) {
        if(this.end == o.end)
            return Integer.compare(this.start, o.start);
        return Integer.compare(this.end, o.end);
    }
}

public class BOJ8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Package8980> pq = new PriorityQueue<>();
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.offer(new Package8980(s, e, b));
        }

        int sum = 0;
        int[] available = new int[N+1];
        while(!pq.isEmpty()) {
            Package8980 p = pq.poll();
            
            int max = Integer.MAX_VALUE;
            for(int i = p.start; i < p.end; i++)
                max = Math.min(max, C-available[i]);
            
            int pack = Math.min(max, p.boxes);
            sum += pack;
            for(int i = p.start; i < p.end; i++)
                available[i] += pack;
        }
        System.out.println(sum);
    }
}