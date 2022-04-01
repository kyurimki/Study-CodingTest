import java.io.*;
import java.util.*;

public class BOJ10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int num;
        for(int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());

            if(num == 0 && !stack.isEmpty()) {
                stack.pop();
            } else if(num != 0) {
                stack.push(num);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        br.close();
        System.out.println(sum);
    }
}
