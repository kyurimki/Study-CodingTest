import java.io.*;
import java.util.*;

class Tank {
    int x;
    int y;
    int dir;

    public Tank(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getDir() {
        return dir;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setDir(int dir) {
        this.dir = dir;
    }
    
}

public class SWEA1873 {
    static int t, h, w, n;
    static char[][] field;
    static char[] command;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Tank tank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            
            field = new char[h][w];
            for(int i = 0; i < h; i++) {
                field[i] = br.readLine().toCharArray();
                for(int j = 0; j < field[i].length; j++) {
                    if(field[i][j] != '.' && field[i][j] != '*' && field[i][j] != '#' && field[i][j] != '-') {
                        if(field[i][j] == '^')
                            tank = new Tank(i, j, 0);
                        else if(field[i][j] == 'v')
                            tank = new Tank(i, j, 1);
                        else if(field[i][j] == '<')
                            tank = new Tank(i, j, 2);
                        else if(field[i][j] == '>')
                            tank = new Tank(i, j, 3);
                    }
                }
            }

            n = Integer.parseInt(br.readLine());
            command = br.readLine().toCharArray();

            battleField();

            System.out.print("#" + tc + " ");
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++)
                    System.out.print(field[i][j]);
                System.out.println();
            }
        }
    }

    private static void battleField() {
        for(int i = 0; i < n; i++) {
            switch(command[i]) {
                case 'U':
                    tank.setDir(0);
                    field[tank.getX()][tank.getY()] = '^';
                    checkMove();
                    break;
                case 'D':
                    tank.setDir(1);
                    field[tank.getX()][tank.getY()] = 'v';
                    checkMove();
                    break;
                case 'L':
                    tank.setDir(2);
                    field[tank.getX()][tank.getY()] = '<';
                    checkMove();
                    break;
                case 'R':
                    tank.setDir(3);
                    field[tank.getX()][tank.getY()] = '>';
                    checkMove();
                    break;
                case 'S':
                    shoot();
                    break;
            }
        }
    }

    private static boolean ifInField(int x, int y) {
        if(-1 < x && x < h && -1 < y && y < w)
            return true;

        return false;
    }

    private static void checkMove() {
        int cx = tank.getX() + dx[tank.getDir()];
        int cy = tank.getY() + dy[tank.getDir()];
        if(ifInField(cx, cy) && field[cx][cy] == '.') {
            field[cx][cy] = field[tank.getX()][tank.getY()];
            field[tank.getX()][tank.getY()] = '.';
            tank.setX(cx);
            tank.setY(cy);
        }
    }

    private static void shoot() {
        int depth = 1;
        while(true) {
            int cx = tank.getX() + depth * dx[tank.getDir()];
            int cy = tank.getY() + depth * dy[tank.getDir()];
            if(ifInField(cx, cy)) {
                if(field[cx][cy] == '*') {
                    field[cx][cy] = '.';
                    break;
                } else if(field[cx][cy] == '#')
                    break;
                depth++;
            } else
                break;
        }
    }
}