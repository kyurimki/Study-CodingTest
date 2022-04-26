import java.util.*;

public class BOJ12851 {
    static int N, K;

    static int[] time = new int[100001];
    static int min = Integer.MAX_VALUE, count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if(N >= K)
            System.out.println((N-K) + "\n1");
        else {
            bfs();
            System.out.println(min + "\n" + count);
        }
        sc.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        time[N] = 1;

        while(!q.isEmpty()) {
            int x = q.poll();

            if(min < time[x]) return ;

            int[] move = {x-1, x+1, x*2};
            for(int i = 0; i < 3; i++) {
                int next = move[i];

                if(next < 0 || next >= time.length) continue;
                if(next == K) {
                    min = time[x];
                    count++;
                }

                if(time[next] == 0 || time[next] == time[x]+1) {
                    q.offer(next);
                    time[next] = time[x] + 1;
                }
            }
        }
    }
}