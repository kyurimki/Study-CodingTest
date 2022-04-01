import java.util.*;

class Spot13549 {
    int id;
    int time;

    public Spot13549(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

public class BOJ13549 {
    static int N, K;
    static int[] time;
    static Queue<Spot13549> q;

    static int inf = 100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        time = new int[inf];
        time[N] = 1;
        
        q = new LinkedList<>();
        q.add(new Spot13549(N, 1));

        bfs();
        System.out.println(time[K]-1);

        sc.close();
    }

    public static void bfs() {

        while(!q.isEmpty()) {
            Spot13549 x = q.poll();
            
            if(x.id+1 >= 0 && x.id+1 < inf) {
                if(time[x.id+1] == 0 || time[x.id+1] > x.time+1) {
                    time[x.id+1] = x.time+1;
                    q.add(new Spot13549(x.id+1, x.time+1));
                }
            }
            if(x.id-1 >= 0 && x.id-1 < inf) {
                if(time[x.id-1] == 0 || time[x.id-1] > x.time+1) {
                    time[x.id-1] = x.time+1;
                    q.add(new Spot13549(x.id-1, x.time+1));
                }
            }
            if(x.id*2 >= 0 && x.id*2 < inf) {
                if(time[x.id*2] == 0 || time[x.id*2] > x.time) {
                    time[x.id*2] = x.time;
                    q.add(new Spot13549(x.id*2, x.time));
                }
            }
        }
    }
}