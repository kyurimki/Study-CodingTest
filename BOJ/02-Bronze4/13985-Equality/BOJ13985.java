import java.io.*;
import java.util.*;

public class BOJ13985 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String op = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        String eq = st.nextToken();
        int c = Integer.parseInt(st.nextToken());

        System.out.println(a+b == c ? "YES" : "NO");
    }
}