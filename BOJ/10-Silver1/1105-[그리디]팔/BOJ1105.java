import java.io.*;
import java.util.*;

public class BOJ1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();

        int answer = 0;
        if(L.length() == R.length()) {
            for(int i = 0; i < L.length(); i++) {
                if(L.charAt(i) == R.charAt(i)) {
                    if(L.charAt(i) == '8')
                        answer++;
                } else
                    break; // 각 자리를 비교하는 데 앞선 자리가 다르다면 그 뒤자리를 비교할 필요 X
            }
        }
        System.out.println(answer);
    }
}