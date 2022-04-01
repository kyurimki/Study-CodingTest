import java.io.*;
import java.util.*;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            stack = new Stack<>();
            char[] input = br.readLine().toCharArray();
            sb.append(isVPS(stack, input) ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isVPS(Stack<Character> stack, char[] input) {
        for(int i = 0; i < input.length; i++) {
            if(input[i] == '(')
                stack.push(input[i]);
            else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}