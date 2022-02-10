import java.io.*;
import java.util.*;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        Stack<int[]> building = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int b = Integer.parseInt(st.nextToken());

            while(!building.isEmpty()) {
                if(building.peek()[1] < b)
                    building.pop();
                else {
                    sb.append(building.peek()[0] + " ");
                    break;
                }
            }

            if(building.isEmpty()) sb.append("0 ");

            building.push(new int[] {i, b});
        }
        System.out.print(sb);
    }
}