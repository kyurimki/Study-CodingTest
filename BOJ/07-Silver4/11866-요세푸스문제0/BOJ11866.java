import java.io.*;
import java.util.*;

public class BOJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append('<');

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken())-1;

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);
        
        int idx = k;
        while(true) {
            sb.append(list.remove(idx));

            if(list.size() == 0) break;

            sb.append(", ");
            idx += k;
            idx %= list.size();
        }
        sb.append('>');

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}