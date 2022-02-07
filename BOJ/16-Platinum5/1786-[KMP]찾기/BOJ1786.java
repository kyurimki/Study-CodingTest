import java.io.*;
import java.util.*;

public class BOJ1786 {
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String origin = br.readLine();
        String pattern = br.readLine();
        list = new ArrayList<>();
        
        kmp(origin, pattern);

        for(int l : list)
            sb.append(l).append(' ');
        
        System.out.println(list.size());
        System.out.println(sb);
    }

    private static void kmp(String origin, String pattern) {
        int[] pi = getPi(pattern);
        int patLen = pattern.length();
        int oriLen = origin.length();
        int j = 0;

        for(int i = 0; i < oriLen; i++) {
            while(j > 0 && origin.charAt(i) != pattern.charAt(j))
                j = pi[j-1];
            
            if(origin.charAt(i) == pattern.charAt(j)) {
                if(j+1 == patLen) {
                    list.add(i-patLen+2);
                    j = pi[j];
                } else
                    j++;
            }
        }

    }

    private static int[] getPi(String pattern) {
        int n = pattern.length();
        int[] pi = new int[n];
        int j = 0;

        for(int i = 1; i < n; i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = pi[j-1];
            
            if(pattern.charAt(i) == pattern.charAt(j))
                pi[i] = ++j;
        }

        return pi;
    }
}
