import java.io.*;
import java.util.*;

public class BOJ5021 {
    static HashMap<String, String[]> tree;
    static HashMap<String, Double> portion;
    static String king;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new HashMap<>();
        portion = new HashMap<>();

        king = br.readLine();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent1 = st.nextToken();
            String parent2 = st.nextToken();

            tree.put(child, new String[]{parent1, parent2});
            portion.put(child, 0.0);
            portion.put(parent1, 0.0);
            portion.put(parent2, 0.0);
        }
        portion.put(king, 1.0);

        double max = 0;
        String answer = "";
        for(int i = 0; i < M; i++) {
            String candidate = br.readLine();
            double p = dfs(candidate);
            if(p > max) {
                max = p;
                answer = candidate;
            }
        }

        System.out.println(answer);
    }

    static double dfs(String name) {
        if(!tree.containsKey(name))
            return portion.getOrDefault(name, 0.0);
        
        String parent1 = tree.get(name)[0];
        String parent2 = tree.get(name)[1];
        double result = (dfs(parent1)+dfs(parent2)) / 2;

        portion.put(name, result);
        return result;
    }
}