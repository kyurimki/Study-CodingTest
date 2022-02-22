import java.io.*;
import java.util.*;

public class BOJ1759 {
    static int L, C;
    static char[] set;

    static boolean[] visited;
    static List<Character> vowSet = Arrays.asList('a', 'e', 'i', 'o', 'u');

    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        set = new char[C];
        visited = new boolean[C];
        for(int i = 0; i < C; i++)
            set[i] = st.nextToken().charAt(0);
        
        Arrays.sort(set);

        combination(0, 0);
        System.out.println(sb);
    }

    private static void combination(int count, int start) {
        if(count == L) {
            int v = 0;
            int c = 0;
            String str = "";
            for(int i = 0; i < C; i++) {
                if(visited[i]) {
                    str += set[i];

                    if(vowSet.contains(set[i])) v++;
                    else c++;
                }
            }
            if(v > 0 && c > 1) sb.append(str).append('\n');
        }

        for(int i = start; i < C; i++) {
            visited[i] = true;
            combination(count+1, i+1);
            visited[i] = false;
        }
    }
}