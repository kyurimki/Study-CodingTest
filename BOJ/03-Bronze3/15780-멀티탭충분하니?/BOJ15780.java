import java.io.*;
import java.util.*;

public class BOJ15780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int count = 0;
        st = new StringTokenizer(br.readLine());
        while(K-- > 0)
            count += (Integer.parseInt(st.nextToken())+1) / 2;
        
        System.out.println(count >= N ? "YES" : "NO");
    }
}