import java.io.*;
import java.util.*;

public class BOJ6443 {
    static int length;
    static int[] alphaCnt;
    static StringBuilder sb;
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            alphaCnt = new int[26];
            stack = new Stack<>();

            char[] word = br.readLine().toCharArray();
            length = word.length;
            for(char c : word) alphaCnt[c-'a']++;

            anagram();
        }
        System.out.print(sb);
    }

    static void anagram() {
        if(stack.size() == length) {
            for(char s : stack) sb.append(s);
            sb.append('\n');
            return ;
        }

        for(int i = 0; i < 26; i++) {
            if(alphaCnt[i] > 0) {
                alphaCnt[i]--;
                stack.add((char)(i+'a'));
                anagram();
                stack.pop();
                alphaCnt[i]++;
            }
        }
    }
}