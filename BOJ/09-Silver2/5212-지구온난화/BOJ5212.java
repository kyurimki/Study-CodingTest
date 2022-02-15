import java.io.*;
import java.util.*;

public class BOJ5212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 지도 크기 가로
        int C = Integer.parseInt(st.nextToken()); // 지도 크기 세로

        char[][] map = new char[R][C]; // 처음 지도
        char[][] future = new char[R][C]; // 50년 후 지도
        for(int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();
        
        // 50년 후 출력할 지도 범위
        int[] ranR = {R-1, 0};
        int[] ranC = {C-1, 0};
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'X') {
                    int seaCount = 0; // 땅의 삼면 이상이 바다인지 횟수
                    for(int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if(x == -1 || y == -1 || x == R || y == C || map[x][y] == '.')
                            seaCount++;
                    }

                    if(seaCount < 3) {
                        future[i][j] = 'X';
                        
                        // 출력해야 될 지도 범위 조정
                        ranR[0] = Math.min(ranR[0], i);
                        ranR[1] = Math.max(ranR[1], i);
                        ranC[0] = Math.min(ranC[0], j);
                        ranC[1] = Math.max(ranC[1], j);
                    } else // 삼면 이상이 바다
                        future[i][j] = '.';
                } else
                    future[i][j] = '.';
            }
        }
        for(int i = ranR[0]; i <= ranR[1]; i++) {
            for(int j = ranC[0]; j <= ranC[1]; j++)
                sb.append(future[i][j]);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}