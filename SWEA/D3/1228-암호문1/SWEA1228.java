import java.io.*;
import java.util.*;

public class SWEA1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        
        for(int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            
            List<Integer> passcode = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            while(n-- > 0)
                passcode.add(Integer.parseInt(st.nextToken()));
            
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            while(k-- > 0) {
                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                for(int l = 0; l < y; l++)
                    passcode.add(x+l, Integer.parseInt(st.nextToken()));
            
            }

            int count = 0;
            sb.append("#" + t + " ");
            while(!passcode.isEmpty()) {
                if(count > 9) break;
                sb.append(passcode.get(count) + " ");
                count++;
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}