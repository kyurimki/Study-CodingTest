import java.io.*;
import java.util.*;

public class SWEA6808 {
    static int[] X; // 규영 카드
    static boolean[] chosen;

    static int winCount; // 규영 승리 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int total = 9*8*7*6*5*4*3*2; // 전체 경우의 수

        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        for(int t = 1; t <= T; t++) {
            X = new int[9]; 
            chosen = new boolean[19];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9; i++) {
                X[i] = Integer.parseInt(st.nextToken());
                chosen[X[i]] = true;
            }

            winCount = 0;
            permutation(0, 0, 0);

            sb.append("#" + t + " " + winCount + " " + (total-winCount) + "\n");
        }
        System.out.print(sb);
    }

    // cnt: 횟수, xScore: 규영 점수, yScore: 인영 점수
    private static void permutation(int cnt, int xScore, int yScore) {
        if(cnt == 9) {
            if(xScore > yScore)
                winCount++;

            return ;
        }
        
        for(int i = 1; i <= 18; i++) {
            if(chosen[i]) continue;

            chosen[i] = true;

            int score = X[cnt] + i;
            if(X[cnt] >= i) // 규영 카드 > 인영 카드
                permutation(cnt+1, xScore+score, yScore);
            else  // 규영 카드 < 인영 카드
                permutation(cnt+1, xScore, yScore+score);

            chosen[i] = false;
        }
    }
}