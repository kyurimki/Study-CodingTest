import java.io.*;
import java.util.*;

public class BOJ1516 {
    static int N;
    static int[] time, buildTime, count;
    static ArrayList<Integer>[] pre;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        time = new int[N+1];
        buildTime = new int[N+1];
        pre = new ArrayList[N+1];
        count = new int[N+1];

        for(int i = 0; i <= N; i++)
            pre[i] = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            
            for(int j = 1; j < input.length-1; j++) {
                pre[Integer.parseInt(input[j])].add(i);
                count[i]++;
            }
        }

        arrange();

        for(int i = 1; i <= N; i++)
            sb.append(buildTime[i]).append('\n');
        System.out.print(sb);
    }

    private static void arrange() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1; i <= N; i++) {
            if(count[i] == 0) {
                pq.offer(i);
                buildTime[i] = time[i];
            }
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();

            for(int sub : pre[cur]) {
                count[sub]--;

                if(count[sub] == 0) 
                    pq.offer(sub); 
                    
                buildTime[sub] = Math.max(buildTime[sub], time[sub]+buildTime[cur]);
            }
        }
    }
}