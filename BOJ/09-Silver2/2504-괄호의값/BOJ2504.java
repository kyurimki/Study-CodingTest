import java.io.*;
import java.util.*;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        int answer = 0;
        int tmp = 1;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length; i++) {
            char c = input[i];
            if(c == '(') {
                stack.push('(');
                tmp *= 2;
            } else if(c == '[') {
                stack.push('[');
                tmp *= 3;
            } else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                if(input[i-1] == '(')
                    answer += tmp;
                
                stack.pop();
                tmp /= 2;
            } else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                if(input[i-1] == '[')
                    answer += tmp;
                
                stack.pop();
                tmp /= 3;
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : answer);
    }
}