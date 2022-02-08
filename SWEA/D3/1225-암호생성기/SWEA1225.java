import java.io.*;
import java.util.*;

public class SWEA1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();
        
        int tc = 0;
        String input = null;
        while((input = br.readLine()) != null) {
            tc = Integer.parseInt(input);
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 8; i++) q.add(Integer.parseInt(st.nextToken()));

            out: while(true) {
                for(int i = 1; i <= 5; i++) {
                    int x = q.poll();
                    x -= i;
                    if(x < 1) x = 0;
                    q.add(x);
                    if(x == 0) break out;
                }
            }

            sb.append("#" + tc + " ");
            while(!q.isEmpty())
                sb.append(q.poll() + " ");
            sb.append('\n');
        }
        System.out.print(sb);
    }
}