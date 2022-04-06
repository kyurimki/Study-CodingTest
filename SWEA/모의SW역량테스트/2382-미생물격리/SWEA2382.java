import java.io.*;
import java.util.*;

class Micro2382 {
    int count, dir;

    public Micro2382(int count, int dir) {
        this.count = count;
        this.dir = dir;
    }
}

public class SWEA2382 {
    static int N, M, K;
    static Queue<Micro2382>[][] board;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            board = new LinkedList[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++)
                    board[i][j] = new LinkedList<>();
            }

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken())-1;
                board[x][y].offer(new Micro2382(c, d));
            }

            for(int i = 0; i < M; i++)
                move();
            
            int sum = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(board[i][j].size() != 0)
                        sum += board[i][j].peek().count;
                }
            }
            sb.append("#" + t + " " + sum + "\n");
        }
        System.out.print(sb);
    }

    @SuppressWarnings("unchecked")
    private static void move() {
        Queue<Micro2382>[][] tmp = new LinkedList[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                tmp[i][j] = new LinkedList<>();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                while(!board[i][j].isEmpty()) {
                    Micro2382 m = board[i][j].poll();
                    int cx = i + dx[m.dir];
                    int cy = j + dy[m.dir];
                    if(cx == 0 || cy == 0 || cx == N-1 || cy == N-1)
                        tmp[cx][cy].offer(new Micro2382(m.count/2, m.dir/2*2+(m.dir+1)%2));
                    else
                        tmp[cx][cy].offer(m);
                }
            }
        }

        board = tmp;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j].size() > 1) {
                    int sum = 0;
                    int max = 0;
                    int d = 0;
                    while(!board[i][j].isEmpty()) {
                        Micro2382 m = board[i][j].poll();
                        sum += m.count;
                        if(max < m.count) {
                            max = m.count;
                            d = m.dir;
                        }
                    }
                    board[i][j].offer(new Micro2382(sum, d));
                }
            }
        }
    }
}
