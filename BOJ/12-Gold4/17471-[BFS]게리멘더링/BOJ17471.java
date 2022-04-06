import java.io.*;
import java.util.*;

public class BOJ17471 {
    static int N;
    static int[] info;
    static ArrayList<ArrayList<Integer>> list;

    static int sub = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        info = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            info[i] = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for(int j = 0; j < size; j++) 
                list.get(i).add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 1; i <= N/2; i++)
            combination(1, i, new ArrayList<>());
            
        
        System.out.println(sub == Integer.MAX_VALUE ? -1 :sub);
    }

    private static void combination(int start, int limit, ArrayList<Integer> added) {
        if(limit == 0) {
            gerryMandering(added);
            return ;
        }

        for(int i = start; i <= N; i++) {
            added.add(i);
            combination(i+1, limit-1, added);
            added.remove(added.size()-1);
        }
    }

    private static void gerryMandering(ArrayList<Integer> added) {
        if(!isConnected(added)) return ;

        ArrayList<Integer> B = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(added.contains(i)) continue;
            B.add(i);
        }

        if(!isConnected(B)) return ;

        int sumA = 0;
        int sumB = 0;
        for(int a : added)
            sumA += info[a];
        for(int b : B)
            sumB += info[b];
        
        sub = Math.min(sub, Math.abs(sumA-sumB));
    }

    private static boolean isConnected(ArrayList<Integer> toSearch) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(toSearch.get(0));
        
        boolean[] visited = new boolean[N+1];
        visited[toSearch.get(0)] = true;

        int cnt = 1;
        while(!q.isEmpty()) {
            int x = q.poll();
            for(int y : list.get(x)) {
                if(!visited[y] && toSearch.contains(y)) {
                    visited[y] = true;
                    cnt++;
                    q.offer(y);
                }
            }
        }
        if(cnt == toSearch.size()) return true;
        return false;
    }
}