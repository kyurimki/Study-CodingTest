import java.io.*;
import java.util.*;
import java.awt.*;

class BC {
    int x;
    int y;
    int c;
    int p;

    public BC(int x, int y, int c, int p) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.p = p;
    }
}

public class SWEA5644 {
    static Point A;
    static Point B;

    static int[] aMove;
    static int[] bMove;

    static ArrayList<BC>[][] board;
    static ArrayList<BC> bcList;

    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};

    static int answer;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 총 테스트케이스
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 총 이동 시간
            int AP = Integer.parseInt(st.nextToken()); // AP 개수

            board = new ArrayList[10][10];

            A = new Point(0, 0);
            B = new Point(9, 9);
            answer = 0;

            aMove = new int[M+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= M; i++)
                aMove[i] = Integer.parseInt(st.nextToken());
            
            bMove = new int[M+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= M; i++)
                bMove[i] = Integer.parseInt(st.nextToken());
            
            
            bcList = new ArrayList<>();
            for(int i = 0; i < AP; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken())-1;
                int Y = Integer.parseInt(st.nextToken())-1;
                int C = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());

                bcList.add(new BC(X, Y, C, P));
            }

            for(BC bc: bcList)
                coverage(bc);
            
            for(int i = 0; i <= M; i++) {
                move(i);
                charge();
            }
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.print(sb);
    }

    private static void coverage(BC bc) {
        boolean[][] visited = new boolean[10][10];
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(bc.x, bc.y));
        visited[bc.x][bc.y] = true;

        if(board[bc.x][bc.y] == null)
            board[bc.x][bc.y] = new ArrayList<>();
        
        board[bc.x][bc.y].add(bc);

        int coverage = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Point p = q.poll();
                int x = p.x;
                int y = p.y;

                for(int j = 1; j < 5; j++) {
                    int cx = x+dx[j];
                    int cy = y+dy[j];

                    if(isIn(cx, cy) && !visited[cx][cy]) {
                        if(board[cx][cy] == null)
                            board[cx][cy] = new ArrayList<>();
                        
                        board[cx][cy].add(bc);
                        visited[cx][cy] = true;
                        q.offer(new Point(cx, cy));
                    }
                }
            }
            coverage++;
            if(coverage == bc.c)
                break;
        }
    }

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x > 9 || y > 9) return false;
        return true;
    }

    private static void move(int i) {
        A.x += dx[aMove[i]];
        A.y += dy[aMove[i]];
        B.x += dx[bMove[i]];
        B.y += dy[bMove[i]];
    }

    private static void charge() {
        int max = Integer.MIN_VALUE;

        if(board[A.x][A.y] != null) {
            if(board[B.x][B.y] != null) {
                for(BC bcA : board[A.x][A.y]) {
                    for(BC bcB : board[B.x][B.y]) {
                        if(bcA.equals(bcB))
                            max = Math.max(max, bcA.p);
                        else
                            max = Math.max(max, bcA.p+bcB.p);
                    }
                }
            } else {
                for(BC bcA : board[A.x][A.y])
                    max = Math.max(max, bcA.p);
            }
        } else {
            if(board[B.x][B.y] != null) {
                for(BC bcB : board[B.x][B.y]) 
                    max = Math.max(max, bcB.p);
            } else
                max = 0;
        }
        answer += max;
    }
}