import java.io.*;
import java.util.*;

public class BOJ4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        HashMap<String, Integer> map = new HashMap<>();
        int size = 0;
        while(true) {
            String input = br.readLine();
            if(input == null || input.length() == 0) break;

            size++;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        
        for(Object key : keys) {
            double count = map.get((String)key);
            double answer = count / size * 100;
            sb.append(key + " " + String.format("%.4f", answer) + "\n");
        }
        System.out.println(sb);
    }
}