import java.io.*;
import java.util.*;

public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(N-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(M-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(map.get(x) == null ? 0 : map.get(x)).append(' ');
        }
        System.out.println(sb);
    }
}