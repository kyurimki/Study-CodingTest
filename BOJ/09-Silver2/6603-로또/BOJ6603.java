import java.io.*;
import java.util.*;

public class BOJ6603 {
    static int N = 6;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            if(size == 0) break;
            int[] numset = new int[size];
            for(int i = 0; i < size; i++)
                numset[i] = Integer.parseInt(st.nextToken());
            
            combination(numset, size, new int[N], new boolean[size], 0, 0);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void combination(int[] arr, int size, int[] output, boolean[] visited, int count, int start) {
        if(count == N) {
            for(int i = 0; i < N; i++)
                sb.append(output[i] + " ");
            sb.append('\n');
            return ;
        }

        for(int i = start; i < size; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            output[count] = arr[i];
            combination(arr, size, output, visited, count+1, i+1);
            visited[i] = false;
        }
    }
}