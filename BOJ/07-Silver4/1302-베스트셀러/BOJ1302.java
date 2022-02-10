import java.io.*;
import java.util.*;

public class BOJ1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if(map.containsKey(input))
                map.replace(input, map.get(input)+1);
            else
                map.put(input, 1);
        }

        String answer = "";
        int max = 0;
        for(String key : map.keySet()) {
            int count = map.get(key);

            if((max < count) || (max == count && answer.compareTo(key) > 0)) {
                answer = key;
                max = count;
            }
        }
        System.out.println(answer);
    }
}