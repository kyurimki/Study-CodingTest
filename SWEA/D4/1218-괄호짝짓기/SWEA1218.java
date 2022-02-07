import java.io.*;
import java.util.*;

public class SWEA1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < tc; i++) {
                char c = input.charAt(i);
                if((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[')
                    || (c == '}' && stack.peek() == '{') || (c == '>' && stack.peek() == '<'))
                    stack.pop();
                else
                    stack.push(c);
            }

            int answer = 0;
            if(stack.isEmpty()) answer = 1;
            sb.append("#" + t + " " + answer + '\n');
        }
        System.out.println(sb);
    }
}