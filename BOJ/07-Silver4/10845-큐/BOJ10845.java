import java.io.*;
import java.util.*;

public class BOJ10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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
                    System.out.println(q.isEmpty() ? -1 : q.poll());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(q.isEmpty() ? -1 : q.peek());
                    break;
                case "back":
                    System.out.println(q.isEmpty() ? -1 : back);
                    break;
            }
        }
    }
}