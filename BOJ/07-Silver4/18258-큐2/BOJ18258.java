import java.io.*;
import java.util.*;

public class BOJ18258 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();
        int back = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch(input) {
                case "push":
                    back = Integer.parseInt(st.nextToken());
                    q.add(back);
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : back).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}