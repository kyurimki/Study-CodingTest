import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ17822 {
    static int N, M;
    static int[][] disk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        disk = new int[N+1][M];
        for(int i = 1 ; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
                disk[i][j] = Integer.parseInt(st.nextToken());
        }

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(!numLeft()) {
                System.out.println(0);
                return ;
            }
            rotate(x, d, k);
        }
        System.out.println(sum());
    }

    private static void rotate(int x, int d, int k) {
        int[] tmp;
        for(int xx = x; xx <= N; xx += x) {
            tmp = new int[M];
            for(int i = 0; i < M; i++) {
                if(d == 0) tmp[(i+k)%M] = disk[xx][i];
                else tmp[(i-(k%M)+M)%M] = disk[xx][i];
            }
            disk[xx] = tmp;
        }

        find();
    }

    private static boolean numLeft() {
        for(int i = 1 ; i <= N; i++) {
            for(int j = 0; j < M; j++)
                if(disk[i][j] != 0) return true;
        }
        return false;
    }

    private static void find() {
        HashSet<Point> set = new HashSet<>();
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < M; j++) {
                if(disk[i][j] == 0) continue;

				int cj = j+1 == M ? 0 : j+1;
				if(disk[i][j] == disk[i][cj])
					set.add(new Point(i, cj));

				cj = j-1 == -1 ? M-1 : j-1;
				if(disk[i][j] == disk[i][cj])
					set.add(new Point(i, cj));
				
				if(i+1 <= N && disk[i][j] == disk[i+1][j])
					set.add(new Point(i+1, j));
				
				if(i-1 >= 1 && disk[i][j] == disk[i-1][j])
					set.add(new Point(i-1, j));
            }
        }
        if(set.isEmpty()) {
            double sum = 0;
            int count = 0;
            for(int i = 1 ; i <= N; i++) {
                for(int j = 0; j < M; j++) {
                    if(disk[i][j] != 0) {
                        sum += disk[i][j];
                        count++;
                    }
                }
            }
            double avg = sum / count;
            for(int i = 1 ; i <= N; i++) {
                for(int j = 0; j < M; j++) {
                    if(disk[i][j] != 0) {
                        if(disk[i][j] > avg) disk[i][j] -= 1;
                        else if(disk[i][j] < avg) disk[i][j] += 1;
                    }
                }
            }
        } else {
            for(Object o : set.toArray()) {
                Point p = (Point)o;
                disk[p.x][p.y] = 0;
            }
        }
    }
    
    private static int sum() {
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < M; j++)
                sum += disk[i][j];
        }
        return sum;
    }
}