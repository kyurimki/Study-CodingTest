import java.util.*;

public class BOJ1697 {
    static int N, K;
    static int[] time;

    static int inf = 100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        time = new int[inf];

        bfs();

        System.out.println(time[K]);

        sc.close();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(N);

        while(!q.isEmpty()) {
            int x = q.poll();
            if(x == K)
                return ;
            
            if(x > 0 && time[x-1] == 0) {
                q.offer(x-1);
                time[x-1] = time[x] + 1;
            }
            if(x < inf-1 && time[x+1] == 0) {
                q.offer(x+1);
                time[x+1] = time[x] + 1;
            }
            if(x*2 < inf && time[x*2] == 0) {
                q.offer(x*2);
                time[x*2] = time[x] + 1;
            }
        }
    }
}