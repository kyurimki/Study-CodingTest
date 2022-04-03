import java.io.*;
import java.util.*;

public class BOJ1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[26];
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            int size = input.length;
            int digit = (int) Math.pow(10, size-1);
            for(int j = 0; j < size; j++) {
                count[input[j]-'A'] += digit;
                digit /= 10;
            }
        }
        Arrays.sort(count);
        
        int sum = 0;
        for(int i = 25; i > 16; i--)
            sum += (count[i] * (i-16));
        System.out.println(sum);
    }
}