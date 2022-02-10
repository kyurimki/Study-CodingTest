import java.io.*;
import java.util.*;

public class BOJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(calculate(a, b, c) % c);
    }

    private static long calculate(long a, long b, long c) {
        if(b == 0)
            return 1;
        else if(b == 1)
            return a;
        else if(b % 2 == 0) {
            long x = calculate(a, b/2, c) % c;
            return (x * x) % c;
        } else {
            long x = calculate(a, b/2, c) % c;
            return ((x * x) % c * a) % c;
        }
    }
}