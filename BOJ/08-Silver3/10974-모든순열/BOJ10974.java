import java.util.*;

public class BOJ10974 {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        sb = new StringBuilder();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = i+1;

        permutation(arr, new boolean[N], new int[N], 0);
        System.out.print(sb);
    }

    static void permutation(int[] arr, boolean[] visited, int[] output, int depth) {
        if(depth == N) {
            for(int i = 0; i < N; i++) sb.append(output[i]).append(' ');
            sb.append('\n');
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            output[depth] = arr[i];
            permutation(arr, visited, output, depth+1);
            visited[i] = false;
        }
    }
}