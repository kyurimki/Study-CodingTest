import java.io.*;
import java.util.*;
import java.awt.Point;

public class BOJ3190 {
    static int N;
    static int[][] board;
    static ArrayList<Point> snake;
    static Queue<Point> direction;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 보드 크기
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine()); // 사과 개수
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            board[x][y] = 1;
        }

        direction = new LinkedList<>();
        int L = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int C = st.nextToken().charAt(0) == 'L' ? -1 : 1;
            direction.offer(new Point(X, C));
        }

        System.out.println(play(0, 0, 0));
    }

    private static int play(int x, int y, int dir) {
        int time = 0;
        snake = new ArrayList<>();
        snake.add(new Point(0, 0));
        
        while(true) {
            time++;
            int cx = x + dx[dir];
            int cy = y + dy[dir];

            if(isEnd(cx, cy)) return time;

            snake.add(new Point(cx, cy));
            if(board[cx][cy] == 1)
                board[cx][cy] = 0;
            else
                snake.remove(0);
            
            x = cx;
            y = cy;

            if(!direction.isEmpty() && time == direction.peek().x) {
                Point p = direction.poll();
                dir += p.y;
                if(dir < 0) dir += 4;
                dir %= 4;
            }
        }
    }

    private static boolean isEnd(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return true;

        for(int i = 0; i < snake.size(); i++) {
            Point p = snake.get(i);
            if(x == p.x && y == p.y) return true;
        }

        return false;
    }
}