import java.io.*;
import java.util.*;

public class BOJ10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][4];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine().split(" ");
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                if(Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
                    if(Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])) {
                        if(Integer.parseInt(s1[3]) == Integer.parseInt(s2[3])) {
                            return s1[0].compareTo(s2[0]);
                        }
                        return Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3]));
                    }
                    return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));
                }
                return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1]));
            }
        });

        for(int i = 0; i < n; i++) System.out.println(arr[i][0]);
    }
}