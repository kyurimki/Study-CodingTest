import java.io.*;
import java.util.*;

public class BOJ11931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] num = new Integer[Integer.parseInt(br.readLine())];
        for(int i = 0; i < num.length; i++) num[i] = Integer.parseInt(br.readLine());
        Arrays.sort(num, Collections.reverseOrder());

        for(Integer i : num) bw.write(i + "\n");
        bw.flush();
    }
}