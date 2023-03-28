import java.io.*;
import java.util.*;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int start = 0;

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if(input > start) {
                for(int i = start+1; i <= input; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = input;
            } else if(stack.peek() != input) {
                System.out.println("NO");
                return ;
            }
            // else문 밖에 위치 -> start = input인 경우에 pop 가능
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.print(sb);
    }
}