import java.io.*;
import java.util.*;

class Land16235 {
    int nutri;
    PriorityQueue<Integer> trees;

    public Land16235() {
        this.nutri = 5;
        trees = new PriorityQueue<>();
    }
}

public class BOJ16235 {
    static int n, m, k;
    static int[][] A;
    static Land16235[][] field;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        A = new int[n+1][n+1];
        field = new Land16235[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                field[i][j] = new Land16235();
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            field[x][y].trees.add(z);
        }

        int count = 0;
        for(int i = 0; i < k; i++) {
            simulation();

            count = countAlive();
            if(count == 0) break;
        }

        System.out.println(count);
    }

    private static void simulation() {
        autumn(springSummer());

        winter();
    }

    private static int[][] springSummer() {
        int[][] breedable = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                Land16235 land = field[i][j];
                PriorityQueue<Integer> tmp = new PriorityQueue<>();
                int breedableCount = 0;
                while(!land.trees.isEmpty() && land.nutri - land.trees.peek() >= 0) {
                    int age = land.trees.poll();
                    tmp.add(age+1);

                    if((age+1) % 5 == 0)
                        breedableCount += 1;

                        land.nutri -= age;
                }

                int deadNutri = 0;
                while(!land.trees.isEmpty())
                    deadNutri += (int)(land.trees.poll()/2);
                
                    land.trees = tmp;
                    land.nutri += deadNutri;
                breedable[i][j] = breedableCount;
            }
        }
        return breedable;
    }

    private static void autumn(int[][] breedable) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(breedable[i][j] == 0)
                    continue;

                for(int l = 0; l < 8; l++) {
                    int cx = i + dx[l];
                    int cy = j + dy[l];
                    int newTree = breedable[i][j];
                    
                    if(!isInField(cx, cy)) continue;

                    while(newTree-- > 0)
                        field[cx][cy].trees.add(1);
                }
            }
        }
    }

    private static void winter() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++)
                field[i][j].nutri += A[i][j];
        }
    }



    private static int countAlive() {
        int alive = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                alive += field[i][j].trees.size();
            }
        }
        return alive;
    }

    private static boolean isInField(int x, int y) {
        if(0 < x && x <= n && 0 < y && y <= n)
            return true;
        return false;
    }
}