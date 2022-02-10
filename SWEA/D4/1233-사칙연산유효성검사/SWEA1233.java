import java.io.*;
import java.util.*;

public class SWEA1233 {
    static int n;
    static String[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= 10; tc++) {
            n = Integer.parseInt(br.readLine());
            tree = new String[n+1];

            int answer = 1;
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                tree[Integer.parseInt(st.nextToken())] = st.nextToken();
            }

            int idx = n / 2;
            for(int i = 1; i < n+1; i++) {
                if(tree[i].charAt(0) >= '0' && tree[i].charAt(0) <= '9') {
                    if(i <= idx) {
                        answer = 0;
                        break;
                    }
                } else {
                    if(i > idx) {
                        answer = 0;
                        break;
                    }
                }
            }
            sb.append("#" + tc + " " + answer).append('\n'); 
        }
        System.out.print(sb);
    }
}