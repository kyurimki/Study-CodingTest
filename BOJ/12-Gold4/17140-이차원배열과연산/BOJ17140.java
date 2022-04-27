import java.io.*;
import java.util.*;
import java.awt.*;

public class BOJ17140 {
    static int r, c;
    static int[][] A;

    static int rsize, csize;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        int k = Integer.parseInt(st.nextToken());

        A = new int[100][100];
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        rsize = 3; csize = 3;
        while(A[r][c] != k) {
            if(time > 100) {
                System.out.println(-1);
                return ;
            }
            calc();
        }
        System.out.println(time);
    }

    private static void calc() {
        time++;
        int[] count;
        if(rsize >= csize) {
            for(int i = 0; i < rsize; i++) {
                count = new int[101];
                for(int j = 0; j < csize; j++)
                    count[A[i][j]]++;

                ArrayList<Point> list = new ArrayList<>();
                for(int j = 1; j < count.length; j++) {
                    if(count[j] != 0)
                        list.add(new Point(j, count[j]));
                }
    
                Collections.sort(list, new Comparator<Point>() {
                    @Override
                    public int compare(Point o1, Point o2) {
                        if(o1.y == o2.y)
                            return o1.x-o2.x;
                        return o1.y-o2.y;
                    }
                });
                int[] tmp = new int[100];
                int idx = 0;
                for(Point p : list) {
                    if(idx >= 100) break;
                    tmp[idx] = p.x;
                    tmp[idx+1] = p.y;
                    idx += 2;
                }
                csize = Math.max(csize, idx);
                A[i] = tmp;
            }
        } else {
            for(int i = 0; i < csize; i++) {
                count = new int[101];
                for(int j = 0; j < rsize; j++)
                    count[A[j][i]]++;

                ArrayList<Point> list = new ArrayList<>();
                for(int j = 1; j < count.length; j++) {
                    if(count[j] != 0)
                        list.add(new Point(j, count[j]));
                }
    
                Collections.sort(list, new Comparator<Point>() {
                    @Override
                    public int compare(Point o1, Point o2) {
                        if(o1.y == o2.y)
                            return o1.x-o2.x;
                        return o1.y-o2.y;
                    }
                });
                int[] tmp = new int[100];
                int idx = 0;
                for(Point p : list) {
                    if(idx >= 100) break;
                    tmp[idx] = p.x;
                    tmp[idx+1] = p.y;
                    idx += 2;
                }
                rsize = Math.max(rsize, idx);
                for(int j = 0; j < rsize; j++)
                    A[j][i] = tmp[j];
            }
        }
    }
}