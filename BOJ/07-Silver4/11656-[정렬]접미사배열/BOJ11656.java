import java.io.*;
import java.util.*;

public class BOJ11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String[] arr = new String[input.length()];
        for(int i = 0; i < input.length(); i++)
            arr[i] = input.substring(i);
        
        Arrays.sort(arr);

        for(String s : arr)
            sb.append(s).append('\n');
        System.out.println(sb);
    }
}