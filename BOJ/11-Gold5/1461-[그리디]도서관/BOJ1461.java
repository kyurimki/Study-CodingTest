import java.io.*;
import java.util.*;

public class BOJ1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> nq = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int book = Integer.parseInt(st.nextToken());
            if(book > 0) pq.add(book);
            else nq.add(Math.abs(book));
            max = Math.max(max, Math.abs(book));
        }

        int steps = 0;
        while(!pq.isEmpty()) {
            int maxPQ = pq.poll();
            for(int i = 1; i < M; i++) {
                pq.poll();
                if(pq.isEmpty()) break;
            }
            steps += maxPQ * 2;
        }

        while(!nq.isEmpty()) {
            int maxNQ = nq.poll();
            for(int i = 1; i < M; i++) {
                nq.poll();
                if(nq.isEmpty()) break;
            }
            steps += maxNQ * 2;
        }

        steps -= max;
        System.out.println(steps);
    }
}