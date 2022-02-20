import java.io.*;
import java.util.*;

class Pillar implements Comparable<Pillar> {
    int start;
    int height;

    public Pillar(int start, int height) {
        this.start = start;
        this.height = height;
    }

    @Override
    public int compareTo(Pillar o) {
        return this.start-o.start;
    }
}

public class BOJ2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Pillar> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int n = N;

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            list.add(new Pillar(L, H));
        }

        Collections.sort(list);
        
        int sum = 0;
        int idx = 0;
        Pillar p = list.get(0);
        for(int i = 1; i < N; i++) {
            if(p.height <= list.get(i).height) {
                sum += (list.get(i).start-p.start) * p.height;
                p = list.get(i);
                idx = i;
            }
        }

        p = list.get(N-1);
        for(int i = N-2; i >= idx; i--) {
            if(p.height <= list.get(i).height) {
                sum += (p.start-list.get(i).start) * p.height;
                p = list.get(i);
            }
        }

        sum += p.height;
        System.out.println(sum);
    }
}