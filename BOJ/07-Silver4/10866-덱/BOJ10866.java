import java.io.*;
import java.util.*;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    if(deque.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(deque.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    if(deque.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(deque.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    if(deque.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(deque.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(deque.peekFirst()).append('\n');
                    break;
                case "back":
                    if(deque.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(deque.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}