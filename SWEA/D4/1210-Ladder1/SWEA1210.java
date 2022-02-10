import java.io.*;

public class SWEA1210 {
    static int[] dx = {-1, 1, 0};
    static int[] dy = {0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = 10;
        while(t-- > 0) {
            int tc = Integer.parseInt(br.readLine());

            
            String[][] ladder = new String[100][100];
            boolean[][] visited = new boolean[100][100];
            for(int i = 0; i < 100; i++) 
                ladder[i] = br.readLine().split(" ");

            int x = 0, y = 99;    
            for(int j = 0; j < 100; j++) {
                if(ladder[99][j].equals("2")) {
                    x = j;
                    int nx = 100;
                    int ny = 100;

                    while(ny != 0) {
                        for(int k = 0; k < 3; k++) {
                            nx = x + dx[k];
                            ny = y + dy[k];
                            if(!isIn(nx, ny)) continue;
                            if(ladder[ny][nx].equals("1") && !visited[ny][nx]) {
                                x = nx;
                                y = ny;
                                visited[y][x] = true;
                                break;
                            }
                        }
                    }
                    sb.append("#" + tc + " " + nx + '\n');
                    break;
                }
            }   
        }
        System.out.print(sb);
    }

    private static boolean isIn(int x, int y) {
        if(-1 < x && x < 100 && -1 < y && y < 100) return true;
        return false;
    }
}