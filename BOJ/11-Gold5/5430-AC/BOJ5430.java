import java.io.*;
import java.util.*;

public class BOJ5430 {
    static int n;

    static Deque<Integer> dq;
    static boolean front;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String cmd = br.readLine();
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            dq = new LinkedList<>();
            front = true;
            for(int i = 0; i < n; i++) dq.add(Integer.valueOf(st.nextToken()));

            AC(cmd);
        }
        System.out.print(sb);
    }

    private static void AC(String cmd) {
        int length = cmd.length();
        for(int i = 0; i < length; i++) {
            if(cmd.charAt(i) == 'R') front = !front;
            else {
                if(dq.isEmpty()) {
                    sb.append("error\n");
                    return ;
                } else {
                    if(front) dq.pollFirst();
                    else dq.pollLast();
                }
            }
        }

        sb.append("[");
        while(!dq.isEmpty()) {
            if(front)
                sb.append(String.valueOf(dq.pollFirst()));
            else
                sb.append(String.valueOf(dq.pollLast()));
            if(!dq.isEmpty()) sb.append(",");
        }
        sb.append("]\n");
    }
}