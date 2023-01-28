import java.io.*;
import java.util.*;

class Egg16987 {
    int durability, weight;

    Egg16987(int durability, int weight) {
        this.durability = durability;
        this.weight = weight;
    }
}

public class BOJ16987 {
    static int maxCnt, N;
    static Egg16987[] eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxCnt = 0;
        N = Integer.parseInt(st.nextToken());
        eggs = new Egg16987[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            eggs[i] = new Egg16987(durability, weight);
        }

        crashEgg(0, 0);
        System.out.println(maxCnt);
    }

    public static void crashEgg(int cur, int crashed) {
        if(cur == N) {
            maxCnt = Math.max(maxCnt, crashed);
            return ;
        }

        if(eggs[cur].durability <= 0 || crashed == N-1) {
            crashEgg(cur+1, crashed);
            return ;
        }

        for(int i = 0; i < N; i++) {
            if(cur == i) continue;
            if(eggs[i].durability <= 0) continue;

            int count = 0;
            eggs[cur].durability -= eggs[i].weight;
            if(eggs[cur].durability <= 0) count++;
            eggs[i].durability -= eggs[cur].weight;
            if(eggs[i].durability <= 0) count++;

            crashEgg(cur+1, crashed+count);

            eggs[cur].durability += eggs[i].weight;
            eggs[i].durability += eggs[cur].weight;
        }
    }
}