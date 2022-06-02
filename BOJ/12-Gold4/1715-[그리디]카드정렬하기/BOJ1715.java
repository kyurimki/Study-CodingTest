import java.io.*;
import java.util.*;

public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++)
            pq.offer(Long.parseLong(br.readLine()));
        
        long total = 0;
        while(!pq.isEmpty()) {
            long a = pq.poll();
            if(pq.isEmpty()) break;
            long b = pq.poll();
            long sum = a + b;
            total += sum;
            pq.offer(sum);
        }
        System.out.println(total);
    }
}