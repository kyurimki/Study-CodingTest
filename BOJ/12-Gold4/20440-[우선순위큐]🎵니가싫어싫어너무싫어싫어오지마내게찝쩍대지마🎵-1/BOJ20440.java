import java.io.*;
import java.util.*;

class Time20440 implements Comparable<Time20440> {
    int e, x;

    public Time20440(int e, int x) {
        this.e = e;
        this.x = x;
    }

    @Override
    public int compareTo(Time20440 o) {
        if(this.e == o.e)
            return this.x-o.x;
        return this.e-o.e;
    }
}

public class BOJ20440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Time20440[] list = new Time20440[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list[i] = new Time20440(e, x);
        }
        Arrays.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list[0].x);

        int cnt = 1;
        int e = list[0].e;
        int x = list[0].x;

        for(int i = 1; i < N; i++) {
            while(!pq.isEmpty() && pq.peek() < list[i].e)
                pq.poll();
            
            if(!pq.isEmpty() && pq.peek() == list[i].e) {
                if(pq.peek() == x)
                    x = list[i].x;
                pq.poll();
            }
            
            pq.add(list[i].x);
            if(pq.size() > cnt) {
                cnt = pq.size();
                e = list[i].e;
                x = pq.peek();
            }
        }
        System.out.println(cnt);
        System.out.println(e + " " + x);
    }
}