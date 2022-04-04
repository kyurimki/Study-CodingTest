import java.io.*;
import java.util.*;

public class BOJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] LIS = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        int max = 0;
        LIS[0] = 1;
        for(int i = 0; i < N; i++) {
            LIS[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && LIS[i] < LIS[j]+1)
                    LIS[i] = LIS[j]+1;
            }
            if(max < LIS[i]) max = LIS[i];
        }
        sb.append(max).append('\n');

        Stack<Integer> stack = new Stack<>();
        for(int i = N-1; i >= 0; i--) {
            if(LIS[i] == max) {
                stack.add(arr[i]);
                max--;
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop() + " ");

        System.out.print(sb);
    }
}