import java.io.*;
import java.util.*;

public class BOJ1427 {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        char[] num = st.nextToken().toCharArray();
        Arrays.sort(num);

        for(int i = num.length-1; i >= 0; i--)
            System.out.print(num[i]);
    }
}