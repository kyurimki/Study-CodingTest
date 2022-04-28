import java.io.*;
import java.util.*;

public class BOJ1477 {
    static int M;
    static ArrayList<Integer> rest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        rest = new ArrayList<>();
        rest.add(0);
        rest.add(L);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            rest.add(Integer.parseInt(st.nextToken()));
        
        Collections.sort(rest);

        int start = 1;
        int end = L-1;
        while(start <= end) {
            int mid = (start+end) / 2;
         
            if(check(mid)) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(start);
    }

    private static boolean check(int term) {
        int cnt = 0;
        for(int i = 1; i < rest.size(); i++) {
            int dist = rest.get(i)-rest.get(i-1)-1;
            cnt += dist / term;
        }

        if(cnt > M) return true;
        return false;
    }
}