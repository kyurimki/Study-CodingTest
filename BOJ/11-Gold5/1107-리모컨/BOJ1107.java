import java.io.*;
import java.util.*;

public class BOJ1107 {
    static int start = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        boolean[] broken = new boolean[10];
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++)
                broken[Integer.parseInt(st.nextToken())] = true;
        }

        int min = Math.abs(N-start);
        for(int i = 0; i <= 999999; i++) {
            String channel = String.valueOf(i);
            int length = channel.length();

            boolean status = true;
            for(int j = 0; j < length; j++) {
                if(broken[channel.charAt(j)-'0']) {
                    status = false;
                    break;
                }
            }
            if(status)
                min = Math.min(min, (Math.abs(N-i)+length));
        }
        System.out.println(min);
    }
}