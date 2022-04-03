import java.util.*;

public class BOJ5014 {
    static int F, S, G, U, D;
    static int visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        visited = new int[F+1];
        bfs();

        sc.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == G) {
                System.out.println(visited[cur]-1);
                return ;
            }
            if(cur+U <= F && visited[cur+U] == 0) {
                visited[cur+U] = visited[cur]+1;
                q.add(cur+U);
            }
            if(cur-D > 0 && visited[cur-D] == 0) {
                visited[cur-D] = visited[cur]+1;
                q.add(cur-D);
            }
        }
        if(visited[G] == 0) {
            System.out.println("use the stairs");
            return ;
        }
    }
}