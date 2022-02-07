import java.io.*;
import java.util.*;

public class SWEA9280 {
    static int n, m;
    static int[] R;
    static int[] W;

    static int[] spot;
    static int sum;
    static Queue<Integer> q;
    static Queue<Integer> waitLine;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            spot = new int[n];
            R = new int[n];
            for(int r = 0; r < n; r++) R[r] = Integer.parseInt(br.readLine());

            W = new int[m+1];
            for(int w = 1; w <= m; w++) W[w] = Integer.parseInt(br.readLine());

            sum = 0;
            q = new LinkedList<Integer>();
            waitLine = new LinkedList<Integer>();
            for(int i = 0; i < 2*m; i++)
                q.add(Integer.parseInt(br.readLine()));

            
            while(!q.isEmpty()) {
                int now = q.poll();
                
                if(now > 0) {
                    waitLine.add(now);
                    int car = waitLine.peek();
                    for(int i = 0; i < n; i++) {
                        if(spot[i] == 0) {
                            spot[i] = car;
                            sum += R[i] * W[car];
                            waitLine.poll();
                            break;
                        }
                    }
                } else {
                    for(int i = 0; i < n; i++) {
                        if(spot[i] == -now) {
                            spot[i] = 0;
                            if(!waitLine.isEmpty()) {
                                now = waitLine.poll();
                                spot[i] = now;
                                sum += R[i] * W[now];
                            }
                            break;
                        }
                    }
                }
            }
            sb.append("#" + t + " " + sum + '\n');
        }
        System.out.print(sb);
    }
}