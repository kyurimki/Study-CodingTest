import java.io.*;
import java.util.*;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] origin = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> ranking = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            sorted[i] = Integer.parseInt(st.nextToken());
            origin[i] = sorted[i];
        }

        Arrays.sort(sorted);

        int rank = 0;
        for(int k : sorted) {
            if(!ranking.containsKey(k)) {
                ranking.put(k, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int o : origin) {
            int r = ranking.get(o);
            sb.append(r).append(' ');
        }

        System.out.println(sb);
    }
}