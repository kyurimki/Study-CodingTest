import java.io.*;
import java.util.*;
import java.awt.*;

class Fish {
    int x, y, d;

    public Fish(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class BOJ23290 {
    static Queue<Fish> fishList;
    static Point shark;
    static Queue<Integer>[][] fishBoard;
    static Queue<Integer>[][] smell;
    static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static int[][] d = {{}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static Queue<int[]> q;
    static int[] maxMove;
    static int max;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fishBoard = new LinkedList[4][4];
        smell = new LinkedList[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                fishBoard[i][j] = new LinkedList<>();
                smell[i][j] = new LinkedList<>();
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int x, y;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            fishBoard[x][y].offer(d);
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken())-1;
        y = Integer.parseInt(st.nextToken())-1;
        shark = new Point(x, y);

        while(S-- > 0) {
            simulation();
        }

        int sum = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                sum += fishBoard[i][j].size();
            }
        }
        System.out.println(sum);
    }

    private static void simulation() {
        // 1. 물고기 복제
        fishList = new LinkedList<>();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int fsize = fishBoard[i][j].size();
                for(int k = 0; k < fsize; k++) {
                    int d = fishBoard[i][j].poll();
                    fishList.offer(new Fish(i, j, d));
                    fishBoard[i][j].offer(d);
                }
            }
        }

        // 2. 물고기 이동
        fishBoard = fishMove();

        // 3. 상어 이동
        int[] dir = {1, 2, 3, 4};
        max = Integer.MIN_VALUE;
        maxMove = new int[3];
        permutation(dir, new int[3], 0, 3);
        
        int cx = shark.x;
        int cy = shark.y;

        for(int i = 0; i < 3; i++) {
            cx += d[maxMove[i]][0];
            cy += d[maxMove[i]][1];

            if(fishBoard[cx][cy].size() > 0) {
                fishBoard[cx][cy].clear();
                smell[cx][cy].offer(0);
            }
        }
        shark.x = cx;
        shark.y = cy;


        // 4. 2칸 전 냄새 제거
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int ssize = smell[i][j].size();
                if(ssize != 0) {
                    for(int k = 0; k < ssize; k++) {
                        int s = smell[i][j].poll();
                        if(s < 2) smell[i][j].offer(s+1);
                    }
                }
            }
        }
        // 5. 물고기 복제 완료
        while(!fishList.isEmpty()) {
            Fish f = fishList.poll();
            fishBoard[f.x][f.y].offer(f.d);
        }
    }

    @SuppressWarnings("unchecked")
    private static Queue<Integer>[][] fishMove() {
        Queue<Integer>[][] tmp = new LinkedList[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                tmp[i][j] = new LinkedList<>();
            }
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(fishBoard[i][j].size() != 0) {
                    while(!fishBoard[i][j].isEmpty()) {
                        int d = fishBoard[i][j].poll();
                        boolean flag = false;
                        int nd = 0;
                        for(int k = 8; k > 0; k--) {
                            nd = (d+k) % 8;
                            if(isOK(i, j, nd)) {
                                flag = true;
                                tmp[i+dir[nd][0]][j+dir[nd][1]].offer(nd);
                                break;
                            }
                        }
                        if(!flag) tmp[i][j].offer(d);
                    }
                }
            }
        }
        return tmp;
    }

    private static void permutation(int[] arr, int[] output, int cnt, int r) {
        if(cnt == r) {
            boolean[][] visited = new boolean[4][4];
            int cx = shark.x;
            int cy = shark.y;

            boolean flag = false;
            int sum = 0;
            for(int i = 0; i < 3; i++) {
                cx += d[output[i]][0];
                cy += d[output[i]][1];

                if(cx < 0 || cx >= 4 || cy < 0 || cy >= 4) {
                    flag = true;
                    break;
                }

                if(!visited[cx][cy])
                    sum += fishBoard[cx][cy].size();
                visited[cx][cy] = true;
            }
            if(!flag && max < sum) {
                max = sum;
                for(int j = 0; j < 3; j++)
                    maxMove[j] = output[j];
            }
            return ;
        }

        for(int i = 0; i < 4; i++) {
            output[cnt] = arr[i];
            permutation(arr, output, cnt+1, r);
        }
    }

    private static boolean isOK(int x, int y, int d) {
        int cx = x + dir[d][0];
        int cy = y + dir[d][1];

        if(cx < 0 || cy < 0 || cx >= 4 || cy >= 4) return false;
        if(cx == shark.x && cy == shark.y) return false;
        if(smell[cx][cy].size() != 0) return false;

        return true;
    }
}
