import java.io.*;
import java.util.*;
import java.awt.Point;

public class SWEA1767 {
    static int N;
    static int[][] board;
    
    static ArrayList<Point> processors;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int minLength;
    static int maxCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            processors = new ArrayList<Point>();
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if(board[i][j] == 1 && i != 0 && j != 0 && i != (N-1) && j != (N-1))
                        processors.add(new Point(i, j));
                }
            }
            minLength = 0;
            maxCnt = 0;
            connect(0, 0, 0);
            sb.append("#" + t + " " + minLength + "\n");
        }
        System.out.print(sb);
    }

    private static void connect(int cnt, int coreCnt, int wireLength) {
        if(cnt == processors.size()) {
            if(maxCnt < coreCnt) {
                maxCnt = coreCnt;
                minLength = wireLength;
            } else if(maxCnt == coreCnt)
                minLength = Math.min(minLength, wireLength);
            return ;
        }

        Point p = processors.get(cnt);
        for(int i = 0; i < 4; i++) {
            int count = 0, cx = p.x, cy = p.y;

            while(true) {
                cx += dx[i];
                cy += dy[i];

                if(cx < 0 || cx >= N || cy < 0 || cy >= N) break;
                if(board[cx][cy] == 1) {
                    count = 0;
                    break;
                }
                count++;
            }

            if(count == 0)
                connect(cnt+1, coreCnt, wireLength);
            else {
                int tmpX = p.x;
                int tmpY = p.y;
                for(int j = 0; j < count; j++) {
                    tmpX += dx[i];
                    tmpY += dy[i];
                    board[tmpX][tmpY] = 1;
                }
                
                connect(cnt+1, coreCnt+1, wireLength+count);

                tmpX = p.x;
                tmpY = p.y;
                for(int j = 0; j < count; j++) {
                    tmpX += dx[i];
                    tmpY += dy[i];
                    board[tmpX][tmpY] = 0;
                }
            }
        }
    }
}