import java.io.*;
import java.util.*;

public class BOJ16637 {
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> num;
    static ArrayList<Character> op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        
        num = new ArrayList<Integer>();
        op = new ArrayList<Character>();
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) num.add((int)(input[i]-'0'));
            else op.add(input[i]);
        }

        dfs(0, num.get(0));

        System.out.println(max);

    }

    static void dfs(int cur, int sum) {
        if(cur >= op.size()) {
            max = Math.max(max, sum);
            return ;
        }

        int without = cal(sum, num.get(cur+1), op.get(cur));
        dfs(cur+1, without);

        if(cur+1 < op.size()) {
            int with = cal(num.get(cur+1), num.get(cur+2), op.get(cur+1));
            int result = cal(sum, with, op.get(cur));
            dfs(cur+2, result);
        }
    }

    static int cal(int a, int b, char op) {
        switch(op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 1;
    }
}