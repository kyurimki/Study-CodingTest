import java.io.*;
import java.util.*;

public class BOJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensor = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            sensor[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sensor);

        int[] sub = new int[N];
        for(int i = 1; i < N; i++)
            sub[i] = sensor[i] - sensor[i-1];
        Arrays.sort(sub);

        int sum = 0;
        for(int i = 1; i <= N-K; i++)
            sum += sub[i];
        System.out.println(sum);
    }
}