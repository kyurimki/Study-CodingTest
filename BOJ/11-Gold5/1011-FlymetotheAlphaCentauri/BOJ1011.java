import java.io.*;
import java.util.*;

public class BOJ1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(getCount(x, y) + "\n");
        }
        System.out.print(sb);
    }

    private static int getCount(int x, int y) {
        int distance = y-x;
        int max = (int)Math.sqrt(distance);

        if(max*max == distance) return (2*max-1);
        else if(distance <= max*max+max) return (2*max);
        else return (2*max+1);
    }
}