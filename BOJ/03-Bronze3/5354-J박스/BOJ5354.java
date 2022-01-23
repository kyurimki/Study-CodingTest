import java.io.*;

public class BOJ5354 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(j == 0 || j == n-1 || k == 0 || k == n-1)
                        sb.append('#');
                    else sb.append('J');
                }
                sb.append('\n');
            }
            System.out.println(sb);
        }
    }
}