import java.io.*;
import java.util.*;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        char[] input = br.readLine().toCharArray();
        for(int i = 0; i < input.length; i++) {
            if(input[i] == '(')
                stack.push(input[i]);
            else {
                stack.pop();
                if(input[i-1] == '(') cnt += stack.size();
                else cnt++;
            }
        }
        System.out.println(cnt);
    }
}