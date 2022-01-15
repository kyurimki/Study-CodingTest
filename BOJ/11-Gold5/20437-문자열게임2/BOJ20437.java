import java.io.*;

public class BOJ20437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if(k == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alphabet = new int[26];
            for(int j = 0; j < w.length(); j++)
                alphabet[w.charAt(j) - 'a']++;
            
            
            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int j = 0; j < w.length(); j++) {
                if(alphabet[w.charAt(j)-'a'] < k) continue;

                int count = 1;
                for(int l = j+1; l < w.length(); l++) {
                    if(w.charAt(j) == w.charAt(l)) count++;
                    if(count == k) {
                        min = Math.min(min, l-j+1);
                        max = Math.max(max, l-j+1);
                        break;
                    }
                }
            }
            
            System.out.println((min == Integer.MAX_VALUE || max == -1) ? -1 : min + " " + max);
        }
    }
}
